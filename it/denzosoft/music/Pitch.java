/*
 * Pitch.java
 *
 * Created on 14 aprile 2006, 12.11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.denzosoft.music;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Pitch {

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
