/*
 * Solvalou.java
 *
 * Created on 19 ottobre 2006, 14.12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.GraphicObject;
import it.denzosoft.mobile.graphicEngine.Sprite;
import it.denzosoft.mobile.graphicEngine.TiledGraphicObject;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Solvalou extends TiledGraphicObject implements Sprite {
    private GameEngine gameEngine = null;
    private boolean availableForFire = true;
    private Rectangle collisionArea = new Rectangle(8, 1, 16, 32);

/** Creates a new instance of Solvalou */
    public Solvalou(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        setFrame(239);
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        Logger.debug("userInput=" + userInput);

        if ((userInput & GameEngine.DOWN_PRESSED) != 0) {
            goDown();
        }

        if ((userInput & GameEngine.LEFT_PRESSED) != 0) {
            goLeft();
        }

        if ((userInput & GameEngine.RIGHT_PRESSED) != 0) {
            goRight();
        }

        if ((userInput & GameEngine.UP_PRESSED) != 0) {
            goUp();
        }

        if (availableForFire && ((userInput & GameEngine.FIRE_PRESSED) != 0)) {
            fire();
            availableForFire = false;
        } else {
            availableForFire = true;
        }

        if (getX() < 0) {
            setX(0);
        }

        if (getY() < 0) {
            setY(0);
        }

        if (getX() > (gameEngine.getScreenWidth() - 32)) {
            setX(gameEngine.getScreenWidth() - 32);
        }

        if (getY() > (gameEngine.getScreenHeight() - 32)) {
            setY(gameEngine.getScreenHeight() - 32);
        }

        // Logger.add("Position:"+getX()+","+getY());
        // setFrame(getFrame()+1);
    }

    /**
     * DOCUMENT ME!
     */
    public void fire() {
        ((IcelandGameEngine) gameEngine).createSolvalouWeapon(this);
    }

    /**
     * DOCUMENT ME!
     */
    public void goUp() {
        // System.out.println("Up");
        setY(getY() - 3);
    }

    /**
     * DOCUMENT ME!
     */
    public void goDown() {
        setY(getY() + 3);
    }

    /**
     * DOCUMENT ME!
     */
    public void goLeft() {
        setX(getX() - 3);
    }

    /**
     * DOCUMENT ME!
     */
    public void goRight() {
        setX(getX() + 3);
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public void collisionDetection(Sprite g) {
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Rectangle getCollisionArea() {
        return collisionArea;
    }
}
