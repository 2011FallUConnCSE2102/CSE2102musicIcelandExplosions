/*
 * GameEngine.java
 *
 * Created on 19 ottobre 2006, 11.16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.BasicCanvas;
import it.denzosoft.mobile.common.util.Logger;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public abstract class GameEngine extends TimerTask implements CommandListener {
    /** DOCUMENT ME! */
    public static final int UP_PRESSED = 0x0002;

    /** DOCUMENT ME! */
    public static final int DOWN_PRESSED = 0x0040;

    /** DOCUMENT ME! */
    public static final int LEFT_PRESSED = 0x0004;

    /** DOCUMENT ME! */
    public static final int RIGHT_PRESSED = 0x0020;

    /** DOCUMENT ME! */
    public static final int FIRE_PRESSED = 0x0100;
    private static Random random = new Random();
    private final static int GC_RATE = 10;

    // public static final int GAME_A_PRESSED = 0x0200;
    // public static final int GAME_B_PRESSED = 0x0400;
    // public static final int GAME_C_PRESSED = 0x0800;
    // public static final int GAME_D_PRESSED = 0x1000;
    private boolean running = false;
    private boolean paused = false;
    private Timer timer = null;
    private BasicCanvas canvas;
    private int gcActivateRateCounter = 0;
    private long previousTick = 0;

    /** Holds value of property intervalLoop. */
    private long intervalLoop = 50;
    private int keyStates;
    private int releasedKeys;

    /** Holds value of property screenWidth. */
    private int screenWidth;

    /** Holds value of property screenHeight. */
    private int screenHeight;

    /** Holds value of property points. */
    private int points;

    /** Holds value of property lives. */
    private int lives;

    /** Holds value of property cleanRate. */
    private int cleanRate = GC_RATE;

    /** Holds value of property runningTime. */
    private long runningTime;

    // private long lastRun = 0;
/** Creates a new instance of GameEngine */
    public GameEngine(BasicCanvas canvas) {
        this.canvas = canvas;
        setScreenWidth(canvas.getWidth());
        setScreenHeight(canvas.getHeight());
    }

    /**
     * DOCUMENT ME!
     */
    public final void startGame() {
        System.gc();
        runningTime = System.currentTimeMillis();
        running = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(this, 10, intervalLoop);

        // lastRun = System.currentTimeMillis();
        // timer.schedule(this,intervalLoop);
    }

    /**
     * DOCUMENT ME!
     */
    public final void stopGame() {
        running = false;
        timer.cancel();
        System.gc();
    }

    /**
     * DOCUMENT ME!
     */
    protected void clean() {
        System.gc();
    }

    /**
     * DOCUMENT ME!
     */
    public final void run() {
        // Logger.debug("CurrentTime: "+System.currentTimeMillis());
        long elapsed = System.currentTimeMillis() - previousTick;

        // if (elapsed<intervalLoop) {
        // try {
        // Thread.sleep(intervalLoop-elapsed);
        // } catch (Exception ex) {
        //                
        // }
        // }
        try {
            if (!paused) {
                gameTick();
                canvas.repaint();
                canvas.serviceRepaints();
            }

            gcActivateRateCounter++;

            if (gcActivateRateCounter > cleanRate) {
                clean();
                gcActivateRateCounter = 0;
            }

            if (!running) {
                stopGame();
            }
        } catch (Exception ex) {
            Logger.error(ex);

            // Logger.showAlert(this.canvas.getMIDlet().getDisplay(),1000);
        } finally {
            // if (running) {
            // timer.schedule(this,intervalLoop);
            // }
        }
    }

    /**
     * Getter for property intervalLoop.
     *
     * @return Value of property intervalLoop.
     */
    public final long getIntervalLoop() {
        return this.intervalLoop;
    }

    /**
     * Setter for property intervalLoop.
     *
     * @param intervalLoop New value of property intervalLoop.
     */
    public final void setIntervalLoop(long intervalLoop) {
        this.intervalLoop = intervalLoop;
    }

    /**
     * DOCUMENT ME!
     */
    public abstract void gameTick();

    /**
     * DOCUMENT ME!
     *
     * @param keyCode DOCUMENT ME!
     */
    protected void keyPressed(int keyCode) {
        int gameAction = canvas.getGameAction(keyCode);

        if (gameAction != 0) {
            int bit = 1 << gameAction;
            this.keyStates |= bit;
            this.releasedKeys &= ~bit;
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param keyCode DOCUMENT ME!
     */
    protected void keyReleased(int keyCode) {
        int gameAction = canvas.getGameAction(keyCode);

        if (gameAction != 0) {
            this.releasedKeys |= (1 << gameAction);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getKeyStates() {
        int states = this.keyStates;
        this.keyStates &= ~this.releasedKeys;
        this.releasedKeys = 0;

        return states;
    }

    /**
     * DOCUMENT ME!
     *
     * @param c DOCUMENT ME!
     * @param displayable DOCUMENT ME!
     */
    public abstract void commandAction(Command c, Displayable displayable);

    /**
     * DOCUMENT ME!
     */
    public final void pauseGame() {
        paused = true;
    }

    /**
     * DOCUMENT ME!
     */
    public final void restartGame() {
        paused = false;
    }

    /**
     * DOCUMENT ME!
     *
     * @param seed DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public static int getRandom(int seed) {
        return Math.abs(((random.nextInt() >>> 1) % seed));
    }

    /**
     * Getter for property screenWidth.
     *
     * @return Value of property screenWidth.
     */
    public int getScreenWidth() {
        return this.screenWidth;
    }

    /**
     * Setter for property screenWidth.
     *
     * @param screenWidth New value of property screenWidth.
     */
    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    /**
     * Getter for property screenHeight.
     *
     * @return Value of property screenHeight.
     */
    public int getScreenHeight() {
        return this.screenHeight;
    }

    /**
     * Setter for property screenHeight.
     *
     * @param screenHeight New value of property screenHeight.
     */
    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    /**
     * Getter for property points.
     *
     * @return Value of property points.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Setter for property points.
     *
     * @param points New value of property points.
     */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Getter for property lives.
     *
     * @return Value of property lives.
     */
    public int getLives() {
        return this.lives;
    }

    /**
     * Setter for property lives.
     *
     * @param lives New value of property lives.
     */
    public void setLives(int lives) {
        this.lives = lives;
    }

    /**
     * Getter for property cleanRate.
     *
     * @return Value of property cleanRate.
     */
    public int getCleanRate() {
        return this.cleanRate;
    }

    /**
     * Setter for property cleanRate.
     *
     * @param cleanRate New value of property cleanRate.
     */
    public void setCleanRate(int cleanRate) {
        this.cleanRate = cleanRate;
    }

    /**
     * Getter for property runningTime.
     *
     * @return Value of property runningTime.
     */
    public long getRunningTime() {
        return System.currentTimeMillis() - runningTime;
    }
}
