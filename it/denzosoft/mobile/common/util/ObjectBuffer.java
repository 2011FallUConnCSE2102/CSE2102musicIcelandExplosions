/*
 * ObjectBuffer.java
 *
 * Created on 24 ottobre 2006, 17.49
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
public class ObjectBuffer {
    /**
     * DOCUMENT ME!
     */
    Object[] buffer = null;

    /**
     * DOCUMENT ME!
     */
    int counter = 0;

/**
         * Creates a new instance of ObjectBuffer
         */
    public ObjectBuffer(int size) {
        buffer = new Object[size];
    }

    /**
     * DOCUMENT ME!
     *
     * @param obj DOCUMENT ME!
     */
    public void add(Object obj) {
        if (counter < buffer.length) {
            buffer[counter] = obj;
            counter++;
        }
    }

    /**
     * DOCUMENT ME!
     */
    public void clean() {
        buffer = new Object[10];
        counter = 0;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < counter; i++) {
            sb.append(buffer[i].toString()).append("; ");
        }

        return sb.toString();
    }
}
