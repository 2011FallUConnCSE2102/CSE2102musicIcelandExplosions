/*
 * AirExplosion.java
 *
 * Created on 10 novembre 2006, 14.15
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.Sprite;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class AirExplosion extends SingleTileEnemy {
    private static final int[] frames = new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

/** Creates a new instance of Toroid */
    public AirExplosion(IcelandGameEngine gameEngine) {
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

        if (getCurrentFrameIndex() == 0) {
            ((IcelandGameEngine) getGameEngine()).removeExplosion(this);
        }

        setY(getY() + 1);
    }
}
