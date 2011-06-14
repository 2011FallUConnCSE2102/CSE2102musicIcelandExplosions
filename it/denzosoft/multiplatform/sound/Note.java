/*
 * Note.java
 *
 * Created on 17 novembre 2006, 10.24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.multiplatform.sound;

/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Note {
    /**
     * DOCUMENT ME!
     */
    public static final int REST_PITCH = -1;

    /**
     * DOCUMENT ME!
     */
    public static final int C4_PITCH = 60;

    /**
     * DOCUMENT ME!
     */
    public static final int WHOLE_NOTE_DURATION = 96;

    /** Holds value of property pitch. */
    private int pitch = C4_PITCH;

    /** Holds value of property note. */
    private int note;

    /** Holds value of property duration. */
    private int duration;

/** Creates a new instance of Note */
    public Note() {
    }

    /**
     * Creates a new Note object.
     *
     * @param pitch DOCUMENT ME!
     * @param duration DOCUMENT ME!
     */
    public Note(int pitch, int duration) {
        this.pitch = pitch;
        this.duration = duration;
    }

    /**
     * Getter for property pitch.
     *
     * @return Value of property pitch.
     */
    public int getPitch() {
        return this.pitch;
    }

    /**
     * Setter for property pitch.
     *
     * @param pitch New value of property pitch.
     */
    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    /**
     * Getter for property note.
     *
     * @return Value of property note.
     */
    public int getNote() {
        return this.pitch % 12;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getOctave() {
        return this.pitch / 12;
    }

    /**
     * Getter for property duration.
     *
     * @return Value of property duration.
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * Setter for property duration.
     *
     * @param duration New value of property duration.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
