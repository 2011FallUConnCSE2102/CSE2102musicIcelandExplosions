/*
 * ScrollableGraphicObject.java
 *
 * Created on 25 ottobre 2006, 17.43
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class ScrollableGraphicObject extends GraphicObject {
    private Image image = null;
    private Image buffer = null;

    /** Holds value of property left. */
    private int left;

    /** Holds value of property top. */
    private int top;

/**
         * Creates a new instance of ScrollableGraphicObject
         */
    public ScrollableGraphicObject(Image image) {
        try {
            this.image = image;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Getter for property left.
     *
     * @return Value of property left.
     */
    public int getLeft() {
        return this.left;
    }

    /**
     * Setter for property left.
     *
     * @param left New value of property left.
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * Getter for property top.
     *
     * @return Value of property top.
     */
    public int getTop() {
        return this.top;
    }

    /**
     * Setter for property top.
     *
     * @param top New value of property top.
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        if (buffer == null) {
            buffer = Image.createImage(width, height);
        }

        buffer.getGraphics().drawImage(image, -width + left, -height + top, 20);
        buffer.getGraphics().drawImage(image, -width + left, top, 20);
        buffer.getGraphics().drawImage(image, left, -height + top, 20);
        buffer.getGraphics().drawImage(image, left, top, 20);
        g.drawImage(buffer, getX(), getY(), 20);
    }
}
