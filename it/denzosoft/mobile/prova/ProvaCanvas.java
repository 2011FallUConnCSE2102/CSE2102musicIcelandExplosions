/*
 * ProvaCanvas.java
 *
 * Created on 24 ottobre 2006, 14.06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.prova;

import it.denzosoft.mobile.common.BasicCanvas;
import it.denzosoft.mobile.common.BasicMIDlet;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class ProvaCanvas extends BasicCanvas {
/** Creates a new instance of ProvaCanvas */
    public ProvaCanvas(BasicMIDlet midlet) {
        super(midlet);
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    protected void paint(Graphics g) {
        try {
            Image image = Image.createImage("/images/ffTown/StoneLL.png");
            g.drawImage(image, 10, 10, g.TOP | g.LEFT);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
