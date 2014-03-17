/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simonsays.gameModel;

/**
 *
 * @author Sam
 */
public class Output 
{
    public Output()
    {
        
    }
    
    private void outputTestPlaceholder()
    {  
        System.out.print("1  2  3  4");
        try 
        {
            Thread.sleep(1000);
        } 
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        System.out.print("\b\b\b\b\b\b\b\b\b\b");
    }
    
    
    
}
