/*
 * LayerManager.java
 *
 * Created on 19 ottobre 2006, 11.18
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import it.denzosoft.mobile.common.graphic.J2meGraphics;
import it.denzosoft.mobile.common.util.Logger;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class LayeredCanvas extends GameCanvas {
    /** DOCUMENT ME! */
    public static final int ZORDER_TOPMOST = 4;

    /** DOCUMENT ME! */
    public static final int ZORDER_TOP = 3;

    /** DOCUMENT ME! */
    public static final int ZORDER_NORMAL = 2;

    /** DOCUMENT ME! */
    public static final int ZORDER_BOTTOM = 1;

    /** DOCUMENT ME! */
    public static final int ZORDER_BOTTOMMOST = 0;
    private Vector[] layers = new Vector[5];
    private int layerNumber = 5;
    private Image imageBuffer = null;

    /** DOCUMENT ME! */
    Graphics workingGraphics = null;

    /** Holds value of property buffered. */
    private boolean buffered = true;

    /** Holds value of property backgroundColor. */
    private int backgroundColor = 0x00C0C0C0;

/** Creates a new instance of LayerManager */
    public LayeredCanvas(GameMIDlet midlet) {
        super(midlet);

        for (int i = 0; i < layerNumber; i++) {
            layers[i] = new Vector();
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param go DOCUMENT ME!
     * @param layer DOCUMENT ME!
     */
    public final void add(GraphicObject go, int layer) {
        layers[layer].addElement(go);
    }

    /**
     * DOCUMENT ME!
     *
     * @param go DOCUMENT ME!
     */
    public final void remove(GraphicObject go) {
        for (int i = 0; i < layerNumber; i++) {
            try {
                layers[i].removeElement(go);
            } catch (Exception ex) {
                Logger.error(ex);
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public final void paint(Graphics g) {
        // Logger.debug("Paint
        // Canvas..."+g.getClipWidth()+"x"+g.getClipHeight());
        try {
            Graphics output = g;

            // Logger.add("Painting layer...");
            // Image imageBuffer=null;;
            if (this.isBuffered()) {
                // System.gc();
                // Logger.add("Creating Image...");
                if (imageBuffer == null) {
                    imageBuffer = Image.createImage(g.getClipWidth(),
                            g.getClipHeight());
                }

                // workingGraphics = new
                // J2meGraphics(imageBuffer.getGraphics());
                // Logger.add("Image Created...");
                workingGraphics = imageBuffer.getGraphics();
            } else {
                workingGraphics = output;
            }

            // Logger.add("Clean image...");

            // it.denzosoft.multiplatform.graphics.Graphics outputNew = new
            // J2meGraphics(output);
            int tmpColor = g.getColor();
            workingGraphics.setColor(this.backgroundColor);
            workingGraphics.fillRect(0, 0, g.getClipWidth(), g.getClipHeight());
            workingGraphics.setColor(tmpColor);

            paintLayers(workingGraphics);
            workingGraphics.drawString(Logger.getMessage(), 10, 10, 20);
            Logger.clean();
            g.setColor(tmpColor);

            if (this.isBuffered()) {
                g.drawImage(imageBuffer, 0, 0, Graphics.TOP | Graphics.LEFT);
            }
        } catch (Exception exx) {
            Logger.error(exx);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    protected void paintLayers(Graphics g) {
        Enumeration elements = null;
        GraphicObject go = null;

        // Logger.debug("Layers="+layers.length);
        for (int i = 0; i < layerNumber; i++) {
            // Logger.debug("Layer="+i+" elements="+layers[i].size());
            elements = layers[i].elements();

            // Logger.debug("Layer"+i+"="+layers[i].size());
            while (elements.hasMoreElements()) {
                try {
                    go = (GraphicObject) elements.nextElement();
                    paintGraphicObject(g, go);
                } catch (Exception ex) {
                    Logger.error(ex);
                }
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     * @param go DOCUMENT ME!
     */
    protected void paintGraphicObject(Graphics g, GraphicObject go) {
        // Logger.debug("Painting Object...");
        if (!go.isVisible()) {
            return;
        }

        go.paint(g);
    }

    /**
     * Getter for property buffered.
     *
     * @return Value of property buffered.
     */
    public final boolean isBuffered() {
        return this.buffered;
    }

    /**
     * Setter for property buffered.
     *
     * @param buffered New value of property buffered.
     */
    public final void setBuffered(boolean buffered) {
        this.buffered = buffered;
    }

    /**
     * Getter for property backgroundColor.
     *
     * @return Value of property backgroundColor.
     */
    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    /**
     * Setter for property backgroundColor.
     *
     * @param backgroundColor New value of property backgroundColor.
     */
    public final void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
