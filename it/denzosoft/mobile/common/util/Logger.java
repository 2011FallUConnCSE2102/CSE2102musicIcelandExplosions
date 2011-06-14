/*
 * Logger.java
 *
 * Created on 20 ottobre 2006, 17.41
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.common.util;

import it.denzosoft.mobile.common.*;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Logger {
    private static String[] messageBuffer = new String[10];
    private static ObjectBuffer sMessage = null;
    private static ObjectBuffer sError = new ObjectBuffer(10);
    private static boolean used = false;
    private static boolean clean = true;

    /** Holds value of property debugging. */
    private static boolean ldebugging = true;

/** Creates a new instance of Logger */
    private Logger() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param message DOCUMENT ME!
     */
    public static void add(String message) {
        // System.out.println(message);
        if (clean) {
            sMessage = new ObjectBuffer(20);
        }

        sMessage.add(message);

        // sMessage.append(message+";");
        used = true;
        clean = false;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static String getMessage() {
        if (sMessage == null) {
            return "";
        } else {
            return sMessage.toString();
        }
    }

    /**
     * DOCUMENT ME!
     */
    public static void clean() {
        clean = true;
    }

    /**
     * Getter for property debugging.
     *
     * @return Value of property debugging.
     */
    public static boolean isDebugging() {
        return ldebugging;
    }

    /**
     * Setter for property debugging.
     *
     * @param debugging New value of property debugging.
     */
    public static void setDebugging(boolean debugging) {
        ldebugging = debugging;
    }

    /**
     * DOCUMENT ME!
     *
     * @param t DOCUMENT ME!
     */
    public static void error(Throwable t) {
        add("Error: " + t.getMessage());
        sError.add(t.getMessage());

        if (ldebugging) {
            t.printStackTrace();
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param display DOCUMENT ME!
     * @param duration DOCUMENT ME!
     */
    public static void showAlert(Display display, int duration) {
        String msg = getMessage() + sError.toString();
        Alert alert = new Alert("Logger", msg, null, null);
        alert.setTimeout(duration);
        display.setCurrent(alert, display.getCurrent());

        // clean();
    }

    /**
     * DOCUMENT ME!
     *
     * @param display DOCUMENT ME!
     * @param message DOCUMENT ME!
     * @param duration DOCUMENT ME!
     */
    public static void showMessage(Display display, String message, int duration) {
        Alert alert = new Alert("Logger", message, null, null);
        alert.setTimeout(duration);
        display.setCurrent(alert, display.getCurrent());
    }

    /**
     * DOCUMENT ME!
     *
     * @param message DOCUMENT ME!
     */
    public static void debug(String message) {
        if (!ldebugging) {
            return;
        }

        System.out.println(message);
    }

    /**
     * DOCUMENT ME!
     */
    public static void memory() {
        debug("Memory: used=" +
            (Runtime.getRuntime().totalMemory() -
            Runtime.getRuntime().freeMemory()) + " of total=" +
            Runtime.getRuntime().totalMemory());
    }
}
