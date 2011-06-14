/*
 * MidiPlayer.java
 *
 * Created on 17 novembre 2006, 10.37
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.common.sound;

import it.denzosoft.mobile.common.util.Logger;

import it.denzosoft.multiplatform.sound.Note;

import java.util.Vector;

import javax.microedition.media.Manager;
import javax.microedition.media.control.MIDIControl;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class MidiPlayer extends TonePlayer {
    /**
     * DOCUMENT ME!
     */
    public static final int DRUM_CHANNEL = 9;
    private javax.microedition.media.Player player = null;
    private MIDIControl midiControl;

    /** Holds value of property defaultChannel. */
    private int defaultChannel = 0;

/** Creates a new instance of MidiPlayer */
    public MidiPlayer() {
        super();
    }

    /**
     * DOCUMENT ME!
     *
     * @param chord DOCUMENT ME!
     */
    public void playChord(Note[] chord) {
        try {
            int size = chord.length;

            for (int i = 0; i < size; i++) {
                noteOn(defaultChannel, chord[i].getPitch(),
                    (127 * getVolume()) / 100);
            }

            Thread.sleep(durationMillis(chord[0].getDuration()));

            for (int i = 0; i < size; i++) {
                this.noteOff(defaultChannel, chord[i].getPitch());
            }
        } catch (Exception ex) {
            Logger.error(ex);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param note DOCUMENT ME!
     */
    public void playNote(Note note) {
        try {
            this.noteOn(defaultChannel, note.getPitch(),
                (127 * getVolume()) / 100);
            Thread.sleep(durationMillis(note.getDuration()));
            this.noteOff(defaultChannel, note.getPitch());
        } catch (Exception ex) {
            Logger.error(ex);
        }
    }

    /**
     * DOCUMENT ME!
     */
    public void close() {
        active = false;
        player.close();
    }

    /**
     * DOCUMENT ME!
     */
    public void open() {
        active = true;

        try {
            // Create a sound player with the MIDI device locator
            player = Manager.createPlayer(Manager.TONE_DEVICE_LOCATOR);/*TODO was midi device locator tms*/
            player.realize();
            player.prefetch();
            player.start();
            // Get the midi control
            midiControl = (MIDIControl) player.getControl("MIDIControl");

            // If no midi control is pressent
            if (midiControl == null) {
                throw new RuntimeException(
                    "MIDI don't supported by this device");
            }
        } catch (Exception e) {
            Logger.error(e);
            active = false;
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Play the note specified in the channel specified.
     *
     * @param channel midi channel
     * @param pitch pitch of a note
     * @param velocity velocity of a note
     */
    public void noteOn(int channel, int pitch, int velocity) {
        midiControl.shortMidiEvent(MIDIControl.NOTE_ON | channel, pitch,
            velocity);
    }

    /**
     * Stop playing the note specified in the channel specified
     *
     * @param channel midi channel
     * @param pitch pitch of a note
     */
    public void noteOff(int channel, int pitch) {
        midiControl.shortMidiEvent(MIDIControl.NOTE_ON | channel, pitch, 0);
    }

    /**
     * Change the program of a channel.
     *
     * @param channel midi channel
     * @param program the midi program
     */
    public void programChange(int channel, int program) {
        midiControl.setProgram(channel, -1, program);
    }

    /**
     * Change the volume for the given channel, To mute, set to 0.
     *
     * @param channel midi channel
     * @param volumen volumen
     */
    public void channelVolume(int channel, int volumen) {
        midiControl.setChannelVolume(channel, volumen);
    }

    /**
     * Getter for property defaultChannel.
     *
     * @return Value of property defaultChannel.
     */
    public int getDefaultChannel() {
        return this.defaultChannel;
    }

    /**
     * Setter for property defaultChannel.
     *
     * @param defaultChannel New value of property defaultChannel.
     */
    public void setDefaultChannel(int defaultChannel) {
        this.defaultChannel = defaultChannel;
    }
}
