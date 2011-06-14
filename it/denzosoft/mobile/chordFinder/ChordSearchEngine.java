/*
 * ChordSearchEngine.java
 *
 * Created on 24 maggio 2002, 17.45
 */

package it.denzosoft.mobile.chordFinder;

import java.util.*;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class ChordSearchEngine {
    
    protected int[] position;
    
    protected Tuning lTuning=null;
    protected Properties lProperties;
    protected ChordValidator lValidator=null;
    protected boolean allowOpenChord=false;
    protected boolean allowExtractChord=false;
    protected int startSearchPosition;
    protected int endSearchPosition;
    protected int frameFrets;
    protected Vector lRetVal=null;
    /** Creates new ChordSearchEngine */
    public ChordSearchEngine() {
    }
    
    public void startSearch(ChordValidator validator,Tuning tuning,Properties properties) {
        lProperties=properties;
        lProperties.put("Tuning",tuning);
        lTuning=tuning;
        lValidator=validator;
        allowOpenChord=((Boolean)lProperties.getObject("AllowOpenChord",new Boolean(false))).booleanValue();
        allowExtractChord=((Boolean)lProperties.getObject("AllowExtractChord",new Boolean(false))).booleanValue();
        lRetVal=new Vector();
        position=new int[tuning.getStringNumber()];
        for(int j=1;j<tuning.getStringNumber();j++) {
            while (!validator.validate(tuning.getPitch(j, position[j])))
                position[j]=(position[j]+1)%12;
        }
        startSearchPosition=lProperties.getInt("StartSearchPosition",0);
        endSearchPosition=lProperties.getInt("EndSearchPosition",15);
        frameFrets=lProperties.getInt("FrameFrets",4);
    }
    
    public Vector nextSearch() {
        //int i=0;
        while (nextPosition()) {
            if (allowExtractChord)
                if (manageChordFrame(position,lRetVal)) {
                    return lRetVal;
                }
            //              else {
            //                if (validator.validate(position)) {
            //                    lRetVal.add(validator.print(position));
            //                }
            //              }
        }
        return lRetVal;
    }
/*
    public Vector search(ChordValidator validator,Tuning tuning,Properties properties) {
        System.out.println("SOno entrato");
        lProperties=properties;
        lProperties.put("Tuning",tuning);
        lTuning=tuning;
        lValidator=validator;
        allowOpenChord=((Boolean)lProperties.getObject("AllowOpenChord",new Boolean(false))).booleanValue();
        allowExtractChord=((Boolean)lProperties.getObject("AllowExtractChord",new Boolean(false))).booleanValue();
        Vector lRetVal=new Vector();
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
        //lRetVal.trimToSize();
        return lRetVal;
    }
 */
    private boolean manageChordFrame(int[] position,Vector lRetVal) {
        int numNote=position.length;
        int minFret=50;
        int maxFret=-1;
        boolean retVal=false;
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
        String currentChord;
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
                currentChord=lValidator.print(newPosition);
                if(!lRetVal.contains(currentChord)) {
//                if(!contains(currentChord)) {
                    lRetVal.addElement(currentChord);
                    retVal= true;
                }
            }
        }
        return retVal;
    }
    
    private boolean contains(String key) {
        int length=lRetVal.size();
        for(int i=0;i<length;i++){
            if (lRetVal.elementAt(i).equals(key))
                return true;
        }
        return false;
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
        //System.out.println("Increment");
        return true;
    }
    
    protected boolean validate(int[] position) {
        return false;
    }
    
    public static void main(String args[]) {
        //StandardChordValidator scv=new StandardChordValidator();
        //            for(int i=0;i<1000;i++) {
        String chordFormula="0 4 7 11";
        OptimizedChordValidator scv=new OptimizedChordValidator();
        Pitch root=new Pitch(0);
        PitchedChord chord=new PitchedChord(root,chordFormula);
        Tuning tuning=new Tuning(Tuning.TUNING_STANDARD);
        DenzoProperties prop=new DenzoProperties();
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
        //Vector retVal=cse.search(scv,tuning,prop);
        //System.out.println((System.currentTimeMillis()-t));
        //            }
        //        Object[] h=retVal.copyInto(toArray();
        //        Arrays.sort(h);
        //        retVal=new Vector(Arrays.asList(h));
        //        retVal.trimToSize();
        cse.startSearch(scv,tuning,prop);
        Vector pos;
        int last=0;
        while ((pos=cse.nextSearch())!=null) {
            for(int i=last;i<pos.size();i++) {
                System.out.println(pos.elementAt(i));
                last++;
            }
            //System.out.println(pos);
        }
        //        System.out.println("Hello! "+retVal.size()+" Results found");
        //        for(int i=0;i<retVal.size();i++) {
        //            System.out.println(retVal.elementAt(i));
        //        }
    }
    
    
}
