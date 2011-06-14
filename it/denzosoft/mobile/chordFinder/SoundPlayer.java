/*
 * Player.java
 *
 * Created on 8 novembre 2006, 16.29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.denzosoft.mobile.chordFinder;

import java.io.IOException;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.media.control.ToneControl;

/**
 *
 * @author De Sanctis
 */
public class SoundPlayer {
    
    /** Creates a new instance of Player */
    public SoundPlayer() {
    }

    public static void simpleTone() {
        try {
            Manager.playTone(ToneControl.C4, 100, 80);
        } catch (Exception ex){}
    }

    public static void simpleChordTone() {
        try {
            Manager.playTone(ToneControl.C4, 100, 80);
            Manager.playTone(ToneControl.C4+4, 100, 80);
            Manager.playTone(ToneControl.C4+7, 100, 80);
        } catch (Exception ex){}
    }
    
    
    public static void playTone(int tone, int duration, int volume) {
        try {
            Manager.playTone(tone, duration, volume);
        } catch (Exception ex){}
    }
    
    private void toneSequence() {
        byte tempo = 30;
        byte d = 8;
        
        byte C4 = ToneControl.C4;
        byte D4 = (byte)(C4 + 2);
        byte E4 = (byte)(C4 + 4);
        byte F4 = (byte)(C4 + 5);
        byte G4 = (byte)(C4 + 7);
        byte rest = ToneControl.SILENCE;
        
        byte[] mySequence = {
            ToneControl.VERSION, 1,
            ToneControl.TEMPO, tempo,
            ToneControl.BLOCK_START, 0,  // starting A part
            C4,d, F4,d, F4,d, C4,d, F4,d, F4,d, C4,d, F4,d,
            ToneControl.BLOCK_END, 0,   // ending A part
            ToneControl.BLOCK_START, 1,  // starting B part
            C4,d, E4,d, E4,d, C4,d, E4,d, E4,d, C4,d, E4,d,
            ToneControl.BLOCK_END, 1,   // ending B part
            ToneControl.PLAY_BLOCK, 0,  // playing A part
            ToneControl.PLAY_BLOCK, 1,  // playing A part
            ToneControl.PLAY_BLOCK, 0,  // playing A part
        };
        
        try{
            Player p = Manager.createPlayer(Manager.TONE_DEVICE_LOCATOR);
            p.realize();
            ToneControl c = (ToneControl)p.getControl("ToneControl");
            c.setSequence(mySequence);
            p.start();
            p.stop();
            p.close();
            p.deallocate();
        } catch (IOException ioe) {
        } catch (MediaException me) {}
    }
    
    
}
