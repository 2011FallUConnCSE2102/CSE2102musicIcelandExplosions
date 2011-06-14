/*
 * ChordFinder.java
 *
 * Created on 20 maggio 2004, 11.20
 */

package it.denzosoft.mobile.chordFinder;

import java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

/**
 * An example MIDlet with simple "Hello" text and an Exit command.
 * Refer to the startApp, pauseApp, and destroyApp
 * methods so see how each handles the requested transition.
 *
 * @author  De Sanctis
 * @version
 */
public class ChordFinder extends MIDlet implements CommandListener {
    
    private Command exitCommand; // The exit command
    private Command nextCommand; // The exit command
    private Display display;    // The display for this MIDlet
    private Vector pos;
    private ChordSearchEngine cse;
    private TextBox t;
    
    public ChordFinder() {
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit", Command.SCREEN, 2);
        nextCommand = new Command("Next", Command.SCREEN, 3);
    }
    
    /**
     * Start up the Hello MIDlet by creating the TextBox and associating
     * the exit command and listener.
     */
    public void startApp() {
        String chordFormula="0 4 7 11 ";
        OptimizedChordValidator scv=new OptimizedChordValidator();
        Pitch root=new Pitch(0);
        PitchedChord chord=new PitchedChord(root,chordFormula);
        Tuning tuning=new Tuning(Tuning.TUNING_STANDARD);
        DenzoProperties prop=new DenzoProperties();
        prop.put("StartSearchPosition",new Integer(0));
        prop.put("EndSearchPosition",new Integer(15));
        prop.put("ChordFormula",chordFormula);
        prop.put("ChordRoot",new Integer(root.getNotePitch()));
        prop.put("NoteNumber",new Integer(4));
        prop.put("FrameFrets",new Integer(5));
        prop.put("AllowOpenChord",new Boolean(false));
        prop.put("AllowInversions",new Boolean(true));
        prop.put("AllowExtractChord",new Boolean(true));
        prop.put("AllowBrokenChord",new Boolean(true));
        
        
        scv.prepare(chord,tuning,prop);
        System.out.println("Sto per...");
        cse=new ChordSearchEngine();
        System.out.println("Sto per... ++");
        //long t=System.currentTimeMillis();
//        Vector retVal=cse.search(scv,tuning,prop);

        cse.startSearch(scv,tuning,prop);
        
        int last=0;
        StringBuffer sb=new StringBuffer();
        //while ((pos=cse.nextSearch())!=null) {
            pos=cse.nextSearch();
            for(int i=last;i<pos.size();i++) {
                System.out.println(pos.elementAt(i));
                sb.append(pos.elementAt(i)+"\n");
                last++;
            }
            //System.out.println(pos);
        //}        
        
//        sb.append("Hello! "+retVal.size()+" Results found");
//        for(int i=0;i<retVal.size();i++) {
//            sb.append(retVal.elementAt(i));
//        }
        
        
        
        t = new TextBox("Hello MIDlet", sb.toString(), 256, 0);
        
        t.addCommand(exitCommand);
        t.addCommand(nextCommand);
        t.setCommandListener(this);
        
        display.setCurrent(t);
    }
    
    /**
     * Pause is a no-op since there are no background activities or
     * record stores that need to be closed.
     */
    public void pauseApp() {
    }
    
    /**
     * Destroy must cleanup everything not handled by the garbage collector.
     * In this case there is nothing to cleanup.
     */
    public void destroyApp(boolean unconditional) {
    }
    
    /*
     * Respond to commands, including exit
     * On the exit command, cleanup and notify that the MIDlet has been destroyed.
     */
    int last=0;
    
    public void commandAction(Command c, Displayable s) {
        if (c == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        }
        if (c == nextCommand) {
            StringBuffer sb=new StringBuffer();
            pos=cse.nextSearch();
            for(int i=last;i<pos.size();i++) {
                System.out.println(pos.elementAt(i));
                sb.append(pos.elementAt(i)+"\n");
                last++;
            }
            t.setString(sb.toString());
            
        }    
    }
}
