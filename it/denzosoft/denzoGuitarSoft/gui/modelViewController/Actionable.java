/*
 * Action.java
 *
 * Created on 30 maggio 2002, 14.22
 */

package it.denzosoft.denzoGuitarSoft.gui.modelViewController;

import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface Actionable {
    public String getName();
    public Properties getParameters();
    public void setParameters(Properties parameters);
}

