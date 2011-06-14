/*
 * BasicCanvas.java
 *
 * Created on 24 ottobre 2006, 14.12
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package it.denzosoft.mobile.common;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

/**
 * 
 * @author De Sanctis
 */
public class BasicCanvas extends Canvas implements CommandListener {

	public final Command exitCommand = new Command("Exit", Command.EXIT, 62);

	public final Command loggerCommand = new Command("Logger", Command.ITEM, 61);

	/** Creates a new instance of BasicCanvas */
	public BasicCanvas(BasicMIDlet midlet) {
		this.midlet = midlet;
		this.addCommand(exitCommand);
		// this.addCommand(loggerCommand);
		this.setCommandListener(this);
	}

	protected void paint(Graphics graphics) {
	}

	/**
	 * Holds value of property midlet.
	 */
	protected BasicMIDlet midlet;

	/**
	 * Getter for property midlet.
	 * 
	 * @return Value of property midlet.
	 */
	public BasicMIDlet getMIDlet() {
		return this.midlet;
	}

	public void commandAction(Command command, Displayable displayable) {
		// Logger.debug("Arriving command "+command.getLabel());
		if (command == exitCommand) {
			midlet.exitMIDlet();
			// } else if (command == loggerCommand) {
			// Logger.showAlert(this.midlet.getDisplay(),Alert.FOREVER);
		} else {
			// Logger.debug("Unknown command ");
		}
	}

}
