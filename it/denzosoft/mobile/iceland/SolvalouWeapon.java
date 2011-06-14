/*
 * SolvalouWeapon.java
 *
 * Created on 10 novembre 2006, 14.38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.Sprite;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class SolvalouWeapon extends SingleTileEnemy {
    /** Creates a new instance of SolvalouWeapon */
    private static int[] frames = new int[] { 40, 41 };
    private static Rectangle collisionArea = new Rectangle(8, 1, 24, 6);

/** Creates a new instance of Toroid */
    public SolvalouWeapon(IcelandGameEngine gameEngine) {
        super(gameEngine);
        this.setFrames(frames);
        this.setCollisionArea(collisionArea);
        this.setFrame(getCurrentFrame());
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean verifyCollision(Sprite g) {
        return false;
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        setFrame(nextFrame());
        Logger.debug("weapon frame:" + getCurrentFrameIndex());
        setY(getY() - 6);

        if (getY() < 0) {
            ((IcelandGameEngine) getGameEngine()).removeSolvalouWeapon(this);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param sprite DOCUMENT ME!
     */
    public void collisionDetection(Sprite sprite) {
    }
}
