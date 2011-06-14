/*
 * PcSpeaker.java
 *
 * Created on 29 maggio 2002, 17.29
 */

package it.denzosoft.denzoGuitarSoft.midi;

import java.awt.Toolkit;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public class PcSpeaker implements SoundSource {

    /** Creates new PcSpeaker */
    public PcSpeaker() {
    }

    public void close() {
    }
    
    public void play(int pitch, int volume, int duration) {
        Toolkit.getDefaultToolkit().beep();
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
        }
        
    }
    
    public void open() {
    }
    
    public void playTone(int frequency, int volume, int duration) {
    }
    
    //Toolkit.getDefaultToolkit().beep();     
    
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */    
}
