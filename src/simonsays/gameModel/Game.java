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
    private int menuInput;
    private boolean firstRound = true;
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
       //This loop continues looping through various state instances of program 
       //until explicitly changed to 'QUIT' state
       while(state!=GameState.QUIT)
       {
            //Create a user interface object 
            UserInterface cui = new UserInterface();
            //This loop contains code for producing a CUI menu and handling user
            //selections. This loop continues until the state is explicitly changed 
            //to either 'PLAYING' or 'QUIT'.
            while(state==GameState.STARTED)
            {
                //Call cui method for generating menu
                menuInput = cui.generateMenu();
                //Perform relevant action upon user menu selection
                //1 - Start Game, 2 - Print instructions, 3 - Print settings,
                //4 - High scores, 5 - Exit game               
                if(menuInput == 1)
                {
                    //Set state to playing, starting an instance of the game
                    state=GameState.PLAYING;      
                }
                if(menuInput == 2)
                {
                    //Print a divider and instructions placeholder
                    cui.printDivider();
                    cui.printInstructions();
                }
                if(menuInput == 3)
                {
                    //Print a divider and settings placeholder
                    cui.printDivider();
                    System.out.println("Settings placeholder!");                 
                }
                if(menuInput == 4)
                {
                    //Print a divider and a high scores place holder
                    cui.printDivider();
                    System.out.println("High score placeholder!");                   
                }
                if(menuInput == 5)
                {
                    //Change state to quit, terminating the program
                    state=GameState.QUIT;
                }
           }
           //This loop continues producing output and receiving input until the
           //state is explicitly changed to 'GAMEOVER'.
           while(state==GameState.PLAYING)
           {
                //Create an instance of the output and input 
                if(firstRound)
                {
                    //Create a new output object during first round
                    output = new Output();  
                    //Set first round to false so new output is not created again
                    firstRound = false;
                }
                //Begins printing relevant output and playing corresponding tones
                output.produceOutput();
                
                //Creates an input option passing the current output as a parameter
                input = new Input(output);
                //Calculates whether the user has matched input or not
                boolean inputCorrect = compareInOutput();
                //Conditional statement to be triggered once game is reported 
                //as being lost
                if(!inputCorrect)
                    //Changes game state to gameover when game lost
                    state=GameState.GAMEOVER;
           }   
           //This loop will perform any operations required upon the game being 
           //lost
           while(state==GameState.GAMEOVER)
           {
               cui.printDivider();
               hasLost();

           }
       }
    }
    
    public void hasLost()
    {      
        //A message to be printed to indicate the game was lost
        System.out.println("Sorry, you have lost the game!");
        //Sets variable to true so new output object is generated if user starts
        //another instance of the game from the menu
        firstRound = true;
        //This will change the game state so that the game returns to the menu
        state=GameState.STARTED;
    }
    
    /**
     * Compares the game's input with the game's output. If they don't
     * correlate, game ends.
     */
    protected boolean compareInOutput()
    {
        
        // Get game's output list.
        List<Integer> outputList = output.getOutputList();
        // Get game's input list.
        List<Integer> inputList = input.getInputList();
        
        //Temporary statements for printing input and output as sense check
        //System.out.println("InputList = " + inputList);
        //System.out.println("OutputList = " + outputList);
        
        //Creates an initialises a boolean variable to compare output
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
