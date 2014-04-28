/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simonsays.gameModel;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Sam
 */
public class UserInterface {
    boolean menuSelected = false;
    
    public UserInterface()
    {
        
    }
    
    public int generateMenu()
    {
        //Print out menu options
        System.out.println("Please make a selection(1 - 5):");
        System.out.println("1. Start game");
        System.out.println("2. Instructions");
        System.out.println("3. Settings");
        System.out.println("4. High Scores");
        System.out.println("5. Exit"); 
        //Declare and initialise new scanner
        Scanner menuScanner = new Scanner(new InputStreamReader(System.in));
        //Declare and initalise int variable for storing menu input
        int menuInput = 0;
        //Loop to run while input is not valid
        while(menuInput < 1 || menuInput > 5)
        {
            //Check if input is integer
            if(menuScanner.hasNextInt())
            {
                //Store input as integer variable
                menuInput = menuScanner.nextInt(); 
                if(!(menuInput>0&&menuInput<6))
                {
                  System.out.println("Please enter a valid input");                  
                }
            }
            else
            {
                //Print out statement requesting valid input
                System.out.println("Please enter a valid input");
                //Move scanner to next line if input is not valid
                menuScanner.nextLine();
            }          
        }
        //menuScanner.close();
        return menuInput;      
    }
    
}
