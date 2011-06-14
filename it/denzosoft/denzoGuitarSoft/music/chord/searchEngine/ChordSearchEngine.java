/*
 * ChordSearchEngine.java
 *
 * Created on 24 maggio 2002, 17.45
 */

package it.denzosoft.denzoGuitarSoft.music.chord.searchEngine;

import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import it.denzosoft.denzoGuitarSoft.guitar.position.*;
//import java.util.*;
import it.denzosoft.denzoGuitarSoft.util.*;
import java.util.Vector;
import java.util.Arrays;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class ChordSearchEngine {
    
    protected int[] position;
    
    protected Tuneable lTuning=null;
    protected Properties lProperties;
    protected ChordValidator lValidator=null;
    protected boolean allowOpenChord=false;
    protected boolean allowExtractChord=false;
    protected int startSearchPosition;
    protected int endSearchPosition;
    protected int frameFrets;
    
    /** Creates new ChordSearchEngine */
    public ChordSearchEngine() {
    }
    
    
    public Vector search(ChordValidator validator,Tuneable tuning,Properties properties) {
        lProperties=properties;
        lProperties.put("Tuning",tuning);
        lTuning=tuning;
        lValidator=validator;
        allowOpenChord=((Boolean)lProperties.getObject("AllowOpenChord",new Boolean(false))).booleanValue();
        allowExtractChord=((Boolean)lProperties.getObject("AllowExtractChord",new Boolean(false))).booleanValue();
        Vector lRetVal=new Vector(100,100);
        position=new int[tuning.getStringNumber()];
        for(int j=1;j<tuning.getStringNumber();j++) {
            while (!validator.validate(tuning.getPitch(j, position[j])))
                position[j]=(position[j]+1)%12;
        }
        startSearchPosition=lProperties.getInt("StartSearchPosition",0);
        endSearchPosition=lProperties.getInt("EndSearchPosition",15);
        frameFrets=lProperties.getInt("FrameFrets",4);
        
        int i=0;
        while (nextPosition()) {
            if (allowExtractChord)
                manageChordFrame(position,lRetVal);
            //              else {
            //                if (validator.validate(position)) {
            //                    lRetVal.add(validator.print(position));
            //                }
            //              }
        }
        //String [] retVal=new String[lRetVal.capacity()];
        //lRetVal.copyInto(retVal);
        lRetVal.trimToSize();
        return lRetVal;
    }
    
    private void manageChordFrame(int[] position,Vector lRetVal) {
        int numNote=position.length;
        int minFret=50;
        int maxFret=-1;
        for(int i=0;i<numNote;i++) {
            minFret=Math.min(minFret,position[i]);
            maxFret=Math.max(maxFret,position[i]);
        }
        int startPos=minFret-frameFrets+1;
        int endPos=maxFret+frameFrets-1;
        if (startPos<0)
            startPos=0;
        if (endPos>endSearchPosition)
            endPos=endSearchPosition;
        int[] newPosition=new int[position.length];
        for(int i=startPos;i<=endPos;i++) {
            for(int o=0;o<position.length;o++) {
                if (position[o]>=i && position[o]<=i+frameFrets)
                    newPosition[o]=position[o];
                else
                    if ((position[o]==0) && allowOpenChord)
                        newPosition[o]=position[o];
                    else
                        newPosition[o]=GuitarPosition.NO_FRET_VALUE;
            }
            
            //String ttt=lValidator.print(newPosition);
            //if (lValidator.print(newPosition).equals("X 3 5 5 5 X ")) {
            //  newPosition[1]=newPosition[1];
            //}
            if (lValidator.validate(newPosition)) {
                if(!lRetVal.contains(lValidator.print(newPosition)))
                    lRetVal.add(lValidator.print(newPosition));
            }
        }
        
    }
    
    private boolean nextPosition() {
        return increment(0);
    }
    
    private boolean increment(int string) {
        int curPos=position[string]+1;
        int tuningPitch=lTuning.getPitch(string);
        while (!lValidator.validate(curPos+tuningPitch)) {
            curPos++;
        }
        //if (curPos>=lProperties.getInt("StartSearchPosition",0) && curPos<=lProperties.getInt("EndSearchPosition",15))
        if (curPos<=endSearchPosition)
            position[string]=curPos;
        else {
            position[string]=startSearchPosition;
            if ((string+1)<lTuning.getStringNumber())
                return increment(string+1);
            else {
                return false;
            }
        }
        return true;
    }
    
    protected boolean validate(int[] position) {
        return false;
    }
    
    public static void main(String args[]) {
        //StandardChordValidator scv=new StandardChordValidator();
        BenchMarker.enterRegion("Main");
        //            for(int i=0;i<1000;i++) {
        String chordFormula="0 4 7 11 ";
        OptimizedChordValidator scv=new OptimizedChordValidator();
        it.denzosoft.denzoGuitarSoft.music.Pitch root=new it.denzosoft.denzoGuitarSoft.music.Pitch(0);
        it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord chord=new it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord(root,chordFormula);
        it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning tuning=new it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning(it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning.TUNING_STANDARD);
        it.denzosoft.denzoGuitarSoft.util.DenzoProperties prop=new it.denzosoft.denzoGuitarSoft.util.DenzoProperties();
        prop.put("StartSearchPosition",new Integer(0));
        prop.put("EndSearchPosition",new Integer(15));
        prop.put("ChordFormula",chordFormula);
        prop.put("ChordRoot",new Integer(root.getNotePitch()));
        prop.put("NoteNumber",new Integer(4));
        prop.put("FrameFrets",new Integer(5));
        prop.put("AllowOpenChord",new Boolean(false));
        prop.put("AllowInversions",new Boolean(false));
        prop.put("AllowExtractChord",new Boolean(true));
        prop.put("AllowBrokenChord",new Boolean(false));
        
        
        scv.prepare(chord,tuning,prop);
        
        ChordSearchEngine cse=new ChordSearchEngine();
        //long t=System.currentTimeMillis();
        Vector retVal=cse.search(scv,tuning,prop);
        //System.out.println((System.currentTimeMillis()-t));
        //            }
        Object[] h=retVal.toArray();
        Arrays.sort(h);
        retVal=new Vector(Arrays.asList(h));
        retVal.trimToSize();
        
        System.out.println("Hello! "+retVal.size()+" Results found");
        BenchMarker.exitRegion("Main");
    }
    
    
}
