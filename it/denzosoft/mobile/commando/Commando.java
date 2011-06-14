/*
 * Commando.java
 *
 * Created on 26 ottobre 2006, 17.24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.commando;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.Sprite;
import it.denzosoft.mobile.graphicEngine.TiledGraphicObject;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Commando extends TiledGraphicObject implements Sprite {
    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_N = 1;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_NE = 3;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_E = 2;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_SE = 6;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_S = 4;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_SW = 12;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_W = 8;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_NW = 9;

    /**
     * DOCUMENT ME!
     */
    public static final byte DIRECTION_STOPPED = 0;

    /**
     * DOCUMENT ME!
     */
    public static final int MOVEMENT_MULTIPLIER = 2;

    /**
     * DOCUMENT ME!
     */
    public static final int LINEAR_MOVEMENT = 1000 * MOVEMENT_MULTIPLIER;

    /**
     * DOCUMENT ME!
     */
    public static final int DIAGONAL_MOVEMENT = 700 * MOVEMENT_MULTIPLIER;
    private byte direction = DIRECTION_STOPPED;
    private int currentBaseFrame = 0;

    // Keep postions * 1000
    private int posX = -1;
    private int posY = -1;
    private byte counterImage = 0;

/** Creates a new instance of Commando */
    public Commando() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput) {
        Logger.debug("userInput=" + userInput);
        direction = DIRECTION_STOPPED;

        if ((userInput & GameEngine.DOWN_PRESSED) != 0) {
            direction = (byte) (direction | DIRECTION_S);
        }

        if ((userInput & GameEngine.LEFT_PRESSED) != 0) {
            direction = (byte) (direction | DIRECTION_W);
        }

        if ((userInput & GameEngine.RIGHT_PRESSED) != 0) {
            direction = (byte) (direction | DIRECTION_E);
        }

        if ((userInput & GameEngine.UP_PRESSED) != 0) {
            direction = (byte) (direction | DIRECTION_N);
        }

        if ((userInput & GameEngine.FIRE_PRESSED) != 0) {
            // fire();
        }

        switch (direction) {
        case DIRECTION_S:
            posY = posY + LINEAR_MOVEMENT;
            currentBaseFrame = 12;

            break;

        case DIRECTION_SE:
            posY = posY + DIAGONAL_MOVEMENT;
            posX = posX + DIAGONAL_MOVEMENT;
            currentBaseFrame = 9;

            break;

        case DIRECTION_E:
            posX = posX + LINEAR_MOVEMENT;
            currentBaseFrame = 6;

            break;

        case DIRECTION_NE:
            posY = posY - DIAGONAL_MOVEMENT;
            posX = posX + DIAGONAL_MOVEMENT;
            currentBaseFrame = 3;

            break;

        case DIRECTION_N:
            posY = posY - LINEAR_MOVEMENT;
            currentBaseFrame = 0;

            // currentBaseFrame = 24;
            break;

        case DIRECTION_NW:
            posY = posY - DIAGONAL_MOVEMENT;
            posX = posX - DIAGONAL_MOVEMENT;
            currentBaseFrame = 21;

            break;

        case DIRECTION_W:
            posX = posX - LINEAR_MOVEMENT;
            currentBaseFrame = 18;

            break;

        case DIRECTION_SW:
            posY = posY + DIAGONAL_MOVEMENT;
            posX = posX - DIAGONAL_MOVEMENT;
            currentBaseFrame = 15;

            break;
        }

        setX(posX / 1000);
        setY(posY / 1000);

        if (direction != DIRECTION_STOPPED) {
            counterImage++;
        }

        if (counterImage > 8) {
            counterImage = 0;
        }

        setFrame(currentBaseFrame + (counterImage / 3));
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
        return new Rectangle(0, 0, 32, 32);
    }
}
