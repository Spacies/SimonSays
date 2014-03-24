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
           
           while(state==GameState.STARTED)
           {
               //Code to handle the menu will be added later
               state=GameState.PLAYING;
           }
           while(state==GameState.PLAYING)
           {
                Output output = new Output();  
                Input input = new Input();
           }
           while(state==GameState.GAMEOVER)
           {
               hasLost();
           }
           while(state==GameState.WON)
           {
               hasWon();
           }
       }
        
        

    }
    
    public void hasWon()
    {
        System.out.println("Congratulations! You have won!");
        state=GameState.STARTED;
    }
    
    public void hasLost()
    {
        System.out.println("Sorry, you have lost the game!");
        state=GameState.STARTED;
    }
}
