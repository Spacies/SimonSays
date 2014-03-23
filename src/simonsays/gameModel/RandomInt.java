package simonsays.gameModel;

import java.util.Random;

/**
 * Creates a random tone to output to the Simon Says Game.
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 23/03/14
 */
public class RandomInt
{
    
    /**
     * The RandomInt Constructor method.
     */
    public RandomInt()
    {
        
            
    }
    
    /**
     * Generates a random int corresponding to a tone and adds it to the 
     * output array.
     * 
     * @return int The random integer to return.
     */
    public int generateRandomInt()
    {
        // Create a random number generator
        Random randomGenerator = new Random();
        
        
        // Generate one random integer between 1 and 4 
        // i.e. four possible outcomes.
        // Add 1 to generated number because range min (0) is inclusive
        // while max (4) is exclusive.
        int iRandomInt = randomGenerator.nextInt(4) + 1;
        
        return iRandomInt;
        
            
    }
    
     
    
    
}
