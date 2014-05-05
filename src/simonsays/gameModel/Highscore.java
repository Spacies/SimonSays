
package simonsays.gameModel;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generates and manipulates a database of highscores for SimonSays
 * @author Jaimes Booth 1305390 & Sam McGarvey
 * @version 01/05/14
 * @version 05/05/14 Jaimes
 *  Debugged the methods to a working state.
 */
public class Highscore
{
    
    Connection conn = null;
    String url = "jdbc:derby://localhost:1527/SimonSaysDB";  //url of the DB host
    String username = "simonsays";  //your DB username
    String password = "simonsays";   //your DB password

    
    /**
     * Constructor of the Highscore class. Connects to the SimonSays database.
     */
    public Highscore()
    {
        try
        {
            // Creates instance of a Connection object
            conn = DriverManager.getConnection(url, username, password);
            
            // Notify of DB connection
            //System.out.println(url + " connected...");


        }
        catch(SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
    
    //Currently not used
    /**
     * Connects to the SimonSays database.
     */
    public void connectSimonSaysDB()
    {
        try
        {
            // Creates instance of a Connection object
            conn = DriverManager.getConnection(url, username, password);
            
            // Notify of DB connection
            System.out.println(url + " connected...");


        }
        catch(SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    /**
     * Checks whether a highscore table exists
     * @return boolean True if highscore table exists, false otherwise.
     */
    public boolean highscoreExists()
    {
        boolean highscoreExists = false;
        
        //System.out.println("Checking if HS exists");
        
        try
        {
            // links the statements to the specified database connection (conn)
            //Statement statement = conn.createStatement();

            
            // Create a variable for the table name
            String newTable = "Highscore";
            
            // Connect to the DB
            //connectSimonSaysDB();

            // Get the connection metadata
            DatabaseMetaData dbmd = conn.getMetaData();

            // Query the metadata for the table name highscore
            // enter result in resultSet.
            ResultSet rs = dbmd.getTables(null, null, newTable.toUpperCase(), null);
            
            // Check if the result set contains a reference to a (highscore) table
            if(rs.next())
            {
                // table exists
                highscoreExists = true;

            } 
            
            //rs.close();
            
        }
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
        
//        if (highscoreExists)
//            System.out.println("highscore table exists");
//        else
//            System.out.println("highscore table does not exist");
        
        return highscoreExists;
        
    }

    /**
     * Creates a new table called Highscore in SimonSaysDB and inserts 
     * 10 empty records into the Promotion table. 
     */
    public void createHighscoreTable()
    {
        
        //System.out.println("Reached createPromotionTable");

        try
        {
            // Connect to DB
            //connectSimonSaysDB();
            
            // links the statements to the specified database connection (conn)
            Statement statement = conn.createStatement();

            
            // Create a variable for the table name
            String newTable = "Highscore";


            // Better alternative code to check if table exists
            //http://stackoverflow.com/questions/5866154/how-to-create-table-if-it-doesnt-exist-using-derby-db

            // Get the connection metadata
            DatabaseMetaData dbmd = conn.getMetaData();

            // Retrieves a description of the tables available in the given catalog.
            // getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types)
            // http://docs.oracle.com/javase/7/docs/api/java/sql/DatabaseMetaData.html
            //ResultSet rs = dbmd.getTables(null, "MYSCHEMA", "MYTABLE", null);
            ResultSet rs = dbmd.getTables(null, null, newTable.toUpperCase(), null);
            
            // Check if the resultset does not contain a table with the specified name.
            // http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html#next()
            if(!rs.next())
            {
                // Doesn't contain table so create one

                // Creates table with specified columns
                String sqlCreateTable = "CREATE TABLE " + newTable + 
                        " (Rank INT, Name VARCHAR(3), Score INT)";

                statement.executeUpdate(sqlCreateTable);

                //System.out.println("Highscore table created");

                String sqlInsert = "INSERT INTO " + newTable + " VALUES " +
                        "(1, 'SAM', 0), " + // 1
                        "(2, 'ACE', 0), " + // 2
                        "(3, 'SAM', 0), " + // 3
                        "(4, 'ACE', 0), " + // 4
                        "(5, 'SAM', 0), " + // 5
                        "(6, 'ACE', 0), " + // 6
                        "(7, 'SAM', 0), " + // 7
                        "(8, 'ACE', 0), " + // 8
                        "(9, 'SAM', 0), " + // 9
                        "(10, 'ACE', 0) ";  // 10
                

                statement.executeUpdate(sqlInsert);

                //System.out.println("Empty records inserted into Highscore table");

            } 
            else
            {
                //System.out.println("table already exists");
            }
            
            //rs.close();
            
        }
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }

    }

    /**
     * Queries Name and Score from the Highscore table.
     * Holds the query result in a ResultSet object (rs), 
     * and returns the object. 
     * @return rs The result statement of the query
     */
    public ResultSet getHighscoreResultset()
    {

        ResultSet rs = null;
        
        try 
        {
            
            // Connect to DB
            //connectSimonSaysDB();
            
            // Create a statement object to use on this connection
            // make it updatable.
            //http://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
            Statement statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, 
                    ResultSet.CONCUR_UPDATABLE);
            
            String sqlQuery =
            "SELECT * " +
            "FROM HIGHSCORE ";
            
            rs = statement.executeQuery(sqlQuery);
            
            
            //System.out.println("Highscore resultSet created");
            
            //rs.close();
            
        }
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }

        return(rs);

    }

    
    /**
     * Prints getHighscore() result set.
     */
    public void printHighscore()
    {
   
        try 
        {

            ResultSet highscoreResultSet = getHighscoreResultset();
            
            System.out.println("HIGHSCORES:");
            System.out.println("************");
            
            // While there are records in the result set of the table
            while( highscoreResultSet.next() )
            {
                // Get the row values by specifying the columns
                int rank = highscoreResultSet.getInt("Rank");
                String name = highscoreResultSet.getString("Name");
                int score = highscoreResultSet.getInt("Score");
                        
                System.out.println(rank + " " + name + " " + score);
                
            }            
            
            //highscoreResultSet.close();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Highscore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Checks whether the specified score is a highscore
     * @param newScore The integer value of the score.
     * @return The boolean of whether the score is a highscore or not.
     */
    public boolean checkIfHighscore(int newScore)
    {
        boolean highscore = false;
        
        ResultSet tenthScoreResultSet;
        
        try 
        {
            // Connect to DB
            //connectSimonSaysDB();
            
            Statement statement = conn.createStatement();
            
            String sqlQuery =
            "SELECT * " +
            "FROM Highscore " +
            "WHERE Rank = 10";
            
            tenthScoreResultSet = statement.executeQuery(sqlQuery);
            
            
            //System.out.println("TenthHighscore resultSet created");
            
            int tenthHighscore = 0;
            
            // Get the row values by specifying the columns
            if (tenthScoreResultSet.next())
                tenthHighscore =  tenthScoreResultSet.getInt("Score");
            
            //System.out.println("Do I get to here?");
        
            // is score greater than #10 then newscore is a highscore?
            if (newScore > tenthHighscore)
            {
                highscore = true;
            }
            
            //System.out.println("Got through checkIfHighscore()");
            
        }
        catch (SQLException ex) 
        {
            System.err.println("SQLException in checkIfHighscore(): " + ex.getMessage());
        }
        
        
        return highscore;
    }
    
    
    /**
     * Inserts a specified new score into the appropriate
     * position in the highscore database, replacing the
     * previous value.
     * 
     * @param handle The name of the highscore user
     * @param newScore The value of the new score
     * 
     */
    public void insertHighscore(String handle, int newScore)
    {
        
        int newRank = 11;
        boolean scoreInserted = false;
        
        // Iterate over the result, starting from #1
        try 
        {
            
            // Connect to DB
            //connectSimonSaysDB();
            
            // links the statements to the specified database connection (conn)
            Statement statement = conn.createStatement();
            //Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
            //       ResultSet.CONCUR_UPDATABLE);
            //http://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html

            // Get the highscore result set
            ResultSet highscoreRS = getHighscoreResultset();

            // While there are records in the result set of the join table
            // and the new score hasn't been inserted
            while( highscoreRS.next() && !scoreInserted )
            {
                // Decrease the current row reference
                newRank -= newRank;
                
                // Get the row values by specifying the columns
                int rowScore = highscoreRS.getInt(3);
                
                if (newScore > rowScore)
                {
                    // Replace this row
                    // Insert name and score into the table
//                    String sqlInsert = "INSERT INTO Highscore VALUES " +
//                        "(" + newRank + ",'" + handle + "'," + newScore + ")";
                    
                    //int rank = highscoreRS.getInt("Rank");

                    
                    //String name = highscoreRS.getString("Name");
                    highscoreRS.updateObject("Name", handle);
                    
                    //int score = highscoreRS.getInt("Score");
                    highscoreRS.updateObject("Score", newScore);
                    
                    //statement.executeUpdate(sqlInsert);
                    
                    highscoreRS.updateRow();
                    // Why is specialPrice the same as price when printed here
                    // but correct when insterted in table?
                    //System.out.println(title + " , " + specialPrice);
                    
                    scoreInserted = true;
   
                }
                        
                //System.out.println(name + " " + score);
                
            }            
            
            //highscoreRS.close();
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Highscore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


