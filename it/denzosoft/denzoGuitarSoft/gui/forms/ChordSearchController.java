/*
 * ChordSearchController.java
 *
 * Created on 30 maggio 2002, 15.40
 */

package it.denzosoft.denzoGuitarSoft.gui.forms;

import it.denzosoft.denzoGuitarSoft.gui.modelViewController.*;
import it.denzosoft.denzoGuitarSoft.util.*;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class ChordSearchController implements Controller {

    Dispatcherable lDispatcher;
    Modelable lModel;

    /** Creates new ChordSearchController */
    public ChordSearchController() {
    }

    public void happenEvent(Eventable event) {
        if (event.getName().equals("StartSearch")) {
            Action action=new Action("StartSearch",event.getParameters());
            lModel.executeAction(action);
            lDispatcher.changeView("ShowSearchResult",null);
        }
    }
    
    public void registerModel(Modelable model) {
        lModel=model;
    }
    public void registerDispatcher(Dispatcherable dispatcher) {
        lDispatcher=dispatcher;
    }
    
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */    
}
