/*
 * OptimizedChordValidator.java
 *
 * Created on 27 maggio 2002, 15.36
 */

package it.denzosoft.denzoGuitarSoft.music.chord.searchEngine;

import it.denzosoft.denzoGuitarSoft.guitar.position.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class OptimizedChordValidator extends StandardChordValidator {

    /** Creates new OptimizedChordValidator */
    public OptimizedChordValidator() {
    }

//    public boolean validate(int[] pitch) {
//    }

    protected boolean testNote(int[] pitch) {
        //int[] pitch=lTuning.getPitches(position);
        int chordMask=pow2( (chordRoot+12) % 12)+pow2( (chordRoot+7+12) % 12);
        int origChordMask=chordMask;
        int tmp;
        int pitchLength=pitch.length;
        for(int i=0;i<pitchLength;i++) {
            if (pitch[i]!=GuitarPosition.NO_PITCH_VALUE) {
              //tmp=( (int)Math.pow( 2, (pitch[i]+12) % 12));
              tmp=pow2( (pitch[i]+12) % 12);  
              if((chordImage & tmp)==0)
                  return false;
              chordMask=(chordMask | tmp);
            }
        }
        return ((chordImage | origChordMask) == chordMask);
    }
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}

