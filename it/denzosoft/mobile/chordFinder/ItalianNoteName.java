/*
 * ItalianNoteName.java
 *
 * Created on 23 maggio 2002, 17.27
 */

package it.denzosoft.mobile.chordFinder;


/**
 *
 * @author  De Sanctis
 * @version 
 */
public class ItalianNoteName {
    private static String Names="Do  Do# Re  Re# Mi  Fa  Fa# Sol Sol#La  La# Si  ";
    private static ItalianNoteName noteName=null;
    
    /** Creates new ItalianNoteName */
    private ItalianNoteName() {
    }

    public static String getName(Pitch pitch) {
        return getName(pitch.getNotePitch());
    }
    
    public static String getName(int notePitch) {
        return Names.substring(notePitch*4,notePitch*4+4).trim();
    }

//    public static ItalianNoteName getInstance() {
//        if (noteName==null) {
//            noteName=new ItalianNoteName();
//        } 
//        return noteName;            
//    }
     
    
}
