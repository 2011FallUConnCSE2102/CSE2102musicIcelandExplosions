/*
 * BasicMidlet.java
 *
 * Created on 24 ottobre 2006, 14.01
 */

package it.denzosoft.mobile.common;

import it.denzosoft.mobile.common.util.Logger;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * 
 * @author De Sanctis
 * @version
 */
public abstract class BasicMIDlet extends MIDlet implements Runnable,
		CommandListener {

	public final Command exitCommand = new Command("Exit", Command.EXIT, 60);

	private Display display;

	/** Creates a new instance of GameMIDlet */
	public BasicMIDlet() {
		display = Display.getDisplay(this);
	}

	public final void startApp() {
		Logger.memory();
		(new Thread(this)).start();
	}

	public abstract void run();

	public void pauseApp() {
	}

	public void destroyApp(boolean unconditional) {
		display.setCurrent(null);
	}

	public void exitMIDlet() {
		System.gc();
		destroyApp(true);
		notifyDestroyed();
	}

	public Display getDisplay() {
		return display;
	}

	public void commandAction(Command c, Displayable displayable) {
		// Logger.debug("Arriving command "+c.getLabel());
		if (c == exitCommand) {
			exitMIDlet();
		} else {
			// Logger.debug("Unknown command ");
		}
	}

}
