/*
 * ChordSearchModel.java
 *
 * Created on 30 maggio 2002, 15.42
 */

package it.denzosoft.denzoGuitarSoft.gui.forms;

import it.denzosoft.denzoGuitarSoft.gui.modelViewController.*;
import it.denzosoft.denzoGuitarSoft.util.*;
import java.util.Vector;
import java.util.Arrays;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class ChordSearchModel implements Modelable {

    Properties executionRetVal;
    /** Creates new ChordSearchModel */
    public ChordSearchModel() {
    }

    public Properties getValues(String queryValues) {
        DenzoProperties prop=new DenzoProperties();
        if (queryValues.equals("SearchResults")) {
            Vector t=(Vector)executionRetVal.get("ReturnValue");
            Object[] h=t.toArray();
            Arrays.sort(h);
            Vector tt=new Vector(Arrays.asList(h));
            tt.trimToSize();
            prop.put("Values",tt);
        }
        return prop;
    }

    public void executeAction(Actionable action) {
        if (action.getName().equals("StartSearch")) {
           it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.OptimizedChordValidator scv=new it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.OptimizedChordValidator();
           it.denzosoft.denzoGuitarSoft.music.Pitch root=new it.denzosoft.denzoGuitarSoft.music.Pitch(action.getParameters().getInt("ChordRoot",0));
           it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord chord=new it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord(root,action.getParameters().getString("ChordFormula","0 4 7"));
           it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning tuning=new it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning(it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning.TUNING_STANDARD);
           //it.denzosoft.denzoGuitarSoft.util.DenzoProperties prop=new it.denzosoft.denzoGuitarSoft.util.DenzoProperties();
           it.denzosoft.denzoGuitarSoft.util.Properties prop=action.getParameters();

           //prop.put("StartSearchPosition",new Integer(0));
           //prop.put("EndSearchPosition",new Integer(15));
           executionRetVal=new DenzoProperties();
           scv.prepare(chord,tuning,prop);
	   it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.ChordSearchEngine cse=new it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.ChordSearchEngine();
	   long t=System.currentTimeMillis();
           Vector tt=cse.search(scv,tuning,prop);
	   executionRetVal.put("ReturnValue",tt);
	   System.out.println((System.currentTimeMillis()-t));
        }
    }

    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
