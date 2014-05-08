
package simonsays.gameModel;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Sam
 * @modified 05/05/14 Jaimes
 *  Added user prompt to generateMenu()
 */
public class UserInterface 
{
    private boolean menuSelected = false;
    
    public UserInterface()
    {
        
    }
    
    public int generateMenu()
    {
        //Print out menu options
        printDivider();
        System.out.println("Please make a selection(1 - 5):");
        System.out.println("1. Start game");
        System.out.println("2. Instructions");
        System.out.println("3. Settings");
        System.out.println("4. High Scores");
        System.out.println("5. Exit"); 
        printDivider();
        // User input prompt 
        System.out.print(">");
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
    
    public void printDivider()
    {
        String symbol = "*";
        for(int i = 0; i < 90; i++)
        {
            symbol += "*";
        }
        System.out.println(symbol);   
    }
    
    public void printInstructions()
    {
        boolean instructionsPrinted = false;
        boolean cancelInstructions = false;
        Scanner instructionScanner = new Scanner(new InputStreamReader(System.in));
        while(!cancelInstructions)
        {
            if(!instructionsPrinted)
            {
                System.out.println("Instructions");
                System.out.println("The game will display output of either 1, 3, 5 and 7 with a corresponding tone");
                System.out.println("The user will then be prompted to enter the corresponding digit using the number keys");
                System.out.println("The game will continue adding additional outputs until the user makes an error");
                System.out.println("The user can enter multiple inputs on a single line seperated by spaces");
                System.out.println("Enter any value to continue.");               
                printDivider();
                // User input prompt
                System.out.print(">");
                instructionsPrinted = true;
            }
            if(instructionScanner.hasNext())
            {
                instructionScanner.nextLine();
                cancelInstructions = true;            
            }           
        }
    }
    
}
