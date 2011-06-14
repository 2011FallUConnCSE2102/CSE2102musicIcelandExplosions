/*
 * GuitarPositions.java
 *
 * Created on 20 maggio 2004, 15.02
 */

package it.denzosoft.mobile.chordFinder;

import it.denzosoft.mobile.StringFunctions;
import java.util.*;

// Referenced classes of package it.denzosoft.denzoGuitarSoft.guitar.position:
//            Positions

public class GuitarPositions extends Vector {
    private Tuning lTuning;
    private Hashtable hm;
    
    public GuitarPositions(String position) {
        this();
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
              this.addElement(newPos);
            }
        }
    }
    
    public GuitarPositions() {
        lTuning = new Tuning(0);
        hm=new Hashtable();
    }
    
    public Tuning getTuning() {
        return lTuning;
    }
    
    public void setTuning(Tuning tuning) {
        lTuning = tuning;
    }
    
    public Object getProperty(String name) {
        return hm.get(name);
    }
    
    public void setProperty(String name, Object value) {
        if (hm.containsKey(name)) {
            hm.remove(name);
        }
        hm.put(name, value);
    }
    
    public Object get(int i) {
        return this.elementAt(i);
    }
}