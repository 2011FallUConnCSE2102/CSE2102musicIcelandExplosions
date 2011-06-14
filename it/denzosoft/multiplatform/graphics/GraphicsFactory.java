/*
 * GraphicsFactory.java
 *
 * Created on 26 ottobre 2006, 12.44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.multiplatform.graphics;

import it.denzosoft.mobile.common.graphic.J2meGraphics;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class GraphicsFactory {
/** Creates a new instance of GraphicsFactory */
    private GraphicsFactory() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static Graphics getGraphics(javax.microedition.lcdui.Graphics g) {
        return new J2meGraphics(g);
    }
}
