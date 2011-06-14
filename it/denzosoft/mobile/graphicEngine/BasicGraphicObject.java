/*
 * BasicGraphicObject.java
 *
 * Created on 26 ottobre 2006, 18.01
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
public class BasicGraphicObject extends GraphicObject {
    /** Holds value of property image. */
    private Image image;

/** Creates a new instance of BasicGraphicObject */
    public BasicGraphicObject() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public void paint(Graphics g) {
        g.drawImage(image, getX(), getY(), 20);
    }

    /**
     * Getter for property image.
     *
     * @return Value of property image.
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Setter for property image.
     *
     * @param image New value of property image.
     */
    public void setImage(Image image) {
        this.image = image;
        this.setWidth(image.getWidth());
        this.setHeight(image.getHeight());
    }

    /**
     * DOCUMENT ME!
     *
     * @param imageName DOCUMENT ME!
     *
     * @throws Exception DOCUMENT ME!
     */
    public void setImage(String imageName) throws Exception {
        this.image = Image.createImage(imageName);
    }
}
