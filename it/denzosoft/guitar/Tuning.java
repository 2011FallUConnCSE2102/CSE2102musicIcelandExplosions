/*
 * Tuning.java
 *
 * Created on 23 maggio 2002, 18.20
 */

package it.denzosoft.guitar;

import it.denzosoft.music.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class Tuning { 
    
    
    private int[] stringPitch;
    
    //private static Tuning singleton=null;
    /** Creates new Tuning */
    public Tuning() {
        this(StandardTuning.TUNING_STANDARD);
    }

    public Tuning(int standardTuning) {
        stringPitch = StandardTuning.getTuning(standardTuning);
    }
    
    
    public Tuning(Pitch[] tuningPitch) {
        stringPitch=new int[tuningPitch.length];
        for (int i=0;i<tuningPitch.length;i++)
            stringPitch[i]=tuningPitch[i].getPitch();
    }

    
    public int getStringNumber() {
        return stringPitch.length;
    }
    
    public int getFret(int string, Pitch pitch) {
        return getFret(string,pitch.getPitch());
    }
    
    public int getFret(int string, int pitch) {
        int retVal = pitch-stringPitch[string];
        if (retVal<0) {
            return GuitarPosition.NO_FRET_VALUE;
        }
        return (pitch-stringPitch[string]);
    }
    
    public int getPitch(int string, int fret) {
        return stringPitch[string]+fret;
    }
    
    public int getPitch(GuitarPosition gp) {
        return stringPitch[gp.getString()]+gp.getFret();
    }
    
    public int getPitch(int string) {
        return stringPitch[string];
    }
    
    public int[] getPitches(int[] position) {
        int[] retVal=new int[stringPitch.length];
        for(int i=0;i<stringPitch.length;i++) {
            if (position[i]==GuitarPosition.NO_FRET_VALUE)
                retVal[i]=GuitarPosition.NO_PITCH_VALUE;
            else
                retVal[i]=position[i]+stringPitch[i];
        }
        return retVal;
    }
    
    /*
    public static void main (String args[]) {
        Tuning tmp=Singleton.getInstance();
        System.out.println(tmp.toString());
    }
     */
}
