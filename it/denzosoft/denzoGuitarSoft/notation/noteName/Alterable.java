/*
 * Alterable.java
 *
 * Created on 23 maggio 2002, 17.24
 */

package it.denzosoft.denzoGuitarSoft.notation.noteName;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Alterable {
    
    public String getName(int AlterationValue);
    public int getValue(String Name);
}

