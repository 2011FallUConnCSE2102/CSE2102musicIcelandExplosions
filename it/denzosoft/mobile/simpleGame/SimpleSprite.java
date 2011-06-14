/*
 * SimpleSprite.java
 *
 * Created on 26 ottobre 2006, 18.00
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.simpleGame;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.graphicEngine.BasicGraphicObject;
import it.denzosoft.mobile.graphicEngine.GraphicObject;
import it.denzosoft.mobile.graphicEngine.Sprite;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class SimpleSprite extends BasicGraphicObject implements Sprite {
/** Creates a new instance of SimpleSprite */
    public SimpleSprite() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
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
     * @param sprite DOCUMENT ME!
     */
    public void collisionDetection(Sprite sprite) {
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Rectangle getCollisionArea() {
        return null;
    }
}
