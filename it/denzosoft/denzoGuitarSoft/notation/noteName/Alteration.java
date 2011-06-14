/*
 * Alteration.java
 *
 * Created on 23 maggio 2002, 17.24
 */

package it.denzosoft.denzoGuitarSoft.notation.noteName;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Alteration implements Alterable {

    private static String AlterationString="bbb   # x ";
    private static Alteration alteration=null;
    /** Creates new Alteration */
    private Alteration() {
    }

    public String getName(int value) {
        return AlterationString.substring(value*2,value*2+2).trim();
    }    
    
    public int getValue(String Name) {
        return (int)(AlterationString.indexOf(Name)/2);
    }
    
  
    public static Alterable getInstance() {
        if (alteration==null) {
            alteration=new Alteration();
        } 
        return alteration;            
    }
    
    public static void main (String args[]) {
        Alteration alt=new Alteration();
        
        System.out.println(alt.getName(1));
    }
  }
