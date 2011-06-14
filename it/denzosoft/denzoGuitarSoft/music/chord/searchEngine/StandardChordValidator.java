/*
 * StandardChordValidator.java
 *
 * Created on 24 maggio 2002, 17.47
 */

package it.denzosoft.denzoGuitarSoft.music.chord.searchEngine;

import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import it.denzosoft.denzoGuitarSoft.guitar.position.*;
import it.denzosoft.denzoGuitarSoft.music.*;
import it.denzosoft.denzoGuitarSoft.util.*;
import it.denzosoft.denzoGuitarSoft.music.chord.*;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class StandardChordValidator implements ChordValidator{
    
    protected Properties lProperties;
    protected Tuneable lTuning;
    protected boolean allowOpenChord=false;
    protected int frameFrets;
    protected boolean allowInversions=false;
    protected boolean allowExtractChord=false;
    protected boolean allowBrokenChord=false;
    protected int chordRoot;
    protected int noteNumber;
    /** Creates new StandardChordValidator */
    protected int chordImage=0;
    protected int chordNumber=0;
    
    public StandardChordValidator() {
    }
    
    public boolean validate(int[] position) {
        int[] pitches=lTuning.getPitches(position);
        if (!testNoteNumber(position))
            return false;
        if (!testNote(pitches))
            return false;
        if (!testFrets(position))
            return false;
        if (!allowInversions)
            if (!testRoot(pitches))
                return false;
        if (!allowBrokenChord)
            if (testBroken(position))
                return false;
        if (!testDita(position))
            return false;
        return true;
    }
    
    public String print(int[] position) {
        chordNumber++;
        StringBuffer retVal=new StringBuffer("");
        //System.out.print(chordNumber+": ");
        for(int i=0;i<position.length;i++) {
            String value=new Integer(position[i]).toString();
            if (position[i]==GuitarPosition.NO_FRET_VALUE)
                value=GuitarPosition.NO_FRET;
            //System.out.print(value+" ");
            retVal.append(value+" ");
        }
        //System.out.println("");
        return retVal.toString();
    }
    
    public void prepare(Chordable chord,Tuning tuning,Properties properties) {
        lProperties=properties;
        allowOpenChord=((Boolean)lProperties.getObject("AllowOpenChord",new Boolean(false))).booleanValue();
        frameFrets=lProperties.getInt("FrameFrets",4);
        noteNumber=lProperties.getInt("NoteNumber",4);
        allowInversions=((Boolean)lProperties.getObject("AllowInversions",new Boolean(false))).booleanValue();
        allowExtractChord=((Boolean)lProperties.getObject("AllowExtractChord",new Boolean(false))).booleanValue();
        allowBrokenChord=((Boolean)lProperties.getObject("AllowBrokenChord",new Boolean(false))).booleanValue();
        
        chordRoot=lProperties.getInt("ChordRoot",0);
//        lTuning=(Tuneable)properties.getObject("Tuning", new Tuning());
        lTuning=tuning;
        chordNumber=0;
        int[] chordNote=chord.getPitches();
        int startingPitch;
        if (chord.getRoot()==null)
            startingPitch=0;
        else
            startingPitch=chord.getRoot().getPitch();
        chordImage=0;
        int tmp;
        for(int i=0;i<chordNote.length;i++) {
            //tmp=( (int)Math.pow( 2, (chordNote[i]+12+startingPitch) % 12));
            tmp=pow2((chordNote[i]+12+startingPitch) % 12);
            chordImage=(chordImage | tmp);
        }
    }
    
    //    protected int pow2(int number) {
    //        return (int)Math.pow( 2, number);
    //    }
    
    protected final static int[] powValues={1,2,4,8,16,32,64,128,256,512,1024,2048};
    protected int pow2(int number) {
        return powValues[number];
    }
    
    public boolean validate(int pitch) {
        int tmp=pow2( (pitch+12) % 12);
        if((chordImage & tmp)==0)
            return false;
        return true;
    }
    
    
    protected boolean testNote(int[] pitch) {
        int positionImage=0;
        int tmp;
        int pitchLength=pitch.length;
        for(int i=0;i<pitchLength;i++) {
            if (pitch[i]!=GuitarPosition.NO_PITCH_VALUE) {
                tmp=pow2((pitch[i]+12) % 12);
                positionImage=(positionImage | tmp);
            }
        }
        if ((positionImage == chordImage))
            return true;
        return false;
    }
    
    protected boolean testNoteNumber(int[] position) {
        int counter=0;
        int positionLength=position.length;
        for(int i=0;i<positionLength;i++) {
            if (position[i]!=GuitarPosition.NO_FRET_VALUE) {
                counter++;
            }
        }
        return (counter>=noteNumber);
    }
    
    
    protected boolean testFrets(int[] position) {
        int minFret=50;
        int maxFret=-1;
        int positionLength=position.length;
        for(int i=0;i<positionLength;i++) {
            if (position[i]!=GuitarPosition.NO_FRET_VALUE) {
                if (!(allowOpenChord && (position[i]==0))) {
                    if (position[i]<minFret)
                        minFret=position[i];
                    if (position[i]>maxFret)
                        maxFret=position[i];
                }
            }
        }
        if (frameFrets>(maxFret-minFret))
            return true;
        return false;
    }
    
    protected boolean testRoot(int[] pitch) {
        int i=0;
        int pitchLength=pitch.length;
        
        while (i<pitchLength) {
            if (pitch[i]!=GuitarPosition.NO_FRET_VALUE) {
                if((pitch[i] % 12)==chordRoot)
                    return true;
                return false;
            }
            i++;
        }
        return false;
    }
    
    protected boolean testBroken(int[] position) {
        boolean broken1=false;
        boolean broken2=false;
        int positionLength=position.length;
        
        for(int i=0;i<positionLength;i++) {
            if (position[i]!=GuitarPosition.NO_FRET_VALUE && !broken1)
                broken1=true;
            if (position[i]!=GuitarPosition.NO_FRET_VALUE && broken1 && !broken2) {
            }
            if (position[i]==GuitarPosition.NO_FRET_VALUE && broken1) {
                broken2=true;
            }
            if (position[i]!=GuitarPosition.NO_FRET_VALUE && broken2) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean testDita(int[] position) {
        int minFret=50;
        int maxFret=-1;
        int positionLength=position.length;
        for(int i=0;i<positionLength;i++) {
            if (position[i]!=GuitarPosition.NO_FRET_VALUE) {
                if (!(allowOpenChord && (position[i]==0))) {
                    if (position[i]<minFret)
                        minFret=position[i];
                    if (position[i]>maxFret)
                        maxFret=position[i];
                }
            }
        }
        int dita=1;
        if (minFret==0)
            dita=0;
        for(int i=0;i<positionLength;i++) {
            if (position[i]>minFret) {
                dita++;
            }
        }
        if (dita>4)
            return false;
        return true;
    }
    
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
