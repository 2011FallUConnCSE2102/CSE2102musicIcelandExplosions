/*
 * SimpleMIDlet.java
 *
 * Created on 26 ottobre 2006, 18.00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.simpleGame;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.GameMIDlet;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class SimpleMIDlet extends GameMIDlet {
    /**
     * DOCUMENT ME!
     */
    public void startGame() {
        try {
            LayeredCanvas gameCanvas = new LayeredCanvas(this);
            GameEngine ge = new SimpleEngine(gameCanvas);
            setGameEngine(ge);
            ge.startGame();
            getDisplay().setCurrent(gameCanvas);
        } catch (Exception ex) {
            Logger.error(ex);

            // Logger.showAlert(getDisplay(),Alert.FOREVER);
        }
    }
}
