/*
 * FixedSizeList.java
 *
 * Created on 10 novembre 2006, 16.44
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package it.denzosoft.mobile.common.util;

/**
 * 
DOCUMENT ME!
 *
 * @author De Sanctis
 */
public class FixedSizeList {
    private Object[] list;
    private int lastIndex = 0;

/**
         * Creates a new instance of FixedSizeList
         */
    public FixedSizeList(int initialCapacity) {
        list = new Object[initialCapacity];
    }

    /**
     * DOCUMENT ME!
     */
    public void clear() {
        lastIndex = 0;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public int size() {
        return lastIndex;
    }

    /**
     * DOCUMENT ME!
     *
     * @param obj DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public boolean add(Object obj) {
        if (lastIndex < list.length) {
            list[lastIndex] = obj;
            lastIndex++;

            return true;
        } /*
               * else { throw new IllegalArgumentException("There are currently
               * "+lastIndex+" elements."); }
               */
        return false;
    }

    /**
     * DOCUMENT ME!
     *
     * @param index DOCUMENT ME!
     */
    public void remove(int index) {
        if (index < lastIndex) {
            list[index] = list[lastIndex - 1];
            lastIndex--;
        } /*
               * else { throw new IllegalArgumentException("There are currently
               * "+lastIndex+" elements."); }
               */}

    /**
     * DOCUMENT ME!
     *
     * @param obj DOCUMENT ME!
     */
    public void remove(Object obj) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == obj) {
                remove(i);

                break;
            }
        }
    }

    /**
     * DOCUMENT ME!
     *
     * @param index DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Object get(int index) {
        return list[index];
    }
}
