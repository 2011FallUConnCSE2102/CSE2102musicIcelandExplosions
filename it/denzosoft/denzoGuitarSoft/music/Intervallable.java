/*
 * Intervallable.java
 *
 * Created on 24 maggio 2002, 9.54
 */

package it.denzosoft.denzoGuitarSoft.music;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Intervallable {
    public void setInterval(Pitchable startPitch, Pitchable endPitch);
    public void setInterval(Notable startNote, Notable endNote);
    public void setInterval(Pitchable startPitch,int pitch);
    public void setInterval(Notable startNote,int pitch);
    public void setInterval(int degree, int degreeAlteration);
    
    public String getName();
    public String getNameShort();
    public String getAlteration();
    public int getExtension();
    
}

