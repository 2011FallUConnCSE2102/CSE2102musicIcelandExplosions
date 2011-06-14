/*
 * Chord.java
 *
 * Created on 24 maggio 2002, 10.19
 */

package it.denzosoft.mobile.chordFinder;

import it.denzosoft.mobile.StringFunctions;


/**
 *
 * @author  De Sanctis
 * @version
 */
public class PitchedChord {
    private Pitch lRoot=null;
    private int chordImage=0;
    private int absoluteChordImage=0;
    
    /** Creates new Chord */
    public PitchedChord(Pitch root) {
        lRoot=root;
        //setFormula("0");
    }
    
    public PitchedChord(Pitch root,String formula) {
        lRoot=root;
        setFormula(formula);
    }
    
    /** Setter for property formula.
     * @param formula New value of property formula.
     */
    public void setFormula(String formula) {
        //System.out.println(formula);
        String[] formulaItems=StringFunctions.split("0 "+formula);
        int tmp;
        this.chordImage=0;
        this.absoluteChordImage=0;
        int startingPitch;
        if (lRoot==null)
            startingPitch=0;
        else
            startingPitch=lRoot.getPitch();
        for(int i=0;i<formulaItems.length;i++) {
            //System.out.println(Integer.parseInt(formulaItems[i].trim()));
            this.chordImage=(chordImage | pow2(Integer.parseInt(formulaItems[i].trim())));
            //System.out.println(chordImage);
            tmp=( pow2((Integer.parseInt(formulaItems[i])+12+startingPitch) % 12));
            this.absoluteChordImage=(absoluteChordImage | tmp);
            //System.out.println(absoluteChordImage);
        }
    }
    
    /** Getter for property formula.
     * @return Value of property formula.
     */
    public String getFormula() {
        String retVal="";
        for(int i=0;i<12;i++) {
            if ((chordImage & pow2(i))>0)
                retVal=retVal+i+" ";
        }
        return retVal.trim();
    }
    
    /** Setter for property root.
     * @param root New value of property root.
     */
    public void setRoot(Pitch root) {
        lRoot=root;
    }
    
    /** Getter for property root.
     * @return Value of property root.
     */
    public Pitch getRoot() {
        return lRoot;
    }
    
    public boolean isInChord(Pitch pitch) {
        return ((absoluteChordImage & pow2(pitch.getNotePitch()))>0);
    }
    
    public int itemNumber() {
        int noteNumber=0;
        for(int i=0;i<12;i++)
            if ((chordImage & pow2(i))>0)
                noteNumber++;
        return noteNumber;
    }
    
    
    public int[] getPitches() {
        int noteNumber=itemNumber();
        int[] retVal=new int[noteNumber];
        noteNumber=0;
        for(int i=0;i<12;i++)
            if ((chordImage & pow2(i))>0) {
                retVal[noteNumber]=i;
                noteNumber++;
            }
        return retVal;
    }
    
    protected final static int[] powValues={1,2,4,8,16,32,64,128,256,512,1024,2048};
    protected int pow2(int number) {
        return powValues[number];
    }
    
    public static void main(String args[]) {
        Pitch first=new Pitch(12);
        Pitch second=new Pitch(4,1);
        PitchedChord tmp1=new PitchedChord(first);
        tmp1.setFormula("0 4 7");
        PitchedChord tmp2=new PitchedChord(second, "0 3 7");
        System.out.println(tmp1.getFormula()+";"+tmp2.getFormula());
        Pitch pippo;
        //ItalianNoteName inm=ItalianNoteName.getInstance();
        for (int i=0;i<12;i++) {
            pippo=new Pitch(i);
            if(tmp1.isInChord(pippo)) {
                String tt=ItalianNoteName.getName(pippo);
                System.out.println(ItalianNoteName.getName(pippo));
            }
        }
        System.out.println(tmp1.isInChord(second));
        System.out.println(tmp2.isInChord(first));
    }
}
