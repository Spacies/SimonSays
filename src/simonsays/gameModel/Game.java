package simonsays.gameModel;

import java.util.List;

/**
 * This is the class that knows the Simon Says game rules and enforces these
 * rules
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 17/03/2014
 * @version 24/03/2014
 *  Modified game to use game states
 *  Added compareInOutput()
 */
public class Game 
{    
    
    private GameState state = GameState.STARTED;
    private Output output;
    private Input input;
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
        
       while(state!=GameState.QUIT)
       {
           //This loop will contain menu elements and will be exited through
           //explicity setting the state to playing via selecting a "Start 
           //game" menu option
           while(state==GameState.STARTED)
           {
                //Code to handle the menu will be added later
                state=GameState.PLAYING;
           }
           //This loop will contain any code required to successfully play the
           //game until the game is lost (or won in the demo version)
           while(state==GameState.PLAYING)
           {
                //Create an instance of the output and input 
                output = new Output();  
                input = new Input(output);
                //The win calculation will be calculated here and return a boolean
                boolean inputCorrect = compareInOutput();
                //Conditional statement to be triggered once game is reported 
                //as being lost
                if(inputCorrect)
                    state=GameState.WON;                 
                //Temporary code to trigger won state for demonstration purposes
                else
                    state=GameState.GAMEOVER;
           }   
           //This loop will perform any operations required upon the game being 
           //lost, and will explicitly set the state back to STARTED to return to
           //the menu
           while(state==GameState.GAMEOVER)
           {
                hasLost();
                //Temporary program exit until menu and quit option completed
                state=GameState.QUIT;
           }
           //This loop is for demonstration purposes and is to handle a successful
           //demonstration round of SimonSays
           while(state==GameState.WON)
           {
                hasWon();
                //Temporary program exit until menu and quit option completed
                state=GameState.QUIT;
           }
       }
    }
    
    public void hasWon()
    {
        //A message to be printed to indicate the game was won - demo only
        System.out.println("Congratulations! You have won!");
    }
    
    public void hasLost()
    {
        //A message to be printed to indicate the game was lost
        System.out.println("Sorry, you have lost the game!");
        //This will change the game state so that the game returns to the menu
        //state=GameState.STARTED;
    }
    
    /**
     * Compares the game's input with the game's output. If they don't
     * correlate, game ends.
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
