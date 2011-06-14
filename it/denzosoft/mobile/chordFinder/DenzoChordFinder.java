/*
 * DenzoChordFinder.java
 *
 * Created on 30 marzo 2006, 18.08
 */

package it.denzosoft.mobile.chordFinder;

import java.util.Vector;
import javax.microedition.lcdui.*;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class DenzoChordFinder extends javax.microedition.midlet.MIDlet
        implements CommandListener, Runnable{
    private Command exitCommand; // The exit command
    private Command chordCommand; // The exit command
    private Command tuningCommand; // The exit command
    public Display display;    // The display for this MIDlet
    private Vector pos;
    private ChordSearchEngine cse;
    public ChordCanvas canvas;
    private List list;
    
    public Tuning tuning=new Tuning(Tuning.TUNING_STANDARD);
    public int root=0;
    public String chordFormula;
    public String chordName;
    public static DenzoChordFinder finder;
    private boolean running=false;
    
    public void startApp() {
        finder=this;
        display = Display.getDisplay(this);
        exitCommand = new Command("Exit", Command.SCREEN, 2);
        chordCommand = new Command("Chord", Command.SCREEN, 3);
        tuningCommand = new Command("Tuning", Command.SCREEN, 4);
        //        GuitarPositions cp=null;
        //        cp=new GuitarPositions("X 3 2 0 0 0");
        //        cp.setTuning(tuning);
        //        cp.setProperty("Root",new Integer(root));
        
        canvas = new ChordCanvas();
        //        canvas.setGuitarPosition(cp);
        canvas.addCommand(exitCommand);
        canvas.addCommand(chordCommand);
        canvas.addCommand(tuningCommand);
        canvas.setCommandListener(this);
        display.setCurrent(canvas);
        chordFormula="0 4 7";
        chordName="maj";
        root=0;
        startSearch(chordFormula, root);
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
    
    private void startSearch(String chordString, int root) {
        last=0;
        pos=null;
        String chordFormula=chordString;
        OptimizedChordValidator scv=new OptimizedChordValidator();
        Pitch pRoot=new Pitch(root);
        PitchedChord chord=new PitchedChord(pRoot,chordFormula);
        DenzoProperties prop=new DenzoProperties();
        prop.put("StartSearchPosition",new Integer(0));
        prop.put("EndSearchPosition",new Integer(15));
        prop.put("ChordFormula",chordFormula);
        prop.put("ChordRoot",new Integer(pRoot.getNotePitch()));
        prop.put("NoteNumber",new Integer(4));
        prop.put("FrameFrets",new Integer(5));
        prop.put("AllowOpenChord",new Boolean(false));
        prop.put("AllowInversions",new Boolean(true));
        prop.put("AllowExtractChord",new Boolean(true));
        prop.put("AllowBrokenChord",new Boolean(false));
        
        
        scv.prepare(chord,tuning,prop);
//        System.out.println("Sto per...");
        cse=new ChordSearchEngine();
//        System.out.println("Sto per... ++");
        //long t=System.currentTimeMillis();
        //        Vector retVal=cse.search(scv,tuning,prop);
        
        cse.startSearch(scv,tuning,prop);
        drawNext();
    }
    
    int last=0;
    
    public void drawNext() {
        if (running)
            return;
        if (cse==null) {
            startSearch(chordFormula, root);
            last--;
        }
        if (pos==null || last==pos.size()) {
            System.out.println("Calcolo...");
            Thread th=new Thread(this);
            th.start();
            return;
//            pos=cse.nextSearch();
        }
        if (pos!=null && last<=pos.size()) {
            System.out.println("Disegno...");
            GuitarPositions cp=null;
            cp=new GuitarPositions((String)pos.elementAt(last));
            cp.setTuning(tuning);
            cp.setProperty("Root",new Integer(root));
            
            //canvas = new ChordCanvas();
            canvas.setGuitarPosition(cp);
            canvas.repaint();
            last++;
        }
        //t.setString(sb.toString());
        System.out.println("Last="+last);
        System.out.println("Pos.size="+pos.size());
    }
    
    public void drawPrev() {
        if (pos!=null && last>1) {
            last=last-2;
            GuitarPositions cp=null;
            cp=new GuitarPositions((String)pos.elementAt(last));
            cp.setTuning(tuning);
            cp.setProperty("Root",new Integer(root));
            
            //canvas = new ChordCanvas();
            canvas.setGuitarPosition(cp);
            canvas.repaint();
            last++;
        }
        //t.setString(sb.toString());
        System.out.println("Last="+last);
        System.out.println("Pos.size="+pos.size());
    }
    
    public void changeRoot() {
        startSearch(chordFormula, root);
        if (pos!=null && last<=pos.size()) {
            System.out.println("Disegno...");
            GuitarPositions cp=null;
            cp=new GuitarPositions((String)pos.elementAt(last));
            cp.setTuning(tuning);
            cp.setProperty("Root",new Integer(root));
            
            //canvas = new ChordCanvas();
            canvas.setGuitarPosition(cp);
            canvas.repaint();
            last++;
        }
    }
    
    public void commandAction(javax.microedition.lcdui.Command command, javax.microedition.lcdui.Displayable displayable) {
        if (command == exitCommand) {
            destroyApp(false);
            notifyDestroyed();
        } else if (command == chordCommand) {
            list=new ChordList(List.IMPLICIT);
            display.setCurrent(list);
        } else if (command == tuningCommand) {
            list=new TuningList(List.IMPLICIT);
            display.setCurrent(list);
        }
    }
    
    public void run() {
        System.out.println("Running...");
        running=true;
        pos=cse.nextSearch();
        if (last==pos.size())
            last=0;
        running=false;
        drawNext();
        System.out.println("End thread");
    }
    
}

