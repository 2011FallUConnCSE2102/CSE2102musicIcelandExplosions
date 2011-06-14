/*
 * TonePlayer.java
 *
 * Created on 15 novembre 2006, 17.35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.common.sound;

import it.denzosoft.mobile.common.util.Logger;

import it.denzosoft.multiplatform.sound.Note;
import it.denzosoft.multiplatform.sound.Player;
import it.denzosoft.multiplatform.sound.PlayerListener;

import java.util.Vector;

import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class TonePlayer implements Player, Runnable {
    private Vector sequence = new Vector(10);
    private int loop;
    private int volume = 100;

    /**
     * DOCUMENT ME!
     */
    protected boolean active = false;

    /**
     * DOCUMENT ME!
     */
    protected int status = Player.STATUS_CLOSED;
    private Vector listeners = new Vector();
    private boolean paused = false;
    private boolean playing = false;

/** Creates a new instance of TonePlayer */
    public TonePlayer() {
        active = false;
    }

    /**
     * DOCUMENT ME!
     *
     * @param loopTimes DOCUMENT ME!
     */
    public final void setLoop(int loopTimes) {
        this.loop = loopTimes;
    }

    /**
     * DOCUMENT ME!
     *
     * @param volume DOCUMENT ME!
     */
    public final void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final int getVolume() {
        return volume;
    }

    /**
     * DOCUMENT ME!
     *
     * @param notes DOCUMENT ME!
     */
    public final void add(Note[] notes) {
        sequence.addElement(notes);
    }

    /**
     * DOCUMENT ME!
     *
     * @param listener DOCUMENT ME!
     */
    public final void addListener(PlayerListener listener) {
        listeners.addElement(listener);
    }

    /**
     * DOCUMENT ME!
     *
     * @param sequence DOCUMENT ME!
     */
    public final void setSequence(Vector sequence) {
        this.sequence = sequence;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final Vector getSequence() {
        return sequence;
    }

    /**
     * DOCUMENT ME!
     */
    public void close() {
        active = false;
        status = Player.STATUS_CLOSED;
    }

    /**
     * DOCUMENT ME!
     */
    public final void pause() {
        paused = true;
        status = Player.STATUS_PAUSED;
    }

    /**
     * DOCUMENT ME!
     */
    public final void play() {
        if (active) {
            status = Player.STATUS_PLAYING;
            playing = true;
            paused = false;

            Thread th = new Thread(this);
            th.start();
        }
    }

    /**
     * DOCUMENT ME!
     */
    public final void stop() {
        playing = false;
    }

    /**
     * DOCUMENT ME!
     */
    public final void run() {
        for (int o = 0; o < sequence.size(); o++) {
            if (playing == false) {
                break;
            }

            while (paused) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                if (playing == false) {
                    break;
                }
            }

            Note[] chord = (Note[]) sequence.elementAt(o);
            playChord(chord);

            for (int i = 0; i < listeners.size(); i++) {
                ((PlayerListener) listeners.elementAt(i)).update(chord, 0);
            }
        }

        status = Player.STATUS_READY;
    }

    /**
     * DOCUMENT ME!
     */
    public final void restart() {
        paused = false;
        status = Player.STATUS_PLAYING;
    }

    /**
     * DOCUMENT ME!
     *
     * @param note DOCUMENT ME!
     */
    public void playNote(Note note) {
        try {
            status = Player.STATUS_PLAYING;
            Manager.playTone(note.getPitch(),
                durationMillis(note.getDuration()), (127 * volume) / 100);
            Thread.sleep(durationMillis(note.getDuration()));
            status = Player.STATUS_READY;
        } catch (InterruptedException ex) {
        } catch (MediaException ex) {
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param chord DOCUMENT ME!
     */
    public void playChord(Note[] chord) {
        try {
            status = Player.STATUS_PLAYING;

            for (int i = 0; i < chord.length; i++) {
                Manager.playTone(chord[i].getPitch(),
                    durationMillis(chord[i].getDuration()), (127 * volume) / 100);
            }

            Thread.sleep(durationMillis(chord[0].getDuration()));
            status = Player.STATUS_READY;
        } catch (MediaException ex) {
        } catch (InterruptedException ex) {
        }
    }

    /**
     * DOCUMENT ME!
     */
    public void open() {
        active = true;
    }

    /**
     * DOCUMENT ME!
     *
     * @param duration DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final int durationMillis(int duration) {
        return (duration * 2000) / 96;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public final int getStatus() {
        return status;
    }

    /**
     * DOCUMENT ME!
     */
    public void waitForEnd() {
        while ((status == Player.STATUS_PLAYING) ||
                (status == Player.STATUS_PAUSED)) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}
