/*
 * MapGraphicObject.java
 *
 * Created on 26 ottobre 2006, 11.36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.graphicEngine;

import javax.microedition.lcdui.Graphics;


/**
 * DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class MapGraphicObject extends GraphicObject {
    private byte[][] map = null;
    private TiledImage tiledImage = null;

    /** Holds value of property loopX. */
    private boolean loopX;

    /** Holds value of property loopY. */
    private boolean loopY;

/**
         * Creates a new instance of MapGraphicObject
         */
    public MapGraphicObject() {
    }

    /**
     * DOCUMENT ME!
     *
     * @param g DOCUMENT ME!
     */
    public void paint(Graphics g) {
        if (map != null) {
            int tileWidth = tiledImage.getTileWidth();
            int tileHeight = tiledImage.getTileHeight();
            int clipX = g.getClipX();
            int clipY = g.getClipY();
            int clipWidth = g.getClipWidth();
            int clipHeight = g.getClipHeight();
            int x = getX();
            int y = getY();
            int mapItemX = 0;
            int mapItemY = 0;

            // Logger.debug("x="+x+";y="+y+";clipX="+clipX+";clipY="+clipY);
            int maxX = map.length;
            int maxY = map[0].length;

            // Logger.debug("Printing mapItemY="+(0+(clipY+y)/tileHeight));
            int startX = (clipX + x) / tileWidth;
            int startY = (clipY + y) / tileHeight;
            int endLoopXX = (clipWidth / tileWidth) + 3;
            int endLoopYY = ((clipHeight) / tileHeight) + 3;

            for (int xx = 0; xx < endLoopXX; xx++) {
                for (int yy = 0; yy < endLoopYY; yy++) {
                    // Logger.debug("xx="+xx+";yy="+yy);
                    mapItemX = xx + startX;

                    if (loopX) {
                        if (mapItemX < 0) {
                            while (mapItemX < 0) {
                                mapItemX = mapItemX + maxX;
                            }
                        }

                        if (mapItemX >= maxX) {
                            while (mapItemX >= maxX) {
                                mapItemX = mapItemX - maxX;
                            }
                        }
                    }

                    mapItemY = yy + startY;

                    if (loopY) {
                        if (mapItemY < 0) {
                            while (mapItemY < 0) {
                                mapItemY = (mapItemY + maxY);
                            }
                        }

                        if (mapItemY >= maxY) {
                            // while (mapItemY>=maxY) {
                            mapItemY = (mapItemY % maxY);

                            // }
                        }
                    }

                    // Logger.debug("mapItemX="+mapItemX+",mapItemY="+mapItemY);
                    if ((mapItemX > -1) && (mapItemY > -1) &&
                            (mapItemX < maxX) && (mapItemY < maxY)) {
                        // Logger.debug("yy+(clipY+y)/tileHeight="+(yy+(clipY+y)/tileHeight));
                        // Logger.debug("map[mapItemX][mapItemY]="+map[mapItemX][mapItemY]);
                        // Logger.debug("-x + xx * tileWidth="+(-x + xx *
                        // tileWidth)+";-y + yy * tileHeight="+(-y + yy *
                        // tileHeight));
                        // g.drawImage(tiledImage.getFrameImage(map[mapItemX][mapItemY]),
                        // -x + (xx+startX) * tileWidth,-y + (yy+startY) *
                        // tileHeight);
                        tiledImage.drawImage(g, map[mapItemX][mapItemY],
                            -x + ((xx + startX) * tileWidth),
                            -y + ((yy + startY) * tileHeight));
                    }
                }
            }

            g.setClip(clipX, clipY, clipWidth, clipHeight);
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public byte[][] getMap() {
        return this.map;
    }

    /**
     * DOCUMENT ME!
     *
     * @param map DOCUMENT ME!
     */
    public void setMap(byte[][] map) {
        this.map = map;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public TiledImage getImage() {
        return this.tiledImage;
    }

    /**
     * DOCUMENT ME!
     *
     * @param tiledImage DOCUMENT ME!
     */
    public void setImage(TiledImage tiledImage) {
        this.tiledImage = tiledImage;
    }

    /**
     * Getter for property loopX.
     *
     * @return Value of property loopX.
     */
    public boolean isLoopX() {
        return this.loopX;
    }

    /**
     * Setter for property loopX.
     *
     * @param loopX New value of property loopX.
     */
    public void setLoopX(boolean loopX) {
        this.loopX = loopX;
    }

    /**
     * Getter for property loopY.
     *
     * @return Value of property loopY.
     */
    public boolean isLoopY() {
        return this.loopY;
    }

    /**
     * Setter for property loopY.
     *
     * @param loopY New value of property loopY.
     */
    public void setLoopY(boolean loopY) {
        this.loopY = loopY;
    }
}
