/*
 * Channel.java
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
public class Channel implements NoteEffectable {
    
    private MidiInterface mi;
    private int channel=-1;
    //private ArrayList 
    
    /** Creates new Channel */
    private Channel()  {
    }

    public Channel(int channelNumber, MidiInterface midiInterface)  {
        channel=channelNumber;
        mi=midiInterface;
//        mi.
    }
    
    public void mutedNote(int pitch, int duration) {
    }
    
    public void bendNote(int pitch, int duration, float bendValue, float preBendValue) {
    }
    
    public void stopNote(int pitch) {
    }
    
    public void tremoloNote(int pitch, int duration, float tremoloAmpl, float tremoloSpeed) {
    }
    
    public void appoggiaturaNote(int startPitch, int endPitch, int duration) {
    }
    
    public void playNote(int pitch, int duration) {
    }
    
    public void slideNote(int startPitch, int endPitch, int duration) {
    }
    
    public void setInstrument(int instrument) {
    }
    
    public int getInstrument() {
        return 0;
    }
    
    public void fadeInNote(int pitch, int duration) {
    }
    
    public void fadeOutNote(int pitch, int duration) {
    }
    
}
