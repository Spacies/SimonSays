package simonsays.gameModel;

import java.util.List;
import java.util.Scanner;

/**
 * This is the class that knows the Simon Says game rules and enforces these
 * rules
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 17/03/2014
 * @version 24/03/2014
 *  Modified game to use game states
 *  Added compareInOutput()
 * @version 05/04/13 Jaimes
 *  Added calls to Highscore in Game() and hasLost()
 */
public class Game 
{    
    
    private GameState state = GameState.STARTED;
    private Output output;
    private Input input;
    private int menuInput;
    private boolean firstRound = true;
    private Highscore highscore = new Highscore();
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
        // Play welcome tones to orient the player's ear
        //output.playWelcomeSound();
        
        System.out.println("Welcome to Simon Says!");
        
        // Check highscore table exists
        if (!highscore.highscoreExists())
            // Create highscore table if it doesn't exist
            highscore.createHighscoreTable();
        
       while(state!=GameState.QUIT)
       {
           //This loop will contain menu elements and will be exited through
           //explicity setting the state to playing via selecting a "Start 
           //game" menu option
           while(state==GameState.STARTED)
           {
                UserInterface cui = new UserInterface();
                menuInput = cui.generateMenu();
                if(menuInput == 1)
                {
                    state=GameState.PLAYING;      
                }
                if(menuInput == 2)
                {
                    cui.printDivider();
                    System.out.println("Instructions placeholder!");
                }
                if(menuInput == 3)
                {
                    cui.printDivider();
                    System.out.println("Settings placeholder!");                 
                }
                if(menuInput == 4)
                {
                    cui.printDivider();
                    //System.out.println("High score placeholder!"); 
                    
                    // If highscore table doesn't exist
                    if (!highscore.highscoreExists())
                    {
                        //System.out.println("Table doesn't exist");
                        
                        //Create the highscore table
                        highscore.createHighscoreTable();
                    
                    }
                    
                    // Print the highscore table
                    highscore.printHighscore();
                }
                if(menuInput == 5)
                {
                    state=GameState.QUIT;
                }
           }
           //This loop will contain any code required to successfully play the
           //game until the game is lost (or won in the demo version)
           while(state==GameState.PLAYING)
           {
                //Create an instance of the output and input 
                if(firstRound)
                {
                    output = new Output();  
                    firstRound = false;
                }
                output.produceOutput();
                
                input = new Input(output);
                //The win calculation will be calculated here and return a boolean
                boolean inputCorrect = compareInOutput();
                //Conditional statement to be triggered once game is reported 
                //as being lost
                if(!inputCorrect)
                    //Changes game state to gameover when game lost
                    state=GameState.GAMEOVER;
           }   
           //This loop will perform any operations required upon the game being 
           //lost, and will explicitly set the state back to STARTED to return to
           //the menu
           while(state==GameState.GAMEOVER)
           {
                hasLost();

           }
       }
    }
    
    public void hasLost()
    {
        //A message to be printed to indicate the game was lost
        System.out.println("Sorry, you have lost the game!");
        firstRound = true;
        //This will change the game state so that the game returns to the menu
        //state=GameState.STARTED;
        
        // Check if the finalScore is a highscore
        // finalScore = the final output list - 1 with 0 as a minimum.
        int finalScore;
        List<Integer> outputList = output.getOutputList();
        finalScore = outputList.size() - 1;
        if (finalScore < 0)
            finalScore = 0;
        
        // If finalScore is a highscore
        if (highscore.checkIfHighscore(finalScore))
        {
            System.out.println("");
            System.out.println("Congratulations, you have made the top ten!");
            
            // Ask for handle
            
            // Get input
            Scanner scanner = new Scanner(System.in);
            
            // Start with invalid string to trigger the following while loop.
            String name = "Invalid";

        
            // Check whether handle is three characters in length  
            // If not, prompt the user for input again.
            while (name.length() != 3)
            {

                //Prompt for handle
                System.out.println("Please enter your Handle (exactly three characters)");

                name = scanner.next();

            }

            // Handle passed the 3 character check.
            // Add handle and score to the highscore table
            highscore.insertHighscore(name, finalScore);
            System.out.println(name + ", you have been immortalized on the "
                    + "highscore table with a score of " + finalScore);
        }
        state=GameState.STARTED;
    }
    
    /**
     * Compares the game's input with the game's output. If they don't
     * correlate, game ends.
     * @return listsMatch true if the lists match, otherwise false.
     */
    protected boolean compareInOutput()
    {
        
        // Get game's output list.
        
        List<Integer> outputList = output.getOutputList();
        List<Integer> inputList = input.getInputList();
        
        System.out.println("InputList = " + inputList);
        System.out.println("OutputList = " + outputList);
        
        boolean listsMatch = true;

        // Compare input and output string
        for (int element = 0; element < outputList.size(); element++)
        {
            // If not the same then end the game.
            if (!(inputList.get(element).equals(outputList.get(element))))
            {
                listsMatch = false;               
            }
        }        
        return listsMatch;
    }    
}
