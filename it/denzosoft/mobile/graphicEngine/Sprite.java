/*
 * Sprite.java
 *
 * Created on 19 ottobre 2006, 14.16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.Rectangle;


/**
 * 
 * @author De Sanctis
 */
public interface Sprite {
    /**
     * DOCUMENT ME!
     *
     * @param userInput DOCUMENT ME!
     */
    public void execute(int userInput);

    // public void collisionDetection (Sprite sprite);
    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getX();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getY();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getWidth();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getHeight();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Rectangle getCollisionArea();
}
