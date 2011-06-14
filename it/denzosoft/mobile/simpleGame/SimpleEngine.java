/*
 * SimpleEngine.java
 *
 * Created on 26 ottobre 2006, 18.00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.simpleGame;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;
import it.denzosoft.mobile.graphicEngine.TiledImage;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class SimpleEngine extends GameEngine {
    /**
     * DOCUMENT ME!
     */
    LayeredCanvas canvas = null;
    private SimpleSprite sp = null;

/** Creates a new instance of XeviousEngine */
    public SimpleEngine(LayeredCanvas canvas) {
        super(canvas);
        this.canvas = canvas;
        init();
    }

    private void init() {
        try {
            sp = new SimpleSprite();
            sp.setImage("/BlackMage0.png");
            sp.setVisible(true);
            canvas.add(sp, LayeredCanvas.ZORDER_TOP);
        } catch (Exception ex) {
            Logger.error(ex);

            // Logger.showAlert(canvas.getMIDlet().getDisplay(),1000);
        }
    }

    /**
     * DOCUMENT ME!
     */
    public void gameTick() {
        Logger.debug("##############");
        Logger.memory();
        sp.execute(getKeyStates());
    }

    /**
     * DOCUMENT ME!
     *
     * @param c DOCUMENT ME!
     * @param displayable DOCUMENT ME!
     */
    public void commandAction(Command c, Displayable displayable) {
    }
}
