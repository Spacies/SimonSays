package simonsays.gameModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is a class that handles the input and the various rules involved    
 * with accepting the input in the SimonSays game
 * 
 * @author Jaimes Booth & Sam McGarvey
 * @version 22/03/2014
 */
public class Input {
    // The four game tones
    final MakeSound toneC = new MakeSound("file:C4_262Hz_1S.wav");
    final MakeSound toneE = new MakeSound("file:E4_330Hz_1S.wav");
    final MakeSound toneG = new MakeSound("file:G4_392Hz_1S.wav");
    final MakeSound toneB = new MakeSound("file:B3_247Hz_1S.wav");
    

    public Input()
    {
        // Commented out and replaced with recive input for cross
        // cross-platform compatibility.
        //handleInput();
        
        receiveInput();
    }

    // This code is not cross-platform compatible!
    private void handleInput()
    {
        //Creates a local instance of BufferedReader with new instance of 
        //InputStreamReader as a parameter
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Declare and intialise an empty string to hold input
        String input = "";
        //Declare a local variable to hold raw input
        char rawInput;
        //Loop to be used to accept input until condition met
        //To be compared against length of output
        while(input.length() < 1)
        {
            try { 
                //Accept raw character input
                rawInput = (char)reader.read();  
                //Checks if raw input is between characters for keyboard 1-4
                if(rawInput>48 && rawInput<53)
                {
                    //Adds 1-4 to input string matching raw char input
                    if(rawInput==49)
                        input += "1"; 
                    if(rawInput==50)
                        input += "2";
                    if(rawInput==51)
                        input += "3";
                    if(rawInput==52)
                        input+= "4";
                }  
                //Prints invalid input if another key is pushed (ignores enter key)
                else if((rawInput<49||rawInput>52)&&rawInput!=10)
                    System.out.println("Invalid Input");
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
        //Iterates through input string playing tone corresponding to each 
        //element in order 
        for(int i = 0; i<input.length();i++)
        {
            if(input.charAt(i)==49)
                toneC.playNPause();
            else if(input.charAt(i)==50)
                toneE.playNPause();
            else if(input.charAt(i)==51)
                toneG.playNPause();
            else if(input.charAt(i)==52)
                toneB.playNPause();
            try 
            {
                //Pauses program after each tone is played for 1.5 seconds so tones
                //are played individually
                TimeUnit.MILLISECONDS.sleep(1500);
            } 
            catch(InterruptedException ex) {
                //Handles any exceptions cause by interrupting the thread above
                Thread.currentThread().interrupt();
            } 
        } 
        //Prints 16 new line characters to clear console
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");         
    }
    
    
    /**
     * This is a temproary input method to be used for demonstration purposes
     * 
     * This is to be used until Windows/OSX complatability issues from other
     * method have been fixed for Sprint 2 demonstration
     * 
     * This method will be designed to handle a single input as to show the 
     * basic concept in the game and the basic structure of how the game
     * should operate 
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


