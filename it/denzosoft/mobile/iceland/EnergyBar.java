/*
 * EnergyBar.java
 *
 * Created on 14 novembre 2006, 17.47
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.graphicEngine.GraphicObject;

import javax.microedition.lcdui.Graphics;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class EnergyBar extends GraphicObject {
    /** Holds value of property energy. */
    private int energy = 50;

    /** Holds value of property warning. */
    private int warning = 25;

    /** Holds value of property danger. */
    private int danger = 10;

    /** Holds value of property full. */
    private int full = 100;

/** Creates a new instance of EnergyBar */
    public EnergyBar() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param graphics DOCUMENT ME!
     */
    public void paint(Graphics graphics) {
        int width = getWidth();
        int currentLevel = (width * energy) / full;
        int dangerLevel = (width * danger) / full;
        int warningLevel = (width * warning) / full;
        int fullLevel = width;
        int color = graphics.getColor();
        graphics.setColor(0xff0000);

        if (energy > danger) {
            graphics.fillRect(getX(), getY(), dangerLevel, getHeight());
        } else {
            graphics.fillRect(getX(), getY(), currentLevel, getHeight());

            return;
        }

        graphics.setColor(0xffff00);

        if (energy > warning) {
            graphics.fillRect(getX() + dangerLevel, getY(),
                warningLevel - dangerLevel, getHeight());
        } else {
            graphics.fillRect(getX() + dangerLevel, getY(),
                currentLevel - dangerLevel, getHeight());

            return;
        }

        graphics.setColor(0x00FF00);

        if (energy > warning) {
            graphics.fillRect(getX() + warningLevel, getY(),
                currentLevel - warningLevel, getHeight());
        }
    }

    /**
     * Setter for property energy.
     *
     * @param energy New value of property energy.
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * Getter for property warning.
     *
     * @return Value of property warning.
     */
    public int getWarning() {
        return this.warning;
    }

    /**
     * Setter for property warning.
     *
     * @param warning New value of property warning.
     */
    public void setWarning(int warning) {
        this.warning = warning;
    }

    /**
     * Getter for property danger.
     *
     * @return Value of property danger.
     */
    public int getDanger() {
        return this.danger;
    }

    /**
     * Setter for property danger.
     *
     * @param danger New value of property danger.
     */
    public void setDanger(int danger) {
        this.danger = danger;
    }

    /**
     * Getter for property full.
     *
     * @return Value of property full.
     */
    public int getFull() {
        return this.full;
    }

    /**
     * Setter for property full.
     *
     * @param full New value of property full.
     */
    public void setFull(int full) {
        this.full = full;
    }
}
