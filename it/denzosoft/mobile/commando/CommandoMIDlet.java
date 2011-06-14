/*
 * CommandoMIDlet.java
 *
 * Created on 26 ottobre 2006, 17.57
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.commando;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameMIDlet;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class CommandoMIDlet extends GameMIDlet {
    /**
     * DOCUMENT ME!
     */
    public void startGame() {
        try {
            LayeredCanvas gameCanvas = new LayeredCanvas(this);
            CommandoEngine ge = new CommandoEngine(gameCanvas);
            setGameEngine(ge);
            ge.startGame();
            getDisplay().setCurrent(gameCanvas);
        } catch (Exception ex) {
            Logger.error(ex);

            // Logger.showAlert(getDisplay(),Alert.FOREVER);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getName() {
        return "Commando";
    }
}
