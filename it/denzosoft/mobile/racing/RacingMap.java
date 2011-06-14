/*
 * RacingMap.java
 *
 * Created on 26 ottobre 2006, 14.21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.racing;

import it.denzosoft.mobile.common.util.Logger;
import it.denzosoft.mobile.graphicEngine.MapGraphicObject;


/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class RacingMap extends MapGraphicObject {
/**
         * Creates a new instance of RacingMap
         */
    public RacingMap() {
        byte[][] map = {
                { 0, 10, 3, 2, 1, 10, 9, 7 }
            };
        Logger.debug("X=" + map.length);
        Logger.debug("Y=" + map[0].length);
        Logger.debug("map[0][7]=" + map[0][7]);

        this.setMap(map);
    }
}
