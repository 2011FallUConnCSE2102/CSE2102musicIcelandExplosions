/*
 * Modelable.java
 *
 * Created on 30 maggio 2002, 14.30
 */

package it.denzosoft.denzoGuitarSoft.gui.modelViewController;

import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Modelable {
    public void executeAction(Actionable action);
    public Properties getValues(String queryValues);
}

