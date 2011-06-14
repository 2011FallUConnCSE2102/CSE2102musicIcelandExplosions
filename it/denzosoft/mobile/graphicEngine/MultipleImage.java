/*
 * MultipleImage.java
 *
 * Created on 26 ottobre 2006, 18.58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import java.io.IOException;

import javax.microedition.lcdui.Image;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class MultipleImage {
    private int size;
    private Image[] images;

/** Creates a new instance of MultipleImage */
    public MultipleImage(String name, int size) throws IOException {
        System.gc();
        this.size = size;
        images = new Image[size];

        for (int i = 0; i < size; i++) {
            images[i] = Image.createImage("/" + name + i + ".png");
        }

        System.gc();
    }

    /**
     * DOCUMENT ME!
     *
     * @param index DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Image getImage(int index) {
        return images[index];
    }
}
