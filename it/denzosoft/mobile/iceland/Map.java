/*
 * Map.java
 *
 * Created on 2 novembre 2006, 16.38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.MapGraphicObject;

import java.util.Random;
import java.util.Vector;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class Map extends MapGraphicObject {
    private final byte[][] compatibilityMap = {
            { 1, 0, 1, 3 },
            { 2, 3, 2, 0 },
            { 0, 2, 3, 2 },
            { 3, 1, 0, 1 },
            { 1, 0, 0, 1 },
            { 0, 2, 2, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 3, 1, 1, 3 },
            { 3, 3, 2, 1 },
            { 1, 2, 3, 3 },
            { 2, 3, 3, 2 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 0, 0 },
            { 3, 3, 3, 3 },
            { 0, 0, 1, 2 },
            { 3, 3, 3, 3 },
            { 3, 3, 3, 3 },
            { 3, 3, 3, 3 },
            { 1, 0, 1, 3 },
            { 1, 2, 3, 3 },
            { 3, 1, 2, 3 },
            { 2, 3, 2, 0 },
            { 3, 1, 0, 1 },
            { 0, 2, 3, 2 },
            { 2, 3, 3, 2 },
            { 3, 3, 2, 1 },
            { 0, 2, 2, 0 },
            { 0, 0, 1, 2 },
            { 2, 1, 0, 0 },
            { 1, 0, 0, 1 }
        };
    private final byte[] priorityTileMap = {
            5, 5, 5, 5, 3, 3, 3, 10, 10, 3, 3, 3, 3, 7, 4, 3, 3, 3, 10, 9, 8, 5,
            4, 4, 5, 4, 4, 3, 6, 5, 5, 5, 5
        };
    private int tileNumber = compatibilityMap.length;
    private Random ran = new Random();

/** Creates a new instance of Map */
    public Map() {
        Logger.debug("compatibilityMap x=" + compatibilityMap.length + ",y=" +
            compatibilityMap[0].length);

        byte startVal = (byte) Math.abs((ran.nextInt() % tileNumber));
        Logger.debug("startVal =" + (ran.nextInt() % tileNumber));

        byte[][] map = new byte[10][10];
        java.util.Vector available = null;

        for (int iy = 0; iy < 10; iy++) {
            for (int ix = 0; ix < 10; ix++) {
                if ((ix == 0) && (iy == 0)) {
                    map[0][0] = startVal;
                } else {
                    available = new Vector(tileNumber);

                    for (byte i = 0; i < tileNumber; i++) {
                        available.addElement(new Byte(i));
                    }

                    if (ix > 0) {
                        available = filter(available,
                                new byte[] {
                                    -1, compatibilityMap[map[ix - 1][iy]][1], -1,
                                    -1
                                });
                    }

                    if (iy > 1) {
                        available = filter(available,
                                new byte[] {
                                    -1, -1, compatibilityMap[map[ix][iy - 1]][1],
                                    -1
                                });
                    }

                    map[ix][iy] = priorityFilter(available);
                    Logger.debug("Tiles X=" + ix + ",Y=" + iy + ";tile=" +
                        map[ix][iy]);
                }
            }
        }

        // byte[][] map= { {0,10,3,2,1,10,9,7} };
        this.setMap(map);
    }

    private Vector filter(Vector available, byte[] filter) {
        Vector retVal = new Vector();

        for (int i = 0; i < tileNumber; i++) {
            byte tile = ((Byte) available.elementAt(i)).byteValue();
            boolean toNotAdd = false;

            for (int o = 0; o < 4; o++) {
                if ((filter[0] != -1) &&
                        (compatibilityMap[tile][0] != filter[0])) {
                    // available.removeElementAt(i);
                    toNotAdd = true;
                } else {
                    // toAdd = true;
                }
            }

            if (!toNotAdd) {
                retVal.addElement(new Byte(tile));
            }
        }

        return retVal;
    }

    private byte priorityFilter(Vector available) {
        byte chosenTile = 0;
        int maxVal = -1;
        int val = -1;

        for (int i = 0; i < available.size(); i++) {
            val = Math.abs((ran.nextInt() % tileNumber)) * priorityTileMap[((Byte) available.elementAt(i)).byteValue()];

            if (val > maxVal) {
                chosenTile = ((Byte) available.elementAt(i)).byteValue();
                maxVal = val;
            }
        }

        return chosenTile;
    }
}
