/*
 * NoteEffects.java
 *
 * Created on 23 luglio 2002, 11.18
 */

package it.denzosoft.denzoGuitarSoft.midi;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface NoteEffectable {
    public void playNote(int pitch, int duration);
    public void stopNote(int pitch);
    public void fadeInNote(int pitch, int duration);
    public void fadeOutNote(int pitch, int duration);
    public void tremoloNote(int pitch, int duration, float tremoloAmpl,float tremoloSpeed);
    public void bendNote(int pitch, int duration, float bendValue, float preBendValue);
    public void slideNote(int startPitch, int endPitch, int duration);
    public void mutedNote(int pitch, int duration);
    public void appoggiaturaNote(int startPitch, int endPitch, int duration);
    

}

