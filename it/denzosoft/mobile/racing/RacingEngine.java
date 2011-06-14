/*
 * RacingEngine.java
 *
 * Created on 26 ottobre 2006, 16.33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.racing;

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
public class RacingEngine extends GameEngine {
    /**
     * DOCUMENT ME!
     */
    LayeredCanvas canvas = null;
    private RacingMap map = null;

/** Creates a new instance of RacingEngine */
    public RacingEngine(LayeredCanvas canvas) {
        super(canvas);
        this.canvas = canvas;
        init();
    }

    private void init() {
        try {
            TiledImage mapImg = new TiledImage("/circuit.png", 176, 139);
            map = new RacingMap();
            map.setImage(mapImg);
            map.setVisible(true);
            map.setLoopX(false);
            map.setLoopY(true);
            canvas.add(map, LayeredCanvas.ZORDER_BOTTOMMOST);
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
        // solvalou.execute(getKeyStates());
        map.setY(map.getY() + 2);
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
