/*
 * GameCanvas.java
 *
 * Created on 19 ottobre 2006, 13.20
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.BasicCanvas;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public abstract class GameCanvas extends BasicCanvas implements CommandListener {
    /** DOCUMENT ME! */
    public final Command pauseCommand = new Command("Pause", Command.STOP, 61);

    /** DOCUMENT ME! */
    public final Command restartCommand = new Command("Restart", Command.STOP,
            62);

/** Creates a new instance of GameCanvas */
    public GameCanvas(GameMIDlet midlet) {
        super(midlet);
        this.addCommand(pauseCommand);
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public GameMIDlet getGameMIDlet() {
        return (GameMIDlet) this.getMIDlet();
    }

    /**
     * DOCUMENT ME!
     *
     * @param c DOCUMENT ME!
     * @param displayable DOCUMENT ME!
     */
    public void commandAction(Command c, Displayable displayable) {
        // super.commandAction(c,displayable);
        if (c == exitCommand) {
            getGameMIDlet().getGameEngine().stopGame();
            getGameMIDlet().showMenu();

            // super.commandAction(c,displayable);
        } else if (c == pauseCommand) {
            this.removeCommand(pauseCommand);
            this.addCommand(restartCommand);
            getGameMIDlet().getGameEngine().pauseGame();
        } else if (c == restartCommand) {
            this.removeCommand(restartCommand);
            this.addCommand(pauseCommand);
            getGameMIDlet().getGameEngine().restartGame();
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param keyCode DOCUMENT ME!
     */
    protected void keyReleased(int keyCode) {
        getGameMIDlet().getGameEngine().keyReleased(keyCode);
    }

    /**
     * DOCUMENT ME!
     *
     * @param keyCode DOCUMENT ME!
     */
    protected void keyPressed(int keyCode) {
        getGameMIDlet().getGameEngine().keyPressed(keyCode);
    }
}
