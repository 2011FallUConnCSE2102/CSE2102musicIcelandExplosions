/*
 * ThreadedChordSearchEngine.java
 *
 * Created on 3 giugno 2002, 15.39
 */

package it.denzosoft.denzoGuitarSoft.music.chord.searchEngine;
import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import java.util.Vector;
import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class ThreadedChordSearchEngine extends ChordSearchEngine implements ThreadCallable{

    public Vector result;
    public boolean lIsWorking=true;
    ThreadCallBackable lCaller;
    /** Creates new ThreadedChordSearchEngine */
    public boolean isWorking() {
        return lIsWorking;
    }

    public ThreadedChordSearchEngine() {
        super();
    }

    public ThreadedChordSearchEngine(ThreadCallBackable caller) {
        this();
        registerCaller(caller);
    }

    public Vector search(ChordValidator validator,Tuneable tuning,Properties properties) {
        lProperties=properties;
        lProperties.put("Tuning",tuning);
        lTuning=tuning;
        lValidator=validator;
        lCaller.threadStarted();
        Thread th=new Thread(this);
        th.start();
        return result;
    }

    public void run() {
        lIsWorking=true;
	result=super.search(lValidator,lTuning,lProperties);
        lIsWorking=false;
        if(lCaller!=null)
          lCaller.threadEnded(result);
    }

    public void registerCaller(ThreadCallBackable caller) {
        lCaller=caller;
    }

    public void stop() {
    }

    public void start() {
    }

    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
