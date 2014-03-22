package simonsays.gameModel;

import java.applet.*;
import javax.swing.*;
import java.net.*;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineEvent.Type;
import javax.sound.sampled.LineListener;

/**
 * Generates a test sound to investigate producing sound in
 * a java application.
 * 
 * @AUTHOR Jaimes 16-03-14
 * Code derived from
 * http://www.dreamincode.net/forums/topic/14083-incredibly-easy-way-to-play-sounds/
 */
public class CreateAudioClip extends JApplet implements LineListener // Holds one audio file
{
    private URL soundPath; // Sound path
    private AudioClip sound; // Sound player
    private CreateAudioClip testSound; //The generated sound object
    
    //private static final int SLEEP_MS = 1000; // Sleep timer

    /**
     * Creates an audioClip sound object.
     * 
     * @param filename The filename path of the audio to create an object from.
     * @throw e An exception message if an exception is encountered.
     */
    protected CreateAudioClip(String filename)
    {
        try
        {
            //System.out.println("Made it to CreateAudioClip");
            //System.out.println("Filename passed as: " + filename);
            //soundPath = new URL(getCodeBase(), filename); // Get the Sound URL
            soundPath = new URL(filename); // Get the Sound URL
            //System.out.println("Made it to after soundPath");
            
            sound = Applet.newAudioClip(soundPath); // Load the Sound
            //System.out.println("New sound initiated in Test Sound Generation");
            
            //System.out.println("Reached CreateAudioClip constructor");
            testSound = this;
            
            
            // Register the object as a line listener
            LineListener listener = new LineListener() 
            {
                @Override
                public void update(LineEvent event)
                {
                    if (event.getType() != Type.STOP )
                    {
                        return;
                    }
                    
                    
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                }
            };
            
            
            testSound.addLineListener(listener);
            
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
        //while (testSound.isActive()); // wait for testSound to become inactive
        // befor playing a sound.
        
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
    
    // Play the sound and then wait until it finishes playing.
    // If the sound is already playing it will stop it and start over.
    // https://katie.mtech.edu/classes/csci136/assign/dungeon/student/AudioFile.java
//    public void playBlocking()
//    {
//        playSoundOnce();
//
//        // We must sleep a bit otherwise to give the audio change to fire up
//        do
//        {
//            System.out.println("Waiting for clip to finish, sleep");
//            try 
//            {
//                Thread.sleep(SLEEP_MS);
//            } 
//            catch(InterruptedException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        
//        while (sound.isRunning());
//    }
    
    // http://stackoverflow.com/questions/557903/how-can-i-wait-for-a-java-sound-clip-to-finish-playing-back
    //private final BlockingQueue<URL> queue = new ArrayBlockingQueue<URL>(1);

//    public void playSoundStream(InputStream stream) {
//        Clip clip = AudioSystem.getClip();
//        AudioInputStream inputStream = AudioSystem.getAudioInputStream(stream);
//        clip.open(inputStream);
//        clip.start();
//         
//        {
//            public void update(LineEvent e) 
//            {
//                if (e.getType() != Type.STOP) {
//                        return;
//                }
//
//                try {
//                        queue.take();
//                } catch (InterruptedException e) {
//                        //ignore this
//                }
//            }
//        };
//    clip.addLineListener(listener );
//    }

    private void addLineListener(LineListener listener)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LineEvent event)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
