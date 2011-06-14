/*
 * GameMIDlet.java
 *
 * Created on 19 ottobre 2006, 13.28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.BasicMIDlet;

import javax.microedition.lcdui.Image;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public abstract class GameMIDlet extends BasicMIDlet implements Runnable {
    /** Holds value of property gameEngine. */
    private GameEngine gameEngine;

    /**
     * DOCUMENT ME!
     */
    public final void run() {
        showMenu();
    }

    /**
     * DOCUMENT ME!
     */
    public void showMenu() {
        MenuCanvas menu = new MenuCanvas(this);
        menu.setName(this.getName());

        try {
            menu.setDevLogo("/denzosoft.png");
        } catch (Exception ex) {
        } finally {
            this.getDisplay().setCurrent(menu);
        }

        // startGame();
    }

    /**
     * DOCUMENT ME!
     */
    public abstract void startGame();

    /**
     * Getter for property gameEngine.
     *
     * @return Value of property gameEngine.
     */
    public GameEngine getGameEngine() {
        return this.gameEngine;
    }

    /**
     * Setter for property gameEngine.
     *
     * @param gameEngine New value of property gameEngine.
     */
    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getName() {
        return "Game Name";
    }
}
