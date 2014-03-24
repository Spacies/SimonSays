package simonsays.gameModel;

/**
 * This is the class that knows the Simon Says game rules and enforces these
 * rules
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 17/03/2014
 */
public class Game 
{    
    private GameState state;
    private boolean isPlaying = true;
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
       while(isPlaying)
       {
           //This should probably be initialised elsewhere, will leave here
           //until menu is implemented
           state=GameState.STARTED;
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
                Output output = new Output();  
                Input input = new Input();
                //The win calculation will be calculated here and return a boolean
                boolean hasLost = false;
                //Conditional statement to be triggered once game is reported 
                //as being lost
                if(hasLost)
                    state=GameState.GAMEOVER;
                //Temporary code to trigger won state for demonstration purposes
                else
                    state=GameState.WON;
           }   
           //This loop will perform any operations required upon the game being 
           //lost, and will explicitly set the state back to STARTED to return to
           //the menu
           while(state==GameState.GAMEOVER)
           {
                hasLost();
                //Temporary program exit until menu and quit option completed
                System.exit(0);
           }
           //This loop is for demonstration purposes and is to handle a successful
           //demonstration round of SimonSays
           while(state==GameState.WON)
           {
                hasWon();
                //Temporary program exit until menu and quit option completed
                System.exit(0);
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
}
