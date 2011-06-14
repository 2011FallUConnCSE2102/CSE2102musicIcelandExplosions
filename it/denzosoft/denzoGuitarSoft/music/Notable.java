/*
 * Notable.java
 *
 * Created on 23 maggio 2002, 16.38
 */

package it.denzosoft.denzoGuitarSoft.music;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Notable extends Pitchable {


    
    public String getName();
    
    /** Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name);
    
    public String getNote();
    
    /** Getter for property pitch.
     * @return Value of property pitch.
     */
    public int getPitch();    
    
    /** Setter for property pitch.
     * @param pitch New value of property pitch.
     */
    public void setPitch(int pitch);
    
    public int getNotePitch2();
    
}

