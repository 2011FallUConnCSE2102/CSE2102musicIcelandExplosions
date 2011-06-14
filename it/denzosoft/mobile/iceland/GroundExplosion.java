/*
 * GroundExplosion.java
 *
 * Created on 14 novembre 2006, 13.30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.graphicEngine.GameEngine;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class GroundExplosion extends SingleTileEnemy {
    private static int[] frames = new int[] { 11, 12, 13, 14, 15, 15, 17 };

/** Creates a new instance of Toroid */
    public GroundExplosion(IcelandGameEngine gameEngine) {
        super(gameEngine);
        this.setFrames(frames);
        this.setFrame(getCurrentFrame());
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        setFrame(nextFrame());
        setY(getY() + 1);

        if (getY() > getGameEngine().getScreenHeight()) {
            getGameEngine().removeExplosion(this);
        }
    }
}
