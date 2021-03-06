/*
 * EnglishNote.java
 *
 * Created on 23 maggio 2002, 17.25
 */

package it.denzosoft.denzoGuitarSoft.notation.noteName;

import it.denzosoft.denzoGuitarSoft.music.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public class EnglishNoteName implements NoteName{
    
    private static String Names="C C#D D#E F F#G G#A A#B ";
    private static EnglishNoteName noteName=null;

    /** Creates new EnglishNoteName */
    private EnglishNoteName() {
    }

    public String getName(Pitchable pitch) {
        return getName(pitch.getNotePitch());
    }
    
    public String getName(int notePitch) {
        return Names.substring(notePitch*2,notePitch*2+2).trim();
    }

    public static EnglishNoteName getInstance() {
        if (noteName==null) {
            noteName=new EnglishNoteName();
        } 
        return noteName;            
    }

    public static void main (String args[]) {
        NoteName tmp=EnglishNoteName.getInstance();
        System.out.println(tmp.getName(4));
    }
}
