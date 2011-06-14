/*
 * J2meGraphics.java
 *
 * Created on 26 ottobre 2006, 11.52
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.common.graphic;

import it.denzosoft.multiplatform.graphics.*;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class J2meGraphics implements Graphics {
    private javax.microedition.lcdui.Graphics graphics = null;

    /**
     * Creates a new J2meGraphics object.
     *
     * @param graphics DOCUMENT ME!
     */
    public J2meGraphics(javax.microedition.lcdui.Graphics graphics) {
        this.graphics = graphics;
    }

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    public void clipRect(int x, int y, int width, int height) {
        graphics.clipRect(x, y, width, height);
    }

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
    public void drawArc(int x, int y, int width, int height, int startAngle,
        int arcAngle) {
        graphics.drawArc(x, y, width, height, startAngle, arcAngle);
    }

    /**
     * DOCUMENT ME!
     *
     * @param character DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawChar(char character, int x, int y) {
        graphics.drawChar(character, x, y, 20);
    }

    /**
     * DOCUMENT ME!
     *
     * @param data DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param length DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawChars(char[] data, int offset, int length, int x, int y) {
        graphics.drawString(new String(data, offset, length), x, y, 20);
    }

    /**
     * DOCUMENT ME!
     *
     * @param img DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawImage(Image img, int x, int y) {
        graphics.drawImage(img, x, y, 20);
    }

    /**
     * DOCUMENT ME!
     *
     * @param x1 DOCUMENT ME!
     * @param y1 DOCUMENT ME!
     * @param x2 DOCUMENT ME!
     * @param y2 DOCUMENT ME!
     */
    public void drawLine(int x1, int y1, int x2, int y2) {
        graphics.drawLine(x1, y1, x2, y2);
    }

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    public void drawRect(int x, int y, int width, int height) {
        graphics.drawRect(x, y, width, height);
    }

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
    public void drawRoundRect(int x, int y, int width, int height,
        int arcWidth, int arcHeight) {
        graphics.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    /**
     * DOCUMENT ME!
     *
     * @param str DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawString(String str, int x, int y) {
        graphics.drawString(str, x, y, 20);
    }

    /**
     * DOCUMENT ME!
     *
     * @param str DOCUMENT ME!
     * @param offset DOCUMENT ME!
     * @param len DOCUMENT ME!
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void drawSubstring(String str, int offset, int len, int x, int y) {
        drawString(str.substring(offset, offset + len), x, y);
    }

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
    public void fillArc(int x, int y, int width, int height, int startAngle,
        int arcAngle) {
        graphics.fillArc(x, y, width, height, startAngle, arcAngle);
    }

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    public void fillRect(int x, int y, int width, int height) {
        graphics.fillRect(x, y, width, height);
    }

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
    public void fillRoundRect(int x, int y, int width, int height,
        int arcWidth, int arcHeight) {
        graphics.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getBlueComponent() {
        return graphics.getBlueComponent();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getClipHeight() {
        return graphics.getClipHeight();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getClipWidth() {
        return graphics.getClipWidth();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getClipX() {
        return graphics.getClipX();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getClipY() {
        return graphics.getClipY();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getColor() {
        return graphics.getColor();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Font getFont() {
        return graphics.getFont();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getGrayScale() {
        return graphics.getGrayScale();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getGreenComponent() {
        return graphics.getGreenComponent();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getRedComponent() {
        return graphics.getRedComponent();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getStrokeStyle() {
        return graphics.getStrokeStyle();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTranslateX() {
        return graphics.getTranslateX();
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int getTranslateY() {
        return graphics.getTranslateY();
    }

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     * @param width DOCUMENT ME!
     * @param height DOCUMENT ME!
     */
    public void setClip(int x, int y, int width, int height) {
        graphics.setClip(x, y, width, height);
    }

    /**
     * DOCUMENT ME!
     *
     * @param RGB DOCUMENT ME!
     */
    public void setColor(int RGB) {
        graphics.setColor(RGB);
    }

    /**
     * DOCUMENT ME!
     *
     * @param red DOCUMENT ME!
     * @param green DOCUMENT ME!
     * @param blue DOCUMENT ME!
     */
    public void setColor(int red, int green, int blue) {
        graphics.setColor(red, green, blue);
    }

    /**
     * DOCUMENT ME!
     *
     * @param font DOCUMENT ME!
     */
    public void setFont(Font font) {
        graphics.setFont(font);
    }

    /**
     * DOCUMENT ME!
     *
     * @param grey DOCUMENT ME!
     */
    public void setGrayScale(int grey) {
        graphics.setGrayScale(grey);
    }

    /**
     * DOCUMENT ME!
     *
     * @param style DOCUMENT ME!
     */
    public void setStrokeStyle(int style) {
        graphics.setStrokeStyle(style);
    }

    /**
     * DOCUMENT ME!
     *
     * @param x DOCUMENT ME!
     * @param y DOCUMENT ME!
     */
    public void translate(int x, int y) {
        graphics.translate(x, y);
    }
}
