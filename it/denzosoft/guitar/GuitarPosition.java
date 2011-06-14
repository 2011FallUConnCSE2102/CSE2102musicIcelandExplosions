/*
 * GuitarPosition.java
 *
 * Created on 14 aprile 2006, 12.12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.denzosoft.guitar;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class GuitarPosition {

    int lString=NO_STRING;
    int lFret=NO_FRET_VALUE;

    public GuitarPosition() {
    }

    public GuitarPosition(int string, int fret) {
        lString=string;
        lFret=fret;
    }

    public static final int NO_FRET_VALUE=-100;
    public static final int NO_PITCH_VALUE=-100;
    public static final String NO_FRET="X";
    private static final int NO_STRING=-100;
    /** Setter for property string.
     * @param string New value of property string.
     */
    public void setString(int string) {
        lString=string;
    }

    /** Setter for property fret.
     * @param fret New value of property fret.
     */
    public void setFret(int fret) {
        lFret=fret;
    }

    /** Getter for property fret.
     * @return Value of property fret.
     */
    public int getFret() {
        return lFret;
    }

    /** Getter for property string.
     * @return Value of property string.
     */
    public int getString() {
        return lString;
    }

}
