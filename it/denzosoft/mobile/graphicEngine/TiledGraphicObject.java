/*
 * TiledGraphicObject.java
 *
 * Created on 27 ottobre 2006, 16.02
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
public class TiledGraphicObject extends GraphicObject {
    private int columns = 0;

    /** Holds value of property image. */
    private TiledImage image;

    /** Holds value of property frame. */
    private int frame;

    /** Holds value of property tileHeight. */
    private int tileHeight = 32;

    // /**
    // * Setter for property tileHeight.
    // * @param tileHeight New value of property tileHeight.
    // */
    // public void setTileHeight(int tileHeight) {
    // this.tileHeight = tileHeight;
    // setHeight(tileHeight);
    // }
    /** Holds value of property tileWidth. */
    private int tileWidth = 32;

/**
     * Creates a new TiledGraphicObject object.
     */
    public TiledGraphicObject() {
    }

/**
         * Creates a new instance of TiledGraphicObject
         */
    public TiledGraphicObject(TiledImage image) {
        this.image = image;
        columns = image.getWidth() / image.getTileWidth();
        this.setWidth(image.getTileWidth());
        this.setHeight(image.getTileHeight());
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
        int x = getX();
        int y = getY();
        // // System.out.println("painting sprite col " + (frame / columns) + ",
        // row " + (frame % rows) + ", " + clipWidth );
        // g.setClip( x, y, tileWidth, tileHeight );
        // y -= (frame / columns) * tileHeight ;
        // x -= (frame % columns) * tileWidth;
        // // Logger.debug(""+x+","+y+","+tileHeight);
        // g.drawImage( this.image, x, y );
        image.drawImage(g, frame, x, y);

        // reset original clip:
        g.setClip(clipX, clipY, clipWidth, clipHeight);
    }

    /**
     * Getter for property frame.
     *
     * @return Value of property frame.
     */
    public int getFrame() {
        return this.frame;
    }

    /**
     * Setter for property frame.
     *
     * @param frame New value of property frame.
     */
    public void setFrame(int frame) {
        this.frame = frame;
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

        if (tileWidth != 0) {
            columns = image.getWidth() / tileWidth;
        }
    }

    // public void setImage(String imageName) {
    // try {
    // setImage( TiledImage.createImage(imageName) );
    // } catch(Exception ex) {
    // Logger.error(ex);
    // }
    // }
    /**
     * Getter for property tileHeight.
     *
     * @return Value of property tileHeight.
     */
    public int getTileHeight() {
        return this.tileHeight;
    }

    /**
     * Getter for property tileWidth.
     *
     * @return Value of property tileWidth.
     */
    public int getTileWidth() {
        return this.tileWidth;
    }

    // /**
    // * Setter for property tileWidth.
    // * @param tileWidth New value of property tileWidth.
    // */
    // public void setTileWidth(int tileWidth) {
    // if (image!=null) {
    // columns = image.getWidth()/tileWidth;
    // }
    // this.tileWidth = tileWidth;
    // setWidth(tileWidth);
    // }
}
