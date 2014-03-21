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
 * @author Jaimes Booth & Sam McGarvey
 * @version 17/03/2014
 * @modified Jaimes
 *  Added the call to TestSoundGeneration class for testing purposes.
 *  Added keys 1,2,3,4 to correspond with different tones. Need to press enter 
 *  for program to register.
 */
public class Game 
{    
    
    TestSoundGeneration testSoundC;
    TestSoundGeneration testSoundE;
    TestSoundGeneration testSoundG;
    TestSoundGeneration testSoundB;
    
    /**
     * A new instance of Simon Says that begins producing output and 
     * accepting input
     */ 
    public Game() 
    {
        
        //testSoundC = new TestSoundGeneration("file:C4_262Hz_1S.wav");
        //TestSoundGeneration testSoundE = new TestSoundGeneration("file:E4_330Hz_1S.wav");
        //TestSoundGeneration testSoundG = new TestSoundGeneration("file:G4_392Hz_1S.wav");
        //TestSoundGeneration testSoundB = new TestSoundGeneration("file:B3_247Hz_1S.wav");
        //TestSoundGeneration testSoundCAgain = new TestSoundGeneration("file:C4_262Hz_1S.wav");
        //Temporary test of output object/output methods
        Output output = new Output();
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
        //Automatic fix by netbeans to handle IOExceptions using try-catch
        try 
        {         
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line = "";
            //Creates user-defined exit from method
            while (line.equalsIgnoreCase("quit") == false)
            {
                //Stores the typed input as a String variable
                line = in.readLine(); 
                
                // Check for press of button and play appropriate tone.
                // Need to press enter to pass input
                if (line.equals("1"))
                    testSoundC = new TestSoundGeneration("file:C4_262Hz_1S.wav");
                else if (line.equals("3"))
                    testSoundE = new TestSoundGeneration("file:E4_330Hz_1S.wav");
                else if (line.equals("5"))
                    testSoundG = new TestSoundGeneration("file:G4_392Hz_1S.wav");
                else if (line.equals("7"))
                    testSoundB = new TestSoundGeneration("file:B3_247Hz_1S.wav");
                
                        
                        
                //Temporary means of clearing screen within the netbeans IDE
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
                        + "\n\n\n");           
            }         
            in.close();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
}
