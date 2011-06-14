/*
 * Tuneable.java
 *
 * Created on 23 maggio 2002, 18.21
 */

package it.denzosoft.denzoGuitarSoft.guitar.tuning;

import it.denzosoft.denzoGuitarSoft.music.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Tuneable {
    public int getStringNumber();
    public int getFret(int string, Pitchable pitch);
    public int getFret(int string, int pitch);
    public int getPitch(int string, int fret);
    public int getPitch(int string);
    public int[] getPitches(int[] position);
}

