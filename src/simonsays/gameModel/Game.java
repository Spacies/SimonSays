/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simonsays.gameModel;

/**
 * This is the class that knows the Simon Says game rules and enforces these
 * rules
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 17/03/2014
 * @modified Jaimes
 *  Added the call to TestSoundGeneration class for testing purposes.
 *  Added keys 1,2,3,4 to correspond with different tones. Need to press enter 
 *  for program to register.
 */
public class Game 
{    
    
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
        Output output = new Output();  
        Input input = new Input();
    }
}
