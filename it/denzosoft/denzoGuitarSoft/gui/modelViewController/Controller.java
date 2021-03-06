/*
 * Controller.java
 *
 * Created on 30 maggio 2002, 14.21
 */

package it.denzosoft.denzoGuitarSoft.gui.modelViewController;

import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Controller {
    public void happenEvent(Eventable event);
    public void registerModel(Modelable model);
    public void registerDispatcher(Dispatcherable dispatcher);
}

