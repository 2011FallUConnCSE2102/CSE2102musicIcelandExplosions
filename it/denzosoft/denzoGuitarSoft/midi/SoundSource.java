/*
 * SoundSource.java
 *
 * Created on 29 maggio 2002, 17.18
 */

package it.denzosoft.denzoGuitarSoft.midi;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public interface SoundSource {
    public void open();
    public void close();
    public void play(int pitch,int volume, int duration);
    public void playTone(int frequency,int volume, int duration);
    //public void setInstrument(int instrument);
}

