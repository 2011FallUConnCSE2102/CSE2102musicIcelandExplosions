/*
 * ChordImage.java
 *
 * Created on 31 maggio 2002, 11.19
 */

package it.denzosoft.denzoGuitarSoft.gui.graphic.chord;

import it.denzosoft.denzoGuitarSoft.guitar.position.*;
import it.denzosoft.denzoGuitarSoft.guitar.tuning.*;
import java.awt.Image;
import java.awt.image.MemoryImageSource;
import javax.swing.JPanel;
import java.awt.*;

/**
 *
 * @author  De Sanctis
 * @version
 */
public class ChordImage implements ChordPrinter {
    
    /** Creates new ChordImage */
    public ChordImage() {
    }
    
    public void getImage(Positions positions, Graphics graphics, int top, int left, int width, int height) {
        //int[] pix=new int[width*height];
        //Image img=createImage(new MemoryImageSource(width,height,pix,0,width));
        //Image img=createImage(width,height);
        //Graphics g=img.getGraphics();
        //return img;
        Tuneable tuning=positions.getTuning();
        int topRect=(int)((double)(top+((double)height/6)));
        int leftRect=(int)((double)(left+((double)width/6D)));
        int widthRect=(int)(((double)width/3)*2D);
        int heightRect=(int)(((double)height/3)*2D);
        
//        graphics.clearRect(top, left, width,  height);
        graphics.setColor(Color.white);
        graphics.fillRect(top, left, width,  height);
        graphics.setColor(Color.black);
        
        int numNote=positions.size();
        int numString=tuning.getStringNumber();
        int root=-1;
        if(positions.getProperties().get("Root")!=null)
            root=((Integer)positions.getProperties().get("Root")).intValue();
        Position pos;
        int minFret=50;
        int maxFret=-1;
        for(int i=0;i<numNote;i++) {
            //pos=(Position)positions.get(i);
            if (((Position)positions.get(i)).getFret()!=0) {
                minFret=Math.min(minFret,((Position)positions.get(i)).getFret());
                maxFret=Math.max(maxFret,((Position)positions.get(i)).getFret());
            }
        }
        int numFret=maxFret-minFret+1;
        if (numFret<4)
            numFret=4;
        double fretSpace=(((double)heightRect)/(double)numFret);
        double stringSpace=((double)widthRect)/(double)(numString-1);
        if (fretSpace>stringSpace)
            fretSpace=stringSpace;
        else
            stringSpace=fretSpace;
        
        for(int i=0;i<numFret+1;i++) {
            if (i==0 && maxFret<5)
                //                graphics.drawLine(leftRect,(int)(topRect+(fretSpace)*(i)),(int)(leftRect+stringSpace*(numString-1)),(int)(topRect+(fretSpace)*(i)));
                graphics.fillRect(leftRect,(int)(topRect+(fretSpace)*(i)),(int)(stringSpace*(numString-1)),3);
            else
                graphics.drawLine(leftRect,(int)(topRect+(fretSpace)*(i)),(int)(leftRect+stringSpace*(numString-1)),(int)(topRect+(fretSpace)*(i)));
        }
        for(int i=0;i<numString;i++) {
            graphics.drawLine((int)(leftRect+stringSpace*i),topRect,(int)(leftRect+stringSpace*i),(int)(topRect+numFret*fretSpace));
        }
        int startFret=minFret;
        if ((maxFret-numFret)>-1)
            startFret=maxFret-numFret;
        else
            startFret=0;
        for(int i=0;i<numNote;i++) {
            pos=(Position)positions.get(i);
            if (pos.getFret()!=0) {
                if((tuning.getPitch(pos.getString(),pos.getFret())%12)==root)
                    graphics.setColor(new Color(230,230,230));
                graphics.fillOval(
                    (int)(leftRect+stringSpace*pos.getString()-stringSpace/2) ,
                    (int)(topRect+fretSpace*(pos.getFret()-startFret)-fretSpace)  ,
                    (int)(stringSpace*1.1)  ,
                    (int)(fretSpace*1.1)
                );
                graphics.setColor(new Color(00,00,00));
                    graphics.drawOval(
                    (int)(leftRect+stringSpace*pos.getString()-stringSpace/2) ,
                    (int)(topRect+fretSpace*(pos.getFret()-startFret)-fretSpace)  ,
                    (int)(stringSpace)  ,
                    (int)(fretSpace)
                );
            } else {
                graphics.setColor(new Color(00,00,00));
                    graphics.drawOval(
                    (int)(leftRect+stringSpace*pos.getString()-stringSpace/2) ,
                    //(int)(topRect+fretSpace*pos.getFret())  ,
                    (int)(topRect-fretSpace)  ,
                    (int)(stringSpace)  ,
                    (int)(fretSpace)
                );
            }
            
        }
        if (startFret!=0)
            graphics.drawString(new Integer(startFret+1).toString(),(int)(leftRect+stringSpace*(numString-.6)),(int)(leftRect+fretSpace));
        
    }
    
    
    /*
    public void paintComponent(Graphics g) {
     
    }
     */
    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */
}
