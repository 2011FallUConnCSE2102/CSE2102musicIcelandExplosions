/*
 * SearchValidate.java
 *
 * Created on 24 maggio 2002, 17.38
 */

package it.denzosoft.mobile.chordFinder;


/**
 *
 * @author  De Sanctis
 * @version
 */
public interface ChordValidator {
    public void prepare(PitchedChord chord,Tuning tuning,Properties searchProperties);
    //public boolean validate(Pitchable[] position);
    public boolean validate(int[] position);
    public boolean validate(int Pitch);
    public String print(int[] position);

}

