/*
 * ThreadCallBackable.java
 *
 * Created on 3 giugno 2002, 15.57
 */

package it.denzosoft.denzoGuitarSoft.util;

/**
 *
 * @author  De Sanctis
 * @version
 */
public interface ThreadCallBackable {
    public void threadStarted();
    public void threadEnded(Object result);
}

