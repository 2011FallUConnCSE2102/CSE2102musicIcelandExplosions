/*
 * Interval.java
 *
 * Created on 24 maggio 2002, 9.55
 */

package it.denzosoft.denzoGuitarSoft.music;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Interval implements Intervallable{
    private int lExtension=0;
    private int lAletration=0;
    private static final String[] lAlterationNames={"major","minor","perfect","augmented","diminished"};
    private static final String[] lShortAlterationNames={"","min","","aug","dim"};
    private static final String[] lDegreeNames={"unisone","2nd","3rd","4th","5th","6th","7th","8th","9th","10th","11th","12th","13th","14th","15th","16th","17th","18th","19th","20th","21th","22th"};

    /** Creates new Interval */
    public Interval() {
    }

    public void setInterval(Notable startNote, Notable endNote) {
    }
    
    public void setInterval(Pitchable startPitch, Pitchable endPitch) {
    }
    
    public void setInterval(Pitchable startPitch, int pitch) {
    }
    
    public void setInterval(int degree, int degreeAlteration) {
    }
    
    public String getName() {		return null;
    }
    
    public String getAlteration() {		return null;
    }
    
    public String getNameShort() {		return null;
    }
    
    public int getExtension() {
        return lExtension;
    }
    
    public void setInterval(Notable startNote, int pitch) {
    }
    
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */    
}
