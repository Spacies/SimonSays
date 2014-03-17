/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simonsays.gameModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the class that knows the Simon Says game rules and enforces these
 * rules
 * 
 * @author Jaimes Booth
 * @author Sam McGarvey
 * @version 17/03/2014
 * @modified Jaimes
 *  Added the call to TestSoundGeneration class for testing purposes.
 */
public class Game 
{    
    /**
     * A new instance of Simon Says that begins displaying output and accepting
     * input
     */ 
    public Game() 
    {
        
        TestSoundGeneration testSound = new TestSoundGeneration("file:C_262Hz_1S.wav");
        receiveInput();
        
    }
    
    /**
     * Code obtained from web - Input is typed into command line and then
     * stored as a string. Input is shown in command line as text, can 
     * abort through typing "quit" (See while clause)
     * 
     * Code complains re: declaring IOException, Netbeans suggests 
     * try-catch clause and automatically formatted.
     * 
     * Enter moves to next line and previous input remains. This will
     * continue until "Quit" is entered
     */
    private void receiveInput() 
    {
        try 
        {         
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = ""; 
            while (line.equalsIgnoreCase("quit") == false)
            {
                line = in.readLine();
            }
            
            in.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
