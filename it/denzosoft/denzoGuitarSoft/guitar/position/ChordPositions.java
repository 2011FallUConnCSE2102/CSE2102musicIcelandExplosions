/*
 * ChordPosition.java
 *
 * Created on 31 maggio 2002, 12.01
 */

package it.denzosoft.denzoGuitarSoft.guitar.position;

import it.denzosoft.denzoGuitarSoft.util.*;
import java.util.Vector;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class ChordPositions extends GuitarPositions{

    /** Creates new ChordPosition */
    public ChordPositions() {
    }

    public ChordPositions(String position) {
        clear();
        String[] pos=StringFunctions.split(position);
        GuitarPosition newPos;
        int counter=-1;
        for(int i=0;i<pos.length;i++) {
            String fret=pos[i];
            if (fret.equals(GuitarPosition.NO_FRET)) {
                //newPos=new GuitarPosition(i,GuitarPosition.NO_FRET_VALUE);
            } else {
              counter++;
              newPos=new GuitarPosition(i,Integer.parseInt(fret));
              add(counter,newPos);
            }
        }
    }

    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
