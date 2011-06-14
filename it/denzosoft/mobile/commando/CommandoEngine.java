/*
 * CommandoEngine.java
 *
 * Created on 26 ottobre 2006, 17.23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.commando;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.LayeredCanvas;
import it.denzosoft.mobile.graphicEngine.TiledImage;
import it.denzosoft.mobile.iceland.EnergyBar;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Displayable;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class CommandoEngine extends GameEngine {
    /**
     * DOCUMENT ME!
     */
    LayeredCanvas canvas = null;
    private Commando commando = null;
    private EnergyBar energyBar = new EnergyBar();

/** Creates a new instance of CommandoEngine */
    public CommandoEngine(LayeredCanvas canvas) {
        super(canvas);
        this.canvas = canvas;
        init();
    }

    private void init() {
        try {
            commando = new Commando();

            TiledImage spriteImg = new TiledImage("/guy.png", 32, 32);
            commando.setImage(spriteImg);
            commando.setVisible(true);
            canvas.add(commando, LayeredCanvas.ZORDER_TOP);
            energyBar.setWidth(this.getScreenWidth() / 2);
            energyBar.setX(this.getScreenWidth() / 2);
            energyBar.setHeight(10);
            energyBar.setFull(100);
            energyBar.setDanger(10);
            energyBar.setWarning(25);
            energyBar.setVisible(true);
            canvas.add(energyBar, LayeredCanvas.ZORDER_TOPMOST);
            energyBar.setEnergy(100);
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
        commando.execute(getKeyStates());
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
