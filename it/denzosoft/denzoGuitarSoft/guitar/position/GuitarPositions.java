/*
 * GuitarPositions.java
 *
 * Created on 31 maggio 2002, 11.36
 */

package it.denzosoft.denzoGuitarSoft.guitar.position;

import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import java.util.*;
import java.util.Enumeration;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class GuitarPositions extends Vector implements Positions {

    private Tuneable lTuning;
    private Properties properties=new Properties();
    /** Creates new GuitarPositions */
    public GuitarPositions() {
      lTuning=new Tuning(0);
    }

    /** Getter for property tuning.
     * @return Value of property tuning.
     */
    public Tuneable getTuning() {
        return lTuning;
    }

    /** Setter for property tuning.
     * @param tuning New value of property tuning.
     */ 
    public void setTuning(Tuneable tuning) {
      lTuning=tuning;
    }

    public Properties getProperties() {
        return properties;
    }
    
    public void setProperties(Properties pr) {
        this.properties=properties;
    }
    
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
