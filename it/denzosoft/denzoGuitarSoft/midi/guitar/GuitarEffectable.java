/*
 * MidiGuitarable.java
 *
 * Created on 23 luglio 2002, 11.08
 */

package it.denzosoft.denzoGuitarSoft.midi.guitar;

import it.denzosoft.denzoGuitarSoft.midi.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface GuitarEffectable extends NoteEffectable {
    public void whammyNote(int pitch, int duration, int whammyFunction);
    public void preHammerOnNote(int startPitch, int endPitch, int duration);
    public void prePullOffNote(int startPitch, int endPitch, int duration);
    public void harmonicNote(int pitch, int duration, int harmonicInfo);
    public void tappingNote(int pitch, int duration);
    public void bendNote(int pitch, int duration, float bendValue);
    public void releaseNote(int pitch, int duration, float bendValue);
    
}

