/*
 * chordName.java
 *
 * Created on 27 maggio 2002, 17.06
 */

package it.denzosoft.denzoGuitarSoft.music.chord.name;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface chordName {
    public String getName();
    public String getBassNote();
    public String getRoot();
    public void setFormula(String formula);
    public void setRoot(int root);    
}

