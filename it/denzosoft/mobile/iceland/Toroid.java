/*
 * Toroid.java
 *
 * Created on 9 novembre 2006, 12.05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.common.util.Logger;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Toroid extends SingleTileEnemy {
    private static int[] frames = new int[] {
            304, 305, 306, 307, 308, 309, 310, 311
        };
    private static Rectangle collisionArea = new Rectangle(6, 6, 13, 13);
    private boolean fired = false;

/** Creates a new instance of Toroid */
    public Toroid(IcelandGameEngine gameEngine) {
        super(gameEngine);
        this.setFrames(frames);
        this.setFrame(getCurrentFrame());
        this.setCollisionArea(collisionArea);
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        this.setFrame(nextFrame());
        this.setY(getY() + 2);

        if (getY() > getGameEngine().getScreenHeight()) {
            ((IcelandGameEngine) getGameEngine()).removeEnemy(this);
        }

        // Logger.debug("Current frame: "+getCurrentFrame());
        if (!fired && (getGameEngine().getRandom(1000) < 10)) {
            fired = true;
            ((IcelandGameEngine) getGameEngine()).createEnemyWeapon(this);
        }
    }
}
