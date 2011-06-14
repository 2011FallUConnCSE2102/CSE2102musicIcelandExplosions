/*
 * BenchMarker.java
 *
 * Created on 17 novembre 2003, 18.16
 */

package it.denzosoft.denzoGuitarSoft.util;

import java.util.*;

/**
 *
 * @author  De Sanctis
 */
public class BenchMarker {
    
    /** Creates a new instance of BenchMarker */
    private BenchMarker() {
    }
    
    private static HashMap hm=new HashMap();
    
    public static void enterRegion(String regionName) {
        hm.put(regionName,new Long(System.currentTimeMillis()));
    }
    
    public static void exitRegion(String regionName) {
        System.out.println(regionName+": "+(System.currentTimeMillis()-((Long)hm.get(regionName)).longValue()));
        hm.remove(regionName);
    }
    
}
