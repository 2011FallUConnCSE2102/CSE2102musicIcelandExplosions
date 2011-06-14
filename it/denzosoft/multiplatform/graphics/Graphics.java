/*
 * Graphics.java
 *
 * Created on 26 ottobre 2006, 11.58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.multiplatform.graphics;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;


/**
 * 
 * @author De Sanctis
 */
public interface Graphics {
    /**
     * DOCUMENT ME!
     */
    int BASELINE = 64;

    /**
     * DOCUMENT ME!
     */
    int BOTTOM = 32;

    /**
     * DOCUMENT ME!
     */
    int DOTTED = 1;

    /**
     * DOCUMENT ME!
     */
    int HCENTER = 1;

    /**
     * DOCUMENT ME!
     */
    int LEFT = 4;

    /**
     * DOCUMENT ME!
     */
    int RIGHT = 8;

    /**
     * DOCUMENT ME!
     */
    int SOLID = 0;

    /**
     * DOCUMENT ME!
     */
    int TOP = 16;

    /**
     * DOCUMENT ME!
     */
    int VCENTER = 2;

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    void clipRect(int x, int y, int width, int height);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     * @param startAngle DOCUMENT ME!
     * @param arcAngle DOCUMENT ME!
     */
    void drawArc(int x, int y, int width, int height, int startAngle,
        int arcAngle);

    /**
     * DOCUMENT ME!
     *
     * @param character DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    void drawChar(char character, int x, int y);

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param length DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    void drawChars(char[] data, int offset, int length, int x, int y);

    /**
     * DOCUMENT ME!
     *
     * @param img DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    void drawImage(Image img, int x, int y);

    /**
     * DOCUMENT ME!
     *
     * @param x1 DOCUMENT ME!
     * @param y1 DOCUMENT ME!
     * @param x2 DOCUMENT ME!
     * @param y2 DOCUMENT ME!
     */
    void drawLine(int x1, int y1, int x2, int y2);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    void drawRect(int x, int y, int width, int height);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     * @param arcWidth DOCUMENT ME!
     * @param arcHeight DOCUMENT ME!
     */
    void drawRoundRect(int x, int y, int width, int height, int arcWidth,
        int arcHeight);

    /**
     * DOCUMENT ME!
     *
     * @param str DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    void drawString(String str, int x, int y);

    /**
     * DOCUMENT ME!
     *
     * @param str DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param len DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    void drawSubstring(String str, int offset, int len, int x, int y);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     * @param startAngle DOCUMENT ME!
     * @param arcAngle DOCUMENT ME!
     */
    void fillArc(int x, int y, int width, int height, int startAngle,
        int arcAngle);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    void fillRect(int x, int y, int width, int height);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     * @param arcWidth DOCUMENT ME!
     * @param arcHeight DOCUMENT ME!
     */
    void fillRoundRect(int x, int y, int width, int height, int arcWidth,
        int arcHeight);

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getBlueComponent();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getClipHeight();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getClipWidth();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getClipX();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getClipY();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getColor();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    Font getFont();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getGrayScale();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getGreenComponent();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getRedComponent();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getStrokeStyle();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getTranslateX();

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    int getTranslateY();

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    void setClip(int x, int y, int width, int height);

    /**
     * DOCUMENT ME!
     *
     * @param RGB DOCUMENT ME!
     */
    void setColor(int RGB);

    /**
     * DOCUMENT ME!
     *
     * @param red DOCUMENT ME!
     * @param green DOCUMENT ME!
     * @param blue DOCUMENT ME!
     */
    void setColor(int red, int green, int blue);

    /**
     * DOCUMENT ME!
     *
     * @param font DOCUMENT ME!
     */
    void setFont(Font font);

    /**
     * DOCUMENT ME!
     *
     * @param grey DOCUMENT ME!
     */
    void setGrayScale(int grey);

    /**
     * DOCUMENT ME!
     *
     * @param style DOCUMENT ME!
     */
    void setStrokeStyle(int style);

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    void translate(int x, int y);
}
