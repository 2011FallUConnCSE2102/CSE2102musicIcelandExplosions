/*
 * TextualGraphicObject.java
 *
 * Created on 14 novembre 2006, 17.21
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
public class TextualGraphicObject extends GraphicObject {
    /** Holds value of property text. */
    private String text = "";

    /** Holds value of property color. */
    private int color = 0xffffff;

/** Creates a new instance of TextualGraphicObject */
    public TextualGraphicObject() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param graphics DOCUMENT ME!
     */
    public void paint(Graphics graphics) {
        int tmp = graphics.getColor();
        graphics.setColor(color);

        if ((text != null) && !text.equals("")) {
            graphics.drawString(text, getX(), getY(), 20);
        }

        graphics.setColor(tmp);
    }

    /**
     * Getter for property text.
     *
     * @return Value of property text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Setter for property text.
     *
     * @param text New value of property text.
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter for property color.
     *
     * @return Value of property color.
     */
    public int getColor() {
        return this.color;
    }

    /**
     * Setter for property color.
     *
     * @param color New value of property color.
     */
    public void setColor(int color) {
        this.color = color;
    }
}
