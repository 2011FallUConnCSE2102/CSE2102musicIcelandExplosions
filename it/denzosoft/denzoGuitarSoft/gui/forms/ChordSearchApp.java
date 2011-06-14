/*
 * ChordSearchApp.java
 *
 * Created on 30 maggio 2002, 13.50
 */

package it.denzosoft.denzoGuitarSoft.gui.forms;

import java.awt.event.*;
import it.denzosoft.denzoGuitarSoft.gui.modelViewController.*;
import it.denzosoft.denzoGuitarSoft.util.*;
import java.util.Vector;
import it.denzosoft.denzoGuitarSoft.notation.noteName.*;
import javax.swing.event.*;
import java.awt.Graphics;
import it.denzosoft.denzoGuitarSoft.guitar.position.*;
import it.denzosoft.denzoGuitarSoft.gui.graphic.chord.*;
/**
 *
 * @author  De Sanctis
 * @version 1.0
 */
public class ChordSearchApp extends ChordSearchForm implements Controllable,Dispatcherable{

    Controller lController;
    Modelable lModel;
    /** Creates new ChordSearchApp */
    public ChordSearchApp() {
        //super.this();
    }

    public void Frame_Load() {
      Text1.setText("0");
      Text2.setText("7");
      NoteName tmp=EnglishNoteName.getInstance();
      //System.out.println(tmp.getName(4));
      for(int i=0;i<12;i++)
          Combo1.addItem(tmp.getName(i));
      Combo1.setSelectedIndex(0);

      List1.addListSelectionListener (new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent e){
              List1_VALUECHANGED(e);
          }
      });
    }

    protected void Command1_ACTIONPERFORMED(ActionEvent e){
        DenzoProperties prop=new DenzoProperties();
        prop.put("StartSearchPosition",new Integer(Text1.getText()));
        prop.put("EndSearchPosition",new Integer(Text2.getText()));

        prop.put("ChordRoot",new Integer(Combo1.getSelectedIndex()));
        //prop.put("ChordFormula",new Integer(15));
        //if (Check1.
        prop.put("AllowOpenChord",new Boolean(Check1.isSelected()));
        prop.put("AllowInversions",new Boolean(Check2.isSelected()));

        Event event=new Event("StartSearch",prop);
        lController.happenEvent(event);
    }

    public void Picture1_PAINT(Graphics g) {
        if (List1.isSelectionEmpty())
          return;
        int index=List1.getSelectedIndex();
        String text=(String)List1.getSelectedValue();
        ChordPositions cp=new ChordPositions(text);
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


    public void registerController(Controller controller) {
        lController=controller;
    }
    public void registerModel(Modelable model) {
        lModel=model;
    }

    public static void main(String[] args) {
        ChordSearchApp Form3 = new ChordSearchApp();
        Form3.show();
    }

    public void changeView(String view, Properties parameters) {
        if (view.equals("ShowSearchResult")) {
            Properties prop=lModel.getValues("SearchResults");
            Vector retVal=(Vector)prop.get("Values");
            List1Model.clear();
            int upBound=retVal.capacity();
            for(int i=0;i<upBound;i++)
                List1Model.add(i,retVal.elementAt(i));
        }
    }

}
