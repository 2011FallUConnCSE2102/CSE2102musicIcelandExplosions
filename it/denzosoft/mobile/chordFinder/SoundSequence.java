/*
 * SoundSequence.java
 *
 * Created on 8 novembre 2006, 16.32
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.denzosoft.mobile.chordFinder;

import java.util.Vector;
import javax.microedition.media.control.ToneControl;


/**
 *
 * @author De Sanctis
 */
public class SoundSequence {
    
    private Vector sequence = new Vector();
    /** Creates a new instance of SoundSequence */
    public SoundSequence() {
    }
    
    public static int getMiddleC() {
        return ToneControl.C4;
    }

    public static int getRest() {
        return ToneControl.SILENCE;
    }
    
    
    
    
    public void add(int pitch) {
        
    }
    
}
