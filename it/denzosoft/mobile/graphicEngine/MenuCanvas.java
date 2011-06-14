/*
 * MenuCanvas.java
 *
 * Created on 14 novembre 2006, 14.29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.BasicCanvas;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class MenuCanvas extends BasicCanvas {
    /** Holds value of property logo. */
    private Image logo = null;

    /** Holds value of property text. */
    private String text = "";

    /** Holds value of property name. */
    private String name = "";

    /** Holds value of property devLogo. */
    private Image devLogo;

    /** Holds value of property forecolor. */
    private int forecolor = 0x00ff00;

/** Creates a new instance of MenuCanvas */
    public MenuCanvas(GameMIDlet midlet) {
        super(midlet);

        // try {
        // logo=Image.createImage("/denzosoft.png");
        // } catch (Exception ex) {
        // logo = Image.createImage(1,1);
        // }
    }

    /**
     * DOCUMENT ME!
     *
     * @param graphics DOCUMENT ME!
     */
    protected void paint(Graphics graphics) {
        graphics.setColor(0, 0, 0);
        graphics.fillRect(0, 0, graphics.getClipWidth(),
            graphics.getClipHeight());
        graphics.setColor(forecolor);

        graphics.drawString(name, graphics.getClipWidth() / 2, 20,
            Graphics.BASELINE | Graphics.HCENTER);

        if (logo != null) {
            graphics.drawImage(logo,
                (graphics.getClipWidth() - logo.getWidth()) / 2, 35, 20);
        }

        if (devLogo != null) {
            graphics.drawImage(devLogo,
                (graphics.getClipWidth() - devLogo.getWidth()) / 2, 140, 20);
        }

        graphics.drawString("Press any key to start!",
            graphics.getClipWidth() / 2, 112,
            Graphics.BASELINE | Graphics.HCENTER);

        graphics.drawString(text, graphics.getClipWidth() / 2, 126,
            Graphics.BASELINE | Graphics.HCENTER);
    }

    /**
     * DOCUMENT ME!
     *
     * @param keyCode DOCUMENT ME!
     */
    protected void keyPressed(int keyCode) {
        text = "Loadind game...";
        this.repaint();
        this.serviceRepaints();
        logo = null;
        devLogo = null;
        System.gc();
        ((GameMIDlet) midlet).startGame();
    }

    /**
     * Setter for property logo.
     *
     * @param logoImg New value of property logo.
     */
    public void setLogo(String logoImg) {
        try {
            this.logo = Image.createImage(logoImg);
        } catch (Exception ex) {
        }
    }

    /**
     * Setter for property name.
     *
     * @param name New value of property name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for property devLogo.
     *
     * @param devLogoImg New value of property devLogo.
     */
    public void setDevLogo(String devLogoImg) {
        try {
            this.devLogo = Image.createImage(devLogoImg);
        } catch (Exception ex) {
        }
    }

    /**
     * Setter for property forecolor.
     *
     * @param forecolor New value of property forecolor.
     */
    public void setForecolor(int forecolor) {
        this.forecolor = forecolor;
    }
}
