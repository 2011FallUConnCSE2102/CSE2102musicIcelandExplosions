/*
 * PlayerListener.java
 *
 * Created on 17 novembre 2006, 10.23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.multiplatform.sound;

/**
 * 
 * @author De Sanctis
 */
public interface PlayerListener {
    /**
     * DOCUMENT ME!
     *
     * @param notes DOCUMENT ME!
     * @param timer DOCUMENT ME!
     */
    public void update(Note[] notes, int timer);
}
