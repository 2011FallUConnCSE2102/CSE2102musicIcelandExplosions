/*
 * Pitchable.java
 *
 * Created on 23 maggio 2002, 16.34
 */

package it.denzosoft.denzoGuitarSoft.music;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Pitchable {

    /** Getter for property octave.
     * @return Value of property octave.
     */
    public int getOctave();
    
    /** Setter for property octave.
     * @param octave New value of property octave.
     */
    public void setOctave(int octave);
    
    /** Getter for property notePitch.
     * @return Value of property notePitch.
     */
    public int getNotePitch();
    
    /** Setter for property notePitch.
     * @param notePitch New value of property notePitch.
     */
    public void setNotePitch(int notePitch);
    
    /** Getter for property pitch.
     * @return Value of property pitch.
     */
    public int getPitch();
    
    /** Setter for property pitch.
     * @param pitch New value of property pitch.
     */
    public void setPitch(int pitch);
    
}

