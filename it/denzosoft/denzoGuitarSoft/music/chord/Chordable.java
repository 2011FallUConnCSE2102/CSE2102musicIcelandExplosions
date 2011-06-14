/*
 * Chordable.java
 *
 * Created on 24 maggio 2002, 10.19
 */

package it.denzosoft.denzoGuitarSoft.music.chord;

import it.denzosoft.denzoGuitarSoft.music.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Chordable {

    /** Getter for property formula.
     * @return Value of property formula.
     */
    public String getFormula();
    
    /** Setter for property formula.
     * @param formula New value of property formula.
     */
    public void setFormula(String formula);
    
    /** Getter for property root.
     * @return Value of property root.
     */
    public Pitchable getRoot();
    
    /** Setter for property root.
     * @param root New value of property root.
     */
    public void setRoot(Pitchable root);
    
    public boolean isInChord(Pitchable note);
    
    public int itemNumber();
	public int[] getPitches();
    
}

