/*
 * SingleTileEnemy.java
 *
 * Created on 9 novembre 2006, 11.58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.Rectangle;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.Sprite;
import it.denzosoft.mobile.graphicEngine.TiledGraphicObject;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public abstract class SingleTileEnemy extends TiledGraphicObject
    implements Sprite {
    private static Rectangle defaultCollisionArea = new Rectangle(0, 0, 31, 31);
    private IcelandGameEngine gameEngine = null;

    /** Holds value of property frames. */
    private int[] frames;
    private int currentFrameIndex;
    private Rectangle collisionArea = defaultCollisionArea;

/**
         * Creates a new instance of SingleTileEnemy
         */
    public SingleTileEnemy(IcelandGameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * Getter for property gameEngine.
     *
     * @return Value of property gameEngine.
     */
    protected IcelandGameEngine getGameEngine() {
        return gameEngine;
    }

    /**
     * Getter for property frames.
     *
     * @return Value of property frames.
     */
    public int[] getFrames() {
        return this.frames;
    }

    /**
     * Setter for property frames.
     *
     * @param frames New value of property frames.
     */
    public void setFrames(int[] frames) {
        this.frames = frames;
        currentFrameIndex = 0;
    }

    /**
     * Getter for property currentFrame.
     *
     * @return Value of property currentFrame.
     */
    public int getCurrentFrameIndex() {
        return this.currentFrameIndex;
    }

    /**
     * Setter for property currentFrame.
     *
     * @param currentFrameIndex New value of property currentFrame.
     */
    public void setCurrentFrameIndex(int currentFrameIndex) {
        this.currentFrameIndex = currentFrameIndex;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int nextFrame() {
        currentFrameIndex = ((currentFrameIndex + 1) % frames.length);

        return frames[currentFrameIndex];
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int previousFrame() {
        currentFrameIndex = ((currentFrameIndex - 1 + frames.length) % frames.length);

        return frames[currentFrameIndex];
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getCurrentFrame() {
        return frames[currentFrameIndex];
    }

    /**
     * DOCUMENT ME!
     *
     * @param collisionArea DOCUMENT ME!
     */
    protected void setCollisionArea(Rectangle collisionArea) {
        this.collisionArea = collisionArea;
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
