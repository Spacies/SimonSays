package simonsays.gameModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
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
    
    // The input list of integers representing responses to the
    // game questions.
    private List<Integer> inputList = new LinkedList<>();

    public Input()
    {
        // Commented out and replaced with receive input for cross
        // cross-platform compatibility.
        
        //handleInput();
        
        receiveInput();
    }

    // This code is not cross-platform compatible!
    private void handleInput()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        char rawInput;
        while(input.length() < 10)
        {
            try { 
                rawInput = (char)reader.read();                  
                if(rawInput>48 && rawInput<53)
                {
                    if(rawInput==49)
                        input += "1"; 
                    if(rawInput==50)
                        input += "2";
                    if(rawInput==51)
                        input += "3";
                    if(rawInput==52)
                        input+= "4";
                }  
                else if((rawInput<49||rawInput>52)&&rawInput!=10)
                    System.out.println("Invalid Input");
            } catch (IOException ex) {
                Logger.getLogger(Input.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
            
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
                //Alternate code for sleeping thread. Intelligible time units
                TimeUnit.MILLISECONDS.sleep(1500);
            } 
            catch(InterruptedException ex) {
                //Handles any exceptions cause by interrupting the thread above
                Thread.currentThread().interrupt();
            } 
        }           
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");         
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
                // Need to press enter to pass input.
                // Add entered input to inputList.
                if (line.equals("1"))
                {
                    toneC.playNPause();
                    inputList.add(1);
                }
                else if (line.equals("3"))
                {
                    toneE.playNPause();
                    inputList.add(3);
                }
                else if (line.equals("5"))
                {
                    toneG.playNPause();
                    inputList.add(5);
                }
                else if (line.equals("7"))
                {
                    toneB.playNPause();
                    inputList.add(7);
                }

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
    
    /**
     * Gets the input list of integers.
     * 
     * @return List<Integer> The input List of integers.
     */
    public List<Integer> getInputList()
    {
        
        return inputList;
        
    }
    
} 


