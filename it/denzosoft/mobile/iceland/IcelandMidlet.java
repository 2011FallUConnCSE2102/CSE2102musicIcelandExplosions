/*
 * IcelandMidlet.java
 *
 * Created on 2 novembre 2006, 16.39
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.GameMIDlet;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;
import it.denzosoft.mobile.graphicEngine.MenuCanvas;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 * @version
 */
public class IcelandMidlet extends GameMIDlet {
    /**
     * DOCUMENT ME!
     */
    public void startGame() {
        try {
            LayeredCanvas gameCanvas = new LayeredCanvas(this);
            GameEngine ge = new IcelandGameEngine(gameCanvas);
            setGameEngine(ge);
            ge.startGame();
            getDisplay().setCurrent(gameCanvas);
        } catch (Exception ex) {
            Logger.error(ex);
        }
    }

    /**
     * DOCUMENT ME!
     */
    public void showMenu() {
        try {
            MenuCanvas menu = new MenuCanvas(this);
            menu.setLogo("/logo.png");
            menu.setDevLogo("/denzosoft.png");
            menu.setForecolor(0xbde7ff);
            getDisplay().setCurrent(menu);
        } catch (Exception ex) {
            Logger.error(ex);
        }
    }
}
