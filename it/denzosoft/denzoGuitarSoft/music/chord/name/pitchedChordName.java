/*
 * pitchedChordName.java
 *
 * Created on 27 maggio 2002, 17.07
 */

package it.denzosoft.denzoGuitarSoft.music.chord.name;

import it.denzosoft.denzoGuitarSoft.music.*;
import it.denzosoft.denzoGuitarSoft.util.*;

/**
 *
 * @author  De Sanctis
 * @version 1.0
 */
public class pitchedChordName implements chordName{
    int lPitches=0;
    private Pitchable lRoot=null;
    private int chordImage=0;
    private int absoluteChordImage=0;

    /** Creates new pitchedChordName */
    public pitchedChordName() {
    }

    public String getName() {
		return null;
    }

    public String getBassNote() {
		return null;
    }

    public void setFormula(String formula) {
        String[] formulaItems=StringFunctions.split("0 "+formula);
        int tmp;
        this.chordImage=0;
        this.absoluteChordImage=0;
        int startingPitch;
        if (lRoot==null)
            startingPitch=0;
        else
            startingPitch=lRoot.getPitch();
        for(int i=0;i<formulaItems.length;i++) {
            //System.out.println(i);
            this.chordImage=(chordImage | (int)Math.pow(2,Integer.parseInt(formulaItems[i])));
            //System.out.println(chordImage);
            tmp=( (int)Math.pow( 2, (Integer.parseInt(formulaItems[i])+12+startingPitch) % 12));
            this.absoluteChordImage=(absoluteChordImage | tmp);
            //System.out.println(absoluteChordImage);
        }

    }

    public String getRoot() {
		return null;
    }

    public void setRoot(int root) {
    }

    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
