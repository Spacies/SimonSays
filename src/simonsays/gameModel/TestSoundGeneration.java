package simonsays.gameModel;

import java.applet.*;
import javax.swing.*;
import java.net.*;

/**
 * Generates a test sound to investigate producing sound in
 * a java application.
 * 
 * @AUTHOR Jaimes 16-03-14
 * Code derived from
 * http://www.dreamincode.net/forums/topic/14083-incredibly-easy-way-to-play-sounds/
 */
public class TestSoundGeneration extends JApplet // Holds one audio file
{
    private URL soundPath; // Sound path
    private AudioClip sound; // Sound player
    private TestSoundGeneration testSound; //The generated sound object
    
    /*
     * The main method from which the sound test runs. Calls the 
     * TestSoundGeneration method with the test audio file's path. 
     * 
     * @param args The arguments to pass to the Java executable.
     * @throws e An exception message if an exception is encountered.
     */
//    public static void main(String[] args)
//    {
//       
//        try
//        {
//            System.out.println("main class called");
//            testSound = new TestSoundGeneration("file:White Wash Superman 16-44k 13-09-13.wav");
//            
//            System.out.println("Calling testSound.callPlaySound from main method");
//            testSound.callPlaySound();
//        }
//        catch(Exception e)
//        {
//            System.out.println("Exception in main class");
//        }
//    }

    /**
     * Creates a test sound audioClip object.
     * 
     * @param filename The filename path of the audio to create an object from.
     * @throw e An exception message if an exception is encountered.
     */
    protected TestSoundGeneration(String filename)
    {
        try
        {
            //System.out.println("Made it to TestSoundGeneration");
            //System.out.println("Filename passed as: " + filename);
            //soundPath = new URL(getCodeBase(), filename); // Get the Sound URL
            soundPath = new URL(filename); // Get the Sound URL
            //System.out.println("Made it to after soundPath");
            
            sound = Applet.newAudioClip(soundPath); // Load the Sound
            //System.out.println("New sound initiated in Test Sound Generation");
            
            //System.out.println("Reached TestSoundGeneration constructor");
            testSound = this;
            
            //System.out.println("Calling testSound.callPlaySound from TestSoundGeneration method");
            testSound.callPlaySound();
            
        }
        catch(Exception e) // Satisfy the catch
        {
            System.out.println("Exception error");
        } 
    }
    
    /**
     * Calls the playSoundOnce method on the testSound object.
     */
    public void callPlaySound()
    {
        
        //System.out.println("Calling testSound.playSound from callPlaySound()");
        testSound.playSoundOnce();
        //System.out.println("Sound playing");
      
    }

    /**
     * Plays the sound object in a loop.
     */
    public void playSoundLoop()
    {
        //System.out.println("PlaySoundLoop method reached");
        sound.loop(); // Play
    }

    /**
     * Stops playback of the sound object.
     */
    public void stopSound()
    {
        sound.stop(); // Stop
    }

    /**
     * Plays the sound object once through.
     */
    public void playSoundOnce()
    {
        //System.out.println("playSoundOnce method reached");
        sound.play(); // Play only once
    }

    
    
}
