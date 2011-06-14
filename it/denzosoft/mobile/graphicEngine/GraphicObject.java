/*
 * GraphicObject.java
 *
 * Created on 19 ottobre 2006, 11.28
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import javax.microedition.lcdui.Graphics;


// import it.denzosoft.multiplatform.graphics.Graphics;
/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public abstract class GraphicObject {
    /** Holds value of property width. */
    private int width;

    /** Holds value of property height. */
    private int height;

    /** Holds value of property visible. */
    private boolean visible;

    /** Holds value of property x. */
    private int x;

    /** Holds value of property y. */
    private int y;

/** Creates a new instance of GraphicObject */
    public GraphicObject() {
    }

    /**
     * Getter for property width.
     *
     * @return Value of property width.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Setter for property width.
     *
     * @param width New value of property width.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Getter for property height.
     *
     * @return Value of property height.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Setter for property height.
     *
     * @param height New value of property height.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * DOCUMENT ME!
     *
     * @param graphics DOCUMENT ME!
     */
    public abstract void paint(Graphics graphics);

    /**
     * Getter for property visible.
     *
     * @return Value of property visible.
     */
    public boolean isVisible() {
        return this.visible;
    }

    /**
     * Setter for property visible.
     *
     * @param visible New value of property visible.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Getter for property x.
     *
     * @return Value of property x.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Setter for property x.
     *
     * @param x New value of property x.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter for property y.
     *
     * @return Value of property y.
     */
    public int getY() {
        return this.y;
    }

    /**
     * Setter for property y.
     *
     * @param y New value of property y.
     */
    public void setY(int y) {
        this.y = y;
    }
}
