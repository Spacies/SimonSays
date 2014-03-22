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
 *  Added the call to MakeSound class for testing purposes.
 *  Added keys 1,2,3,4 to correspond with different tones. Need to press enter 
 *  for program to register.
 */
public class Game 
{    
    
    private MakeSound keySound; // The sound made when a key is pressed.
    
    // The four game tones
    final MakeSound toneC = new MakeSound("file:C4_262Hz_1S.wav");
    final MakeSound toneE = new MakeSound("file:E4_330Hz_1S.wav");
    final MakeSound toneG = new MakeSound("file:G4_392Hz_1S.wav");
    final MakeSound toneB = new MakeSound("file:B3_247Hz_1S.wav");
    
    /**
     * A new instance of Simon Says that begins accepting input
     */ 
    public Game() 
    {
        
        //Play a welcome sound sequence
        toneG.playNPause();
        toneE.playNPause();
        toneB.playNPause();
        toneC.playNPause();
        
        //testSoundC = new MakeSound("file:C4_262Hz_1S.wav");
        //testSoundE = new MakeSound("file:E4_330Hz_1S.wav");
        //TestSoundGeneration testSoundG = new MakeSound("file:G4_392Hz_1S.wav");
        //TestSoundGeneration testSoundB = new MakeSound("file:B3_247Hz_1S.wav");
        //TestSoundGeneration testSoundCAgain = new MakeSound("file:C4_262Hz_1S.wav");
        
        // Print string, pause and delete string
        System.out.print("1  2  3  4");
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.print("\b\b\b\b\b\b\b\b\b\b");
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
                    toneC.playNPause();
                else if (line.equals("3"))
                    toneE.playNPause();
                else if (line.equals("5"))
                    toneG.playNPause();
                else if (line.equals("7"))
                    toneB.playNPause();
                
                        
                        
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
