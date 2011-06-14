/*
 * ChordSearchStarter.java
 *
 * Created on 30 maggio 2002, 15.43
 */

package it.denzosoft.denzoGuitarSoft.gui.forms;

import it.denzosoft.denzoGuitarSoft.gui.modelViewController.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public class ChordSearchStarter {

    /** Creates new ChordSearchStarter */
    public ChordSearchStarter() {
    }


     public static void main(String args[]) {
         ChordSearchModel model=new ChordSearchModel();
         ChordSearchApp gui=new ChordSearchApp();
         Controller controller=new ChordSearchController();
         controller.registerModel(model);
         controller.registerDispatcher(gui);
         gui.registerController(controller);
         gui.registerModel(model);
         gui.show();
     }
}
