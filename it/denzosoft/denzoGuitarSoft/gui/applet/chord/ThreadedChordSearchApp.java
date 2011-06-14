/*
 * ChordSearchApp.java
 *
 * Created on 30 maggio 2002, 13.50
 */

package it.denzosoft.denzoGuitarSoft.gui.applet.chord;

import java.awt.event.*;
import it.denzosoft.denzoGuitarSoft.gui.modelViewController.*;
import it.denzosoft.denzoGuitarSoft.gui.modelViewController.Event;
import it.denzosoft.denzoGuitarSoft.music.*;
import it.denzosoft.denzoGuitarSoft.util.*;
import it.denzosoft.denzoGuitarSoft.gui.forms.*;
import it.denzosoft.denzoGuitarSoft.notation.noteName.*;
import it.denzosoft.denzoGuitarSoft.guitar.position.*;
import it.denzosoft.denzoGuitarSoft.gui.graphic.chord.*;
import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;


import java.util.Vector;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class ThreadedChordSearchApp extends ChordSearchApplet implements ThreadCallBackable{
    
    private static final String[] chordNames={
        "major","5","6","6/9","7","7sus","7+5","7-5","7/6","7-9","7+9",
        "7/13","9","9-5","9+5","9/6","9+11","11","11-9","11#7","13",
        "dim","dim7","m","m-5","m6","m6/9","m7","m7-5","m7+5","m7-9",
        "m#7","m#7-5","m#7+5","m#7-9","m9","madd9","m#9","m9#7","m11",
        "maug11","m13","maj7","maj7-5","maj7+5","maj7sus","maj7-9",
        "maj7+9","maj9","maj9sus","maj11","maj13","add9","sus2","sus4",
        "+","+9","+11","-5","-9","-9+5","-9-5","-9+11","-13"
    };
    private static final String[] chordFormulas={
        "0 4 7 ","0 7 ","0 4 7 9 ","0 4 7 9 2 ","0 4 7 10 ","0 5 7 10 ",
        "0 4 8 10 ","0 4 6 10 ","0 4 7 9 10 ","0 4 7 10 1 ","0 4 7 10 3 ",
        "0 4 7 10 9 ","0 4 7 10 2 ","0 4 6 10 2 ","0 4 8 10 2 ","0 4 7 9 10 2 ",
        "0 4 7 10 2 6 ","0 4 7 10 2 5 ","0 4 7 10 1 5 ","0 4 7 11 2 5 ",
        "0 4 7 10 2 9 ","0 3 6 ","0 3 6 9 ","0 3 7 ","0 3 6 ","0 3 7 9 ",
        "0 3 7 9 2 ","0 3 7 10 ","0 3 6 10 ","0 3 8 10 ","0 3 7 10 1 ",
        "0 3 7 11 ","0 3 6 11 ","0 3 8 11 ","0 3 7 11 1 ","0 3 7 10 2 ",
        "0 3 7 2 ","0 3 7 11 2 ","0 3 7 11 2 ","0 3 7 10 2 5 ","0 3 7 10 2 6 ",
        "0 3 7 10 2 9 ","0 4 7 11 ","0 4 6 11 ","0 4 8 11 ","0 5 7 11 ",
        "0 4 7 11 1 ","0 4 7 11 3 ","0 4 7 11 2 ","0 5 7 11 2 ","0 4 7 11 2 5 ",
        "0 4 7 11 2 9 ","0 4 7 2 ","0 2 7 ","0 5 7 ","0 4 8 ","0 4 7 10 3 ",
        "0 4 7 10 2 6 ","0 4 6 ","0 4 7 10 1 ","0 4 8 10 1 ","0 4 6 10 1 ",
        "0 4 7 10 1 5 ","0 4 7 10 2 8 "
    };
    Vector retVal;
    /** Creates new ChordSearchApp */
    public ThreadedChordSearchApp() {
    }
    
    public void init() {
        super.init();
        Text1.setText("0");
        Text2.setText("15");
        Text3.setText("4");
        Text4.setText("3");
        Check4.setSelected(true);
        NoteName tmp=EnglishNoteName.getInstance();
        //System.out.println(tmp.getName(4));
        for(int i=0;i<12;i++)
            Combo1.addItem(tmp.getName(i));
        Combo1.setSelectedIndex(0);
        for(int i=0;i<chordNames.length;i++)
            Combo2.addItem(chordNames[i]);
        for(int i=0;i<Tuning.tuningNameList.length;i++)
            Combo3.addItem(Tuning.tuningNameList[i]);
/*
        Combo3.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e){
                Combo3_ACTIONPERFORMED(e);
            }
        });
 */
        List1.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e){
                List1_VALUECHANGED(e);
            }
        });
    }
    
    protected void Command1_ACTIONPERFORMED(ActionEvent e){
        it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.OptimizedChordValidator scv=new it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.OptimizedChordValidator();
        it.denzosoft.denzoGuitarSoft.music.Pitch root=new it.denzosoft.denzoGuitarSoft.music.Pitch(Combo1.getSelectedIndex());
        //it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord chord=new it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord(root,"0 4 7 11");
        it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord chord=new it.denzosoft.denzoGuitarSoft.music.chord.PitchedChord(root,chordFormulas[Combo2.getSelectedIndex()]);
        it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning tuning=new it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning(Combo3.getSelectedIndex());
        //it.denzosoft.denzoGuitarSoft.util.DenzoProperties prop=new it.denzosoft.denzoGuitarSoft.util.DenzoProperties();
        it.denzosoft.denzoGuitarSoft.util.Properties prop=new DenzoProperties();
        
        prop.put("StartSearchPosition",new Integer(Text1.getText()));
        prop.put("EndSearchPosition",new Integer(Text2.getText()));
        prop.put("ChordFormula",chordFormulas[Combo2.getSelectedIndex()]);
        prop.put("FrameFrets",new Integer(Text3.getText()));
        prop.put("NoteNumber",new Integer(Text4.getText()));
        
        prop.put("ChordRoot",new Integer(Combo1.getSelectedIndex()));
        //prop.put("ChordFormula",new Integer(15));
        //if (Check1.
        prop.put("AllowOpenChord",new Boolean(Check1.isSelected()));
        prop.put("AllowInversions",new Boolean(Check2.isSelected()));
        prop.put("AllowExtractChord",new Boolean(Check4.isSelected()));
        prop.put("AllowBrokenChord",new Boolean(Check3.isSelected()));
        
        
        //executionRetVal=new DenzoProperties();
        scv.prepare(chord,tuning,prop);
        //it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.ChordSearchEngine cse=new it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.ChordSearchEngine();
        it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.ThreadedChordSearchEngine cse=new it.denzosoft.denzoGuitarSoft.music.chord.searchEngine.ThreadedChordSearchEngine(this);
        long t=System.currentTimeMillis();
        retVal=cse.search(scv,tuning,prop);
        //executionRetVal.put("ReturnValue",tt);
        System.out.println((System.currentTimeMillis()-t));
    }
    
    public void Picture1_PAINT(Graphics g) {
        if (List1.isSelectionEmpty())
            return;
        int index=List1.getSelectedIndex();
        String text=(String)List1.getSelectedValue();
        ChordPositions cp=new ChordPositions(text);
        it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning tuning=new it.denzosoft.denzoGuitarSoft.guitar.tuning.Tuning(Combo3.getSelectedIndex());
        cp.setTuning(tuning);
        
        cp.getProperties().put("Root",new Integer(Combo1.getSelectedIndex()));
        ChordImage ci=new ChordImage();
        ci.getImage(cp,g,0,0,Picture1.getWidth(),Picture1.getHeight());
    }
    
    protected void List1_VALUECHANGED(ListSelectionEvent e){
        //this.setTitle("List1_VALUECHANGED");
        if (e.getValueIsAdjusting())
            return;
        if (List1.isSelectionEmpty())
            return;
        Picture1.paint(Picture1.getGraphics());
    }
    
    
    public static void main(String[] args) {
        ThreadedChordSearchApp applet = new ThreadedChordSearchApp();
        JFrame frame;
        frame = new JFrame() {
            protected void processWindowEvent(WindowEvent e) {
                super.processWindowEvent(e);
                if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                    System.exit(0);
                }
            }
            public synchronized void setTitle(String title) {
                super.setTitle(title);
                enableEvents(AWTEvent.WINDOW_EVENT_MASK);
            }
        };
        frame.setTitle("Applet Frame");
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        frame.setSize(390,350);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }
    
    public void threadStarted() {
        Command1.setText("Searching...");
        Command1.disable();
    }
    
    public void threadEnded(Object result) {
        //retVal=(Vector)prop.get("Values");
        retVal=(Vector)result;
        Object[] h=retVal.toArray();
        Arrays.sort(h);
        retVal=new Vector(Arrays.asList(h));
        retVal.trimToSize();
        List1Model.clear();
        int upBound=retVal.capacity();
        for(int i=0;i<upBound;i++)
            List1Model.add(i,retVal.elementAt(i));
        Command1.setText("Search");
        Command1.enable();
        
    }
    
}
