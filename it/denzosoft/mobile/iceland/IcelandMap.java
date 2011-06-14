/*
 * IcelandMap.java
 *
 * Created on 2 novembre 2006, 16.38
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.iceland;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.GameEngine;
import it.denzosoft.mobile.graphicEngine.MapGraphicObject;

import java.util.Vector;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class IcelandMap extends MapGraphicObject {
    // private Random ran= new Random();
    private static final int MAP_WIDTH = 8;
    private static final int MAP_HEIGHT = 128;
    private final byte[][] compatibilityMap = {
            { 1, 0, 1, 3 },
            { 2, 3, 2, 0 },
            { 0, 2, 3, 2 },
            { 3, 1, 0, 1 },
            { 1, 0, 0, 1 },
            { 2, 1, 0, 0 },
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
            { 3, 1, 1, 3 },
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
            2, 2, 2, 2, 5, 5, 5, 7, 7, 6, 5, 5, 6, 7, 3, 3, 3, 5, 10, 3, 3, 5, 5,
            6, 5, 5, 6, 6, 6, 5, 5, 6, 6
        };
    private int tileNumber = compatibilityMap.length;
    private Vector[] availableXCondition = new Vector[4];

/**
         * Creates a new instance of IcelandMap
         */
    public IcelandMap() {
        // Logger.debug("compatibilityMap
        // x="+compatibilityMap.length+",y="+compatibilityMap[0].length);
        byte startVal = (byte) GameEngine.getRandom(tileNumber); // Math.abs(
                                                                 // (ran.nextInt()
                                                                 // %
                                                                 // tileNumber));
                                                                 // Logger.debug("startVal ="+ran.nextInt() % tileNumber);

        byte[][] map = new byte[MAP_WIDTH][MAP_HEIGHT];
        java.util.Vector available = null;

        for (int ix = 0; ix < map.length; ix++) {
            map[ix][0] = 18;
        }

        for (int iy = 1; iy < map[0].length; iy++) {
            for (int ix = 0; ix < map.length; ix++) {
                if ((ix == 0) && (iy == 0)) {
                    map[0][0] = startVal;

                    // Logger.debug("Tiles X="+0+",Y="+0+";tile="+map[0][0]);
                } else {
                    available = findAvailable(map, ix, iy);

                    if (iy > 0) {
                        available = filterNextAvailable(available, map, ix, iy);

                        // if (available.size()==0) {
                        // available = findAvailable(map,ix,iy);
                        // available = filterNextAvailable(available,map,ix,iy);
                        // }
                    }

                    map[ix][iy] = priorityFilter(available);

                    // Logger.debug("Tiles
                    // X="+ix+",Y="+iy+";tile="+map[ix][iy]);
                }
            }
        }

        // byte[][] map= { {0,10,3,2,1,10,9,7} };
        this.setMap(map);
        System.gc();
    }

    private Vector findAvailable(byte[][] map, int ix, int iy) {
        Vector available = new Vector(tileNumber);

        for (byte i = 0; i < tileNumber; i++) {
            available.addElement(new Byte(i));
        }

        if ((ix > 0) && (ix < MAP_WIDTH)) {
            if (availableXCondition[compatibilityMap[map[ix - 1][iy]][1]] == null) {
                available = filter(available,
                        new byte[] {
                            -1, -1, -1, compatibilityMap[map[ix - 1][iy]][1]
                        });
                availableXCondition[compatibilityMap[map[ix - 1][iy]][1]] = available;
            } else {
                available = availableXCondition[compatibilityMap[map[ix - 1][iy]][1]];
            }
        }

        if ((iy > 0) && (iy < MAP_HEIGHT)) {
            available = filter(available,
                    new byte[] { compatibilityMap[map[ix][iy - 1]][2], -1, -1, -1 });
        }

        return available;
    }

    private Vector filter(Vector available, byte[] filter) {
        // Logger.debug("Look for"+filter[0]+filter[1]+filter[2]+filter[3]);
        Vector retVal = new Vector();

        for (int i = 0; i < available.size(); i++) {
            byte tile = ((Byte) available.elementAt(i)).byteValue();
            boolean toNotAdd = false;

            for (int o = 0; o < 4; o++) {
                if ((filter[o] != -1) &&
                        (compatibilityMap[tile][o] != filter[o])) {
                    // available.removeElementAt(i);
                    toNotAdd = true;

                    break;
                } else {
                    // toAdd = true;
                }
            }

            if (!toNotAdd) {
                // Logger.debug("Found: "+tile);
                retVal.addElement(new Byte(tile));
            }
        }

        return retVal;
    }

    private Vector filterNextAvailable(Vector available, byte[][] map, int ix,
        int iy) {
        Vector retVal = new Vector();

        for (int i = 0; i < available.size(); i++) {
            byte tile = ((Byte) available.elementAt(i)).byteValue();
            boolean toNotAdd = false;
            map[ix][iy] = tile;

            if ((ix > 0) && (ix < (MAP_WIDTH - 1)) && (iy > 0) &&
                    (findAvailable(map, ix + 1, iy).size() == 0)) {
                toNotAdd = true;
            }

            if (!toNotAdd) {
                retVal.addElement(new Byte(tile));
            }
        }

        return retVal;
    }

    private byte priorityFilter(Vector available) {
        byte chosenTile = -1;
        int maxVal = -1;
        int val = -1;

        for (int i = 0; i < available.size(); i++) {
            // val=Math.abs( (ran.nextInt() % tileNumber) ) *
            // priorityTileMap[((Byte)available.elementAt(i)).byteValue()];
            val = GameEngine.getRandom(tileNumber) * priorityTileMap[((Byte) available.elementAt(i)).byteValue()]; // Math.abs( (ran.nextInt() %
                                                                                                                   // tileNumber) );

            if (val > maxVal) {
                chosenTile = ((Byte) available.elementAt(i)).byteValue();
                maxVal = val;
            }
        }

        if (chosenTile == -1) {
            Logger.debug("No tile found");
        }

        return chosenTile;
    }
}
