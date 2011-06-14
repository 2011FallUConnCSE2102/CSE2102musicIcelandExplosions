/*
 * mvcEvent.java
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
public interface Eventable {
    public void setParameters(Properties parameters);
    public Properties getParameters();
    public String getName();
}

