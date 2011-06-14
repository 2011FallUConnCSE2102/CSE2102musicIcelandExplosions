/*
 * Position.java
 *
 * Created on 31 maggio 2002, 11.26
 */

package it.denzosoft.denzoGuitarSoft.guitar.position;

import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import java.util.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public interface Positions extends List {
    
    /** Getter for property tuning.
     * @return Value of property tuning.
     */
    public Tuneable getTuning();
    
    /** Setter for property tuning.
     * @param tuning New value of property tuning.
     */
    public void setTuning(Tuneable tuning);
    
    public void setProperties(Properties pr);
    public Properties getProperties();
}

