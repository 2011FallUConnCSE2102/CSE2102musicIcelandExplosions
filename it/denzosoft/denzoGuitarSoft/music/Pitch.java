/*
 * Pitch.java
 *
 * Created on 23 maggio 2002, 16.09
 */

package it.denzosoft.denzoGuitarSoft.music;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Pitch implements Pitchable {

    private int lPitch;
    
    /** Creates new Pitch */
    public Pitch() {
        lPitch=0;
    }

    public Pitch(int pitchValue) {
        lPitch=pitchValue;
    }

    public Pitch(int notePitch, int octave) {
        lPitch=octave*12+notePitch;
    }

    public int getOctave() {
        return (int)Math.floor((double)lPitch/12);
    }
    
    public void setOctave(int octave) {
        lPitch=(lPitch % 12)+octave*12;
    }
    
    public int getNotePitch() {
        return lPitch % 12;
    }
    
    public void setNotePitch(int notePitch) {
        lPitch=this.getOctave()*12+notePitch;
    }

    /** Getter for property pitch.
     * @return Value of property pitch.
     */
    public int getPitch(){
        return lPitch;
    }
    
    /** Setter for property pitch.
     * @param pitch New value of property pitch.
     */
    public void setPitch(int pitch){
        lPitch=pitch;
    }
    
    public static void main(String args[]) {
        Pitch first=new Pitch(12);
        Pitch second=new Pitch(4,1);
        
        System.out.println(first.getNotePitch()+" "+first.getOctave() );
    }
}
