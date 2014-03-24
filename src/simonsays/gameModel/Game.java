package simonsays.gameModel;

import java.util.List;

/**
 * This is the class that knows the Simon Says game rules and enforces these
 * rules
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 17/03/2014
 */
public class Game 
{    
    Output output;
    Input input;
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
        output = new Output();  
        input = new Input();
        
        // Compare input and output string
        compareInOutput();
        
    }
    
    /**
     * Compares the game's input with the game's output. If they don't
     * correlate, game ends.
     */
    protected void compareInOutput()
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
        
        if (listsMatch)
        {
        // All elements match
        System.out.println("Correct!");
        }
        else
        {
            // Game Over
            //state = GameState.GAMEOVER;
            System.out.println("Game over!");
        }
    }
    
}
