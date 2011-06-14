/*
 * NoteName.java
 *
 * Created on 23 maggio 2002, 17.27
 */

package it.denzosoft.denzoGuitarSoft.notation.noteName;

import it.denzosoft.denzoGuitarSoft.music.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface NoteName {
    
    
    public String getName(Pitchable pitch);
    public String getName(int notePitch);


}

