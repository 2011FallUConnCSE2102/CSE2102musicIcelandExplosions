/*
 * MidiInterface.java
 *
 * Created on 29 maggio 2002, 16.55
 */

package it.denzosoft.denzoGuitarSoft.midi;

/**
 *
 * @author  De Sanctis
 * @version 
 */
import javax.sound.midi.*;
public class MidiInterface implements SoundSource{
    protected int instrument=0;
    protected MidiChannel midiChannels[];
    
    protected Synthesizer synthesizer;
    protected Instrument instruments[];
    //protected MidiChannel midichannel;

    /** Creates new MidiPlayNote */
    public MidiInterface() {
    }
    
    public void open()
    {
        try
        {
            if(synthesizer == null && (synthesizer = MidiSystem.getSynthesizer()) == null)
            {
                System.out.println("getSynthesizer() failed!");
                return;
            }
            synthesizer.open();
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        Soundbank soundbank = synthesizer.getDefaultSoundbank();
        if(soundbank != null)
        {
            instruments = synthesizer.getDefaultSoundbank().getInstruments();
            synthesizer.loadInstrument(instruments[instrument]);
        }
        midiChannels = synthesizer.getChannels();
        midiChannels[0].programChange(instrument);
    }

    public void close()
    {
        if(synthesizer != null)
            synthesizer.close();
        synthesizer = null;
        instruments = null;
    }

    public void noteOn(int channel, int pitch,int velocity) {
        midiChannels[channel].noteOn(pitch,velocity);
    }
    
    public void noteOff(int channel, int pitch,int velocity) {
        midiChannels[channel].noteOff(pitch);
    }
    
    public void waitMilliSeconds(int milliSeconds) {
        if (milliSeconds>0)
            try {
                Thread.sleep(milliSeconds);
                //wait(300l);
            } catch (InterruptedException e) {
            }
    }
    
    public void programChange(int channel,int newInstrument) {
        midiChannels[channel].programChange(instrument);        
    }
    
    public int getProgram(int channel) {
        return midiChannels[channel].getProgram();
    }
    
    public void controlChange(int channel,int controller,int value) {
       midiChannels[channel].controlChange(controller,value);
    }

    public int getController(int channel,int controller) {
        return midiChannels[channel].getController(controller);
    }
    
    public int getPitchBend(int channel) {
        return midiChannels[channel].getPitchBend();
    }
    
    public void setPitchBend(int channel, int value) {
        //value 0-16383, 8192 = no bend!
        midiChannels[channel].setPitchBend(value);
    }
    public void allNotesOff(int channel) {
       midiChannels[channel].allNotesOff();
    }
    
    public void playNote(int channel,int pitch,int velocity,int duration)
    {
        //midichannel.allNotesOff();
        noteOn(channel,pitch,velocity);
        waitMilliSeconds(duration);
        noteOff(channel,pitch,velocity);
    }

    public static final String GMInstruments[] = {
        "Acoustic Grand Piano", "Bright Acoustic Piano", "Electric Grand Piano", "Honky-tonk Piano", "Rhodes Piano", "Chorused Piano", "Harpsichord", "Clavinet", "Celesta", "Glockenspiel", 
        "Music Box", "Vibraphone", "Marimba", "Xylophone", "Tubular Bells", "Dulcimer", "Hammond Organ", "Percussive Organ", "Rock Organ", "Church Organ", 
        "Reed Organ", "Accordian", "Harmonica", "Tango Accordian", "Acoustic Guitar (nylon)", "Acoustic Guitar (steel)", "Electric Guitar (jazz)", "Electric Guitar (clean)", "Electric Guitar (muted)", "Overdriven Guitar", 
        "Distortion Guitar", "Guitar Harmonics", "Acoustic Bass", "Electric Bass (finger)", "Electric Bass (pick)", "Fretless Bass", "Slap Bass 1", "Slap Bass 2", "Synth Bass 1", "Synth Bass 2", 
        "Violin", "Viola", "Cello", "Contrabass", "Tremolo Strings", "Pizzicato Strings", "Orchestral Harp", "Timpani", "String Ensemble 1", "String Ensemble 2", 
        "Synth Strings 1", "Synth Strings 2", "Choir Aahs", "Voice Oohs", "Synth Voice", "Orchestra Hit", "Trumpet", "Trombone", "Tuba", "Muted Trumpet", 
        "French Horn", "Brass Section", "Synth Brass 1", "Synth Brass 2", "Soprano Sax", "Alto Sax", "Tenor Sax", "Baritone Sax", "Oboe", "English Horn", 
        "Bassoon", "Clarinet", "Piccolo", "Flute ", "Recorder", "Pan Flute", "Bottle Blow", "Shakuhachi", "Whistle", "Ocarina", 
        "Lead 1 (square)", "Lead 2 (sawtooth)", "Lead 3 (caliope lead)", "Lead 4 (chiff lead)", "Lead 5 (charang)", "Lead 6 (voice)", "Lead 7 (fifths)", "Lead 8 (brass + lead)", "Pad 1 (new age)", "Pad 2 (warm)", 
        "Pad 3 (polysynth)", "Pad 4 (choir)", "Pad 5 (bowed)", "Pad 6 (metallic)", "Pad 7 (halo)", "Pad 8 (sweep)", "FX 1 (rain)", "FX 2 (soundtrack)", "FX 3 (crystal)", "FX 4 (atmosphere)", 
        "FX 5 (brightness)", "FX 6 (goblins)", "FX 7 (echoes)", "FX 8 (sci-fi)", "Sitar", "Banjo", "Shamisen", "Koto", "Kalimba", "Bagpipe", 
        "Fiddle", "Shanai", "Tinkle Bell", "Agogo", "Steel Drums", "Woodblock", "Taiko Drum", "Melodic Tom", "Synth Drum", "Reverse Cymbal", 
        "Guitar Fret Noise", "Breath Noise", "Seashore", "Bird Tweet", "Telephone Ring", "Helicopter", "Applause", "Gunshot"
    };
    
     public void play(int pitch, int volume, int duration) {
         playNote(0,pitch,volume,duration);
     }
    
     public static void main(String args[]) {
        MidiInterface tmp=new MidiInterface();
        tmp.open();
        tmp.playNote(10,50,127,2000);
        tmp.close();
        System.out.println("Hello!");
        System.exit(0);  
     }
     
     public void playTone(int frequency, int volume, int duration) {
     }     
     
}
