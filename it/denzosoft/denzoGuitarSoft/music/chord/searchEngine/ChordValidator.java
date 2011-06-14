/*
 * SearchValidate.java
 *
 * Created on 24 maggio 2002, 17.38
 */

package it.denzosoft.denzoGuitarSoft.music.chord.searchEngine;

import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import it.denzosoft.denzoGuitarSoft.music.*;
import it.denzosoft.denzoGuitarSoft.music.chord.*;
import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public interface ChordValidator {
    public void prepare(Chordable chord,Tuning tuning,Properties searchProperties);
    //public boolean validate(Pitchable[] position);
    public boolean validate(int[] position);
    public boolean validate(int Pitch);
    public String print(int[] position);

}

