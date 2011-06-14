/*
 * Barra.java
 *
 * Created on 14 novembre 2006, 13.25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.graphicEngine.GameEngine;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Barra extends SingleTileEnemy {
    // private static Rectangle collisionArea = new Rectangle(0,0,31,31);
/** Creates a new instance of Barra */
    public Barra(IcelandGameEngine gameEngine) {
        super(gameEngine);
        this.setFrame(296);

        // this.setCollisionArea(collisionArea);
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        setY(getY() + 1);

        if (getY() > this.getGameEngine().getScreenHeight()) {
            this.getGameEngine().removeEnemy(this);
        }
    }
}
