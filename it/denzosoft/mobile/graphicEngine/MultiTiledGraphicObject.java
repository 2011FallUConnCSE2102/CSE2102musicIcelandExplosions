/*
 * MultiTiledGraphicObject.java
 *
 * Created on 17 novembre 2006, 14.43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import javax.microedition.lcdui.Graphics;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class MultiTiledGraphicObject extends GraphicObject {
    /** Creates a new instance of MultiTiledGraphicObject */
    private int[] frames = null;
    private int[] xPos = null;
    private int[] yPos = null;
    private int size = 0;

    /** Holds value of property image. */
    private TiledImage image;

/**
     * Creates a new MultiTiledGraphicObject object.
     *
     * @param size DOCUMENT ME!
     */
    public MultiTiledGraphicObject(int size) {
        this.size = size;
        frames = new int[size];
        xPos = new int[size];
        yPos = new int[size];
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public void paint(Graphics g) {
        int clipX = g.getClipX();
        int clipY = g.getClipY();
        int clipWidth = g.getClipWidth();
        int clipHeight = g.getClipHeight();

        for (int i = 0; i < size; i++) {
            image.drawImage(g, frames[i], xPos[i], yPos[i]);
        }

        g.setClip(clipX, clipY, clipWidth, clipHeight);
    }

    /**
     * Getter for property image.
     *
     * @return Value of property image.
     */
    public TiledImage getImage() {
        return this.image;
    }

    /**
     * Setter for property image.
     *
     * @param image New value of property image.
     */
    public void setImage(TiledImage image) {
        this.image = image;
    }

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param index DOCUMENT ME!
     */
    public void setTilePosition(int x, int y, int index) {
        xPos[index] = x;
        yPos[index] = y;
    }

    /**
     * DOCUMENT ME!
     *
     * @param frame DOCUMENT ME!
     * @param index DOCUMENT ME!
     */
    public void setTileFrame(int frame, int index) {
        frames[index] = frame;
    }

    /**
     * DOCUMENT ME!
     *
     * @param index DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTileFrame(int index) {
        return frames[index];
    }

    /**
     * DOCUMENT ME!
     *
     * @param index DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTileX(int index) {
        return xPos[index];
    }

    /**
     * DOCUMENT ME!
     *
     * @param index DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTileY(int index) {
        return yPos[index];
    }
}
