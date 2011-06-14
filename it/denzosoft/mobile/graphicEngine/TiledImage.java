/*
 * TiledImage.java
 *
 * Created on 25 ottobre 2006, 15.35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.util.Logger;

import it.denzosoft.multiplatform.graphics.GraphicsFactory;

import java.io.IOException;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class TiledImage {
    // private Image[] tiles = null;
    private Image tileImage = null;
    private int frameNumber = 0;
    private int columns = 0;
    private int rows = 0;
    private int tileWidth;
    private int tileHeight;

/**
         * Creates a new instance of TiledImage
         */
    public TiledImage(String image, int tileWidth, int tileHeight)
        throws IOException {
        this(Image.createImage(image), tileWidth, tileHeight);

        // init(image);
    }

/**
     * Creates a new TiledImage object.
     *
     * @param image DOCUMENT ME!
     * @param tileWidth DOCUMENT ME!
     * @param tileHeight DOCUMENT ME!
     */
    public TiledImage(Image image, int tileWidth, int tileHeight) {
        this.tileHeight = tileHeight;
        this.tileWidth = tileWidth;
        tileImage = image;
        columns = (tileImage.getWidth() + (tileWidth / 2)) / tileWidth;
        rows = (tileImage.getHeight() + (tileHeight / 2)) / tileHeight;
        frameNumber = columns * rows;

        // init(image);
    }

    // private void init(String image) {
    // try {
    // System.gc();
    // // Logger.debug("TiledImage="+image);
    // int numTileX=(tileImage.getWidth() + tileWidth/2) / tileWidth;
    // int numTileY=(tileImage.getHeight() + tileHeight/2) / tileHeight;
    // int tileSize = numTileY * numTileX;
    // // Logger.debug("TiledImageSize="+tileSize+": "+numTileX+"x"+numTileY);
    // tiles = new Image[tileSize];
    //
    // for (int i=0;i<tileSize;i++) {
    // tiles[i] = getImage(tileImage,i % numTileX, i / numTileX , tileWidth ,
    // tileHeight, 0, 0);
    // // Logger.memory();
    // }
    // // tileImage = null;
    // System.gc();
    // // Logger.memory();
    // } catch (Throwable t) {
    // Logger.error(t);
    // }
    // }

    // /*--------------------------------------------------
    // * Open an http connection and download a png file
    // * into a byte array.
    // *-------------------------------------------------*/
    // private Image getImage(String url) throws IOException {
    // ContentConnection connection = (ContentConnection) Connector.open(url);
    // DataInputStream iStrm = connection.openDataInputStream();
    //
    // Image im = null;
    //
    // try {
    // // ContentConnection includes a length method
    // byte imageData[];
    // int length = (int) connection.getLength();
    // if (length != -1) {
    // imageData = new byte[length];
    //
    // // Read the png into an array
    // iStrm.readFully(imageData);
    // } else // Length not available...
    // {
    // ByteArrayOutputStream bStrm = new ByteArrayOutputStream();
    //
    // int ch;
    // while ((ch = iStrm.read()) != -1)
    // bStrm.write(ch);
    //
    // imageData = bStrm.toByteArray();
    // bStrm.close();
    // }
    //
    // // Create the image from the byte array
    // im = Image.createImage(imageData, 0, imageData.length);
    // } finally {
    // // Clean up
    // if (iStrm != null)
    // iStrm.close();
    // if (connection != null)
    // connection.close();
    // }
    // return (im == null ? null : im);
    // }
    private Image getImage(Image image, int tileX, int tileY, int width,
        int height, int offX, int offY) {
        Image image1 = Image.createImage(width, height);

        try {
            image1 = Image.createImage(width, height);
        } catch (Exception ex) {
            Logger.error(ex);
        }

        GraphicsFactory.getGraphics(image1.getGraphics())
                       .drawImage(image, -offX - (tileX * width),
            -offY - (tileY * height));

        // return Image.createImage(image1);
        return image1;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTileWidth() {
        return this.tileWidth;
    }

    /**
     * DOCUMENT ME!
     *
     * @param tileWidth DOCUMENT ME!
     */
    public void setTileWidth(int tileWidth) {
        this.tileWidth = tileWidth;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTileHeight() {
        return this.tileHeight;
    }

    /**
     * DOCUMENT ME!
     *
     * @param tileHeight DOCUMENT ME!
     */
    public void setTileHeight(int tileHeight) {
        this.tileHeight = tileHeight;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getFrameNumber() {
        return frameNumber;
    }

    /**
     * DOCUMENT ME!
     *
     * @param frame DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Image getFrameImage(int frame) {
        int columns = (tileImage.getWidth() + (tileWidth / 2)) / tileWidth;

        return getImage(tileImage, frame % columns, frame / columns, tileWidth,
            tileHeight, 0, 0);
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     * @param frame DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawImageWithClip(Graphics g, int frame, int x, int y) {
        int clipX = g.getClipX();
        int clipY = g.getClipY();
        int clipWidth = g.getClipWidth();
        int clipHeight = g.getClipHeight();

        drawImage(g, frame, x, y);

        // reset original clip:
        g.setClip(clipX, clipY, clipWidth, clipHeight);
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     * @param frame DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawImage(Graphics g, int frame, int x, int y) {
        // System.out.println("painting sprite col " + (frame / columns) + ",
        // row " + (frame % rows) + ", " + clipWidth );
        g.setClip(x, y, tileWidth, tileHeight);
        y -= ((frame / columns) * tileHeight);
        x -= ((frame % columns) * tileWidth);
        // Logger.debug(""+x+","+y+","+tileHeight);
        g.drawImage(tileImage, x, y, 20);
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getWidth() {
        return tileImage.getWidth();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getHeight() {
        return tileImage.getHeight();
    }
}
