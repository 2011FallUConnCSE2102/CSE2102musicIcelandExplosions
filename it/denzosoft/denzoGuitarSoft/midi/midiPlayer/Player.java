/*
 * Player.java
 *
 * Created on 23 luglio 2002, 11.52
 */

package it.denzosoft.denzoGuitarSoft.midi.midiPlayer;
import it.denzosoft.denzoGuitarSoft.midi.*;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Player {
    private MidiInterface mi;

    /** Creates new Player */
    public Player() {
        mi=new MidiInterface();
    }

    public void open() {
        mi.open();
    }
    
    public void close() {
        mi.open();
    }
    
    public Channel getChannel(int channelNumber) {
        return new Channel(channelNumber, mi);
    }
    
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */    
}
