/*
 * PlayerForm.java
 *
 * Created on 8 novembre 2006, 17.06
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.player;

import it.denzosoft.mobile.common.BasicMIDlet;
import it.denzosoft.mobile.common.sound.TonePlayer;
import it.denzosoft.mobile.common.util.Logger;

import it.denzosoft.multiplatform.sound.Note;
import it.denzosoft.multiplatform.sound.Player;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.StringItem;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class PlayerForm implements CommandListener {
    private Form form = null;
    private Command exitCommand = new Command("Exit", Command.EXIT, 60);
    private Command playTone = new Command("PlayTone", Command.ITEM, 58);
    private Command playChord = new Command("PlayChord", Command.ITEM, 59);
    private BasicMIDlet midlet = null;

/** Creates a new instance of PlayerForm */
    public PlayerForm(BasicMIDlet midlet) {
        this.midlet = midlet;
        form = new Form("Player", new Item[] { new StringItem("Player", "") });
        form.addCommand(playTone);
        form.addCommand(playChord);
        form.addCommand(exitCommand);
        form.setCommandListener(this);
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Form getForm() {
        return form;
    }

    /**
     * DOCUMENT ME!
     *
     * @param command DOCUMENT ME!
     * @param displayable DOCUMENT ME!
     */
    public void commandAction(Command command, Displayable displayable) {
        Logger.debug(command.getLabel());

        if (command == playTone) {
            // SoundPlayer.simpleTone();
            Player player = new TonePlayer();
            player.add(new Note[] {
                    new Note(Note.C4_PITCH, Note.WHOLE_NOTE_DURATION)
                });
            player.open();
            player.play();
            player.waitForEnd();
            player.close();
        } else if (command == playChord) {
            // SoundPlayer.simpleChordTone();
            Player player = new TonePlayer();
            player.add(new Note[] {
                    new Note(Note.C4_PITCH, Note.WHOLE_NOTE_DURATION),
                    new Note(Note.C4_PITCH + 4, Note.WHOLE_NOTE_DURATION),
                    new Note(Note.C4_PITCH + 7, Note.WHOLE_NOTE_DURATION)
                });
            player.open();
            player.play();
            player.waitForEnd();
            player.close();
        } else if (command == exitCommand) {
            midlet.exitMIDlet();
        }
    }
}
