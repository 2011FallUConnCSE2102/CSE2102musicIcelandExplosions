/*
 * RacingMidlet.java
 *
 * Created on 26 ottobre 2006, 16.32
 */
package it.denzosoft.mobile.racing;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.GameMIDlet;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 * @version
 */
public class RacingMidlet extends GameMIDlet {
    /**
     * DOCUMENT ME!
     */
    public void startGame() {
        try {
            LayeredCanvas gameCanvas = new LayeredCanvas(this);
            GameEngine ge = new RacingEngine(gameCanvas);
            ge.setIntervalLoop(20);
            setGameEngine(ge);
            ge.startGame();
            getDisplay().setCurrent(gameCanvas);
        } catch (Exception ex) {
            Logger.error(ex);
        }
    }
}
