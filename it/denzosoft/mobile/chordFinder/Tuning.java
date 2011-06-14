/*
 * Tuning.java
 *
 * Created on 23 maggio 2002, 18.20
 */

package it.denzosoft.mobile.chordFinder;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class Tuning{
    
    public static final String[] tuningNameList={"Standard","Drop D (D A D G B E)",
    "Open G (D G D G B D)","Open E (E B E G# B E)",
    "Open A (E A C# E A E)","Open D (D A D F# A D)","Modal D (D A D G A D)",
    "Open Dm (D A D F A D)","Modal G (D G D G C D)","Open G Minor (D G D G A# D)",
    "Standard 7 strings (B E A D G B E)","Bass (E A D G)", "Bass 5 strings (B E A D G)",
    "Mandolin (G D A E)"};
    public static final int TUNING_STANDARD=0;
    private static final int[] tuningStandardPitch={4,9,14,19,23,28};
    public static final int TUNING_DROP_D=1;
    private static final int[] tuningDropDPitch={2,9,14,19,23,28};
    public static final int TUNING_OPEN_G=2;
    private static final int[] tuningOpenGPitch={2,7,14,19,23,26};
    public static final int TUNING_OPEN_E=3;
    private static final int[] tuningOpenEPitch={4,11,16,20,23,28};
    public static final int TUNING_OPEN_A=4;
    private static final int[] tuningOpenAPitch={4,9,16,21,25,28};
    public static final int TUNING_OPEN_D=5;
    private static final int[] tuningOpenDPitch={2,9,14,18,21,26};
    public static final int TUNING_MODAL_D=6;
    private static final int[] tuningModalDPitch={2,9,14,19,21,26};
    public static final int TUNING_OPEN_D_MIN=7;
    private static final int[] tuningOpenDMinPitch={2,9,14,17,21,26};
    public static final int TUNING_MODAL_G=8;
    private static final int[] tuningModalGPitch={2,7,14,19,24,26};
    public static final int TUNING_OPEN_G_MIN=9;
    private static final int[] tuningOpenGMinPitch={2,7,14,19,22,26};
    public static final int TUNING_STANDARD_7=10;
    private static final int[] tuningStandard7Pitch={-1,4,9,14,19,23,28};
    public static final int TUNING_BASS=11;
    private static final int[] tuningBassPitch={4,9,14,19};
    public static final int TUNING_BASS_5=12;
    private static final int[] tuningBass5Pitch={-1,4,9,14,19};
    public static final int TUNING_MANDOLIN=13;
    private static final int[] tuningMandolinPitch={19,26,33,40};
    
    private int[] lStringPitch;
    
    //private static Tuning singleton=null;
    /** Creates new Tuning */
    public Tuning() {
        this(TUNING_STANDARD);
    }
    
    public Tuning(int tuningTypeConst) {
        switch (tuningTypeConst) {
            case TUNING_STANDARD: {
                lStringPitch=tuningStandardPitch;
                break;
            }
            case TUNING_DROP_D: {
                lStringPitch=tuningDropDPitch;
                break;
            }
            case TUNING_OPEN_G: {
                lStringPitch=tuningOpenGPitch;
                break;
            }
            case TUNING_OPEN_E: {
                lStringPitch=tuningOpenEPitch;
                break;
            }
            case TUNING_OPEN_A: {
                lStringPitch=tuningOpenAPitch;
                break;
            }
            case TUNING_OPEN_D: {
                lStringPitch=tuningOpenDPitch;
                break;
            }
            case TUNING_MODAL_D: {
                lStringPitch=tuningModalDPitch;
                break;
            }
            case TUNING_OPEN_D_MIN: {
                lStringPitch=tuningOpenDMinPitch;
                break;
            }
            case TUNING_MODAL_G: {
                lStringPitch=tuningModalGPitch;
                break;
            }
            case TUNING_OPEN_G_MIN: {
                lStringPitch=tuningOpenGMinPitch;
                break;
            }
            case TUNING_STANDARD_7: {
                lStringPitch=tuningStandard7Pitch;
                break;
            }
            case TUNING_BASS: {
                lStringPitch=tuningBassPitch;
                break;
            }
            case TUNING_BASS_5: {
                lStringPitch=tuningBass5Pitch;
                break;
            }
            case TUNING_MANDOLIN: {
                lStringPitch=tuningMandolinPitch;
                break;
            }
            default:
                lStringPitch=tuningStandardPitch;
        }
        //for (int i=0;i<tuningDef.length;i++)
    }
    
    public Tuning(Pitch[] tuningPitch) {
        lStringPitch=new int[tuningPitch.length];
        for (int i=0;i<tuningPitch.length;i++)
            lStringPitch[i]=tuningPitch[i].getPitch();
    }
    
        /*
    public void setTuning(int standardTuning) {
    }
         */
    
    public int getStringNumber() {
        return lStringPitch.length;
    }
    
    public int getFret(int string, Pitch pitch) {
        return getFret(string,pitch.getPitch());
    }
    
    public int getFret(int string, int pitch) {
        return (pitch-lStringPitch[string]);
    }
    
    public int getPitch(int string, int fret) {
        return lStringPitch[string]+fret;
    }
    
    public int getPitch(GuitarPosition gp) {
        return lStringPitch[gp.getString()]+gp.getFret();
    }
    
    public int getPitch(int string) {
        return lStringPitch[string];
    }
    
    public int[] getPitches(int[] position) {
        int[] retVal=new int[lStringPitch.length];
        for(int i=0;i<lStringPitch.length;i++) {
            if (position[i]==GuitarPosition.NO_FRET_VALUE)
                retVal[i]=GuitarPosition.NO_PITCH_VALUE;
            else
                retVal[i]=position[i]+lStringPitch[i];
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
