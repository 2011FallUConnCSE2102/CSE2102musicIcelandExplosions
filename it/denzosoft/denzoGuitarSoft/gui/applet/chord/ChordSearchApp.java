/*
 * ChordSearchApp.java
 *
 * Created on 30 maggio 2002, 13.50
 */

package it.denzosoft.denzoGuitarSoft.gui.applet.chord;

import it.denzosoft.denzoGuitarSoft.gui.modelViewController.*;
import it.denzosoft.denzoGuitarSoft.gui.modelViewController.Event;
import it.denzosoft.denzoGuitarSoft.util.*;
import it.denzosoft.denzoGuitarSoft.gui.forms.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import it.denzosoft.denzoGuitarSoft.notation.noteName.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public class ChordSearchApp extends ChordSearchApplet implements Controllable , Dispatcherable {

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

    Controller lController;
    Modelable lModel;
    /** Creates new ChordSearchApp */
    public ChordSearchApp() {
    }

    public void init() {
        super.init();

        Text1.setText("0");
        Text2.setText("7");
        NoteName tmp=EnglishNoteName.getInstance();
        //System.out.println(tmp.getName(4));
        for(int i=0;i<12;i++)
            Combo1.addItem(tmp.getName(i));
        Combo1.setSelectedIndex(0);
        for(int i=0;i<chordNames.length;i++)
            Combo2.addItem(chordNames[i]);

         ChordSearchModel model=new ChordSearchModel();
         ChordSearchApp gui=this;
         Controller controller=new ChordSearchController();
         controller.registerModel(model);
         controller.registerDispatcher(gui);
         gui.registerController(controller);
         gui.registerModel(model);

    }

    protected void Command1_ACTIONPERFORMED(ActionEvent e){
        DenzoProperties prop=new DenzoProperties();
        prop.put("StartSearchPosition",new Integer(Text1.getText()));
        prop.put("EndSearchPosition",new Integer(Text2.getText()));

        prop.put("ChordRoot",new Integer(Combo1.getSelectedIndex()));
        prop.put("ChordFormula",chordFormulas[Combo2.getSelectedIndex()]);
        //prop.put("ChordFormula",new Integer(15));
        //if (Check1.
        prop.put("AllowOpenChord",new Boolean(Check1.isSelected()));
        prop.put("AllowInversions",new Boolean(Check2.isSelected()));
        it.denzosoft.denzoGuitarSoft.gui.modelViewController.Event event=new Event("StartSearch",prop);
        lController.happenEvent(event);
    }

    public void registerController(Controller controller) {
        lController=controller;
    }
    public void registerModel(Modelable model) {
        lModel=model;
    }


    public void changeView(String view, it.denzosoft.denzoGuitarSoft.util.Properties parameters) {
        if (view.equals("ShowSearchResult")) {
            it.denzosoft.denzoGuitarSoft.util.Properties prop=lModel.getValues("SearchResults");
            Vector retVal=(Vector)prop.get("Values");
            List1Model.clear();
            for(int i=0;i<retVal.capacity();i++)
                List1Model.add(i,retVal.elementAt(i));
        }
    }

    public static void main(String[] args) {
      ChordSearchApp applet = new ChordSearchApp();
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
      frame.setSize(400,320);
      Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
      frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
      frame.setVisible(true);
    }
}
