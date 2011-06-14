/*
 * ThreadCallable.java
 *
 * Created on 3 giugno 2002, 15.58
 */

package it.denzosoft.denzoGuitarSoft.util;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface ThreadCallable extends Runnable {
    public void registerCaller(ThreadCallBackable caller);
    public void start();
    public void stop();
}

