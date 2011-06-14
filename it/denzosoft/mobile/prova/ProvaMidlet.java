/*
 * ProvaMidlet.java
 *
 * Created on 24 ottobre 2006, 14.00
 */
package it.denzosoft.mobile.prova;

import it.denzosoft.mobile.common.BasicMIDlet;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 * @version
 */
public class ProvaMidlet extends BasicMIDlet {
    /**
     * DOCUMENT ME!
     */
    public void run() {
        this.getDisplay().setCurrent(new ProvaCanvas(this));
    }
}
