/*
 * Player.java
 *
 * Created on 17 novembre 2006, 10.05
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.multiplatform.sound;

import it.denzosoft.mobile.common.sound.*;

import java.util.Vector;


/**
 * 
 * @author De Sanctis
 */
public interface Player {
    /**
     * DOCUMENT ME!
     */
    public static final int LOOP_FOREVER = -1;

    /**
     * DOCUMENT ME!
     */
    public static final int NO_LOOP = 0;

    /**
     * DOCUMENT ME!
     */
    public static final int STATUS_READY = 1;

    /**
     * DOCUMENT ME!
     */
    public static final int STATUS_PLAYING = 2;

    /**
     * DOCUMENT ME!
     */
    public static final int STATUS_PAUSED = 3;

    /**
     * DOCUMENT ME!
     */
    public static final int STATUS_CLOSED = 4;

    /**
     * DOCUMENT ME!
     */
    public void open();

    /**
     * DOCUMENT ME!
     */
    public void close();

    /**
     * DOCUMENT ME!
     *
     * @param notes DOCUMENT ME!
     */
    public void add(Note[] notes);

    /**
     * DOCUMENT ME!
     *
     * @param loopTimes DOCUMENT ME!
     */
    public void setLoop(int loopTimes);

    /**
     * DOCUMENT ME!
     */
    public void play();

    /**
     * DOCUMENT ME!
     */
    public void pause();

    /**
     * DOCUMENT ME!
     */
    public void restart();

    /**
     * DOCUMENT ME!
     */
    public void stop();

    /**
     * DOCUMENT ME!
     *
     * @param volume DOCUMENT ME!
     */
    public void setVolume(int volume);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getVolume();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Vector getSequence();

    /**
     * DOCUMENT ME!
     *
     * @param sequence DOCUMENT ME!
     */
    public void setSequence(Vector sequence);

    /**
     * DOCUMENT ME!
     *
     * @param note DOCUMENT ME!
     */
    public void playNote(Note note);

    /**
     * DOCUMENT ME!
     *
     * @param chord DOCUMENT ME!
     */
    public void playChord(Note[] chord);

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public void addListener(PlayerListener listener);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getStatus();

    /**
     * DOCUMENT ME!
     */
    public void waitForEnd();
}
