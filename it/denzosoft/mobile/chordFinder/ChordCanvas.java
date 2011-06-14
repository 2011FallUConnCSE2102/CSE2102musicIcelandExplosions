/*
 * ChordCanvas.java
 *
 * Created on 20 maggio 2004, 14.59
 */

package it.denzosoft.mobile.chordFinder;

import javax.microedition.lcdui.*;
/**
 *
 * @author  De Sanctis
 */
public class ChordCanvas extends Canvas{
    
    private GuitarPositions cp=null;
    /** Creates a new instance of ChordCanvas */
    public ChordCanvas() {
    }
    
    public ChordCanvas(GuitarPositions cp) {
        this.cp=cp;
        //        cp=new GuitarPositions("X 3 2 0 0 0");
        //        Tuning tuning=new Tuning();
        //        cp.setTuning(tuning);
        //
        //        cp.setProperty("Root",new Integer(0));
        
    }
    
    public void setGuitarPosition(GuitarPositions cp) {
        this.cp=cp;
    }
    
    protected void getImage(GuitarPositions positions, Graphics graphics, int top, int left, int width, int height) {
        try {
            //int[] pix=new int[width*height];
            //Image img=createImage(new MemoryImageSource(width,height,pix,0,width));
            //Image img=createImage(width,height);
            //Graphics g=img.getGraphics();
            //return img;
            Tuning tuning=positions.getTuning();
            int topRect=top+height/6;
            int leftRect=left+width/6;
            int widthRect=(width*2)/3;
            int heightRect=(height*2)/3;
            
            //        graphics.clearRect(top, left, width,  height);
            int color=graphics.getColor();
            
            graphics.setColor(255,255,255);
            graphics.fillRect(top, left, width,  height);
            graphics.setColor(color);
            
            int numNote=positions.size();
            int numString=tuning.getStringNumber();
            int root=-1;
            if(positions.getProperty("Root")!=null)
                root=((Integer)positions.getProperty("Root")).intValue();
            GuitarPosition pos;
            int minFret=50;
            int maxFret=-1;
            for(int i=0;i<numNote;i++) {
                //pos=(Position)positions.get(i);
                if (((GuitarPosition)positions.get(i)).getFret()!=0) {
                    minFret=Math.min(minFret,((GuitarPosition)positions.get(i)).getFret());
                    maxFret=Math.max(maxFret,((GuitarPosition)positions.get(i)).getFret());
                }
            }
            int numFret=maxFret-minFret+1;
            if (numFret<4)
                numFret=4;
            int fretSpace=heightRect/numFret;
            int stringSpace=widthRect/(numString-1);
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
                pos=(GuitarPosition)positions.get(i);
                if (pos.getFret()!=0) {
                    if((tuning.getPitch(pos.getString(),pos.getFret())%12)==root)
                        graphics.setColor(230,230,230);
                    graphics.fillArc(
                    leftRect+stringSpace*pos.getString()-stringSpace/2 ,
                    topRect+fretSpace*(pos.getFret()-startFret)-fretSpace  ,
                    (stringSpace*11)/10  ,
                    (fretSpace*11)/10,
                    0,360
                    );
                    graphics.setColor(0,0,0);
                    graphics.drawArc(
                    leftRect+stringSpace*pos.getString()-stringSpace/2 ,
                    topRect+fretSpace*(pos.getFret()-startFret)-fretSpace  ,
                    stringSpace  ,
                    fretSpace,
                    0,
                    360
                    );
                } else {
                    graphics.setColor(0,0,0);
                    graphics.drawArc(
                    (int)(leftRect+stringSpace*pos.getString()-stringSpace/2) ,
                    //(int)(topRect+fretSpace*pos.getFret())  ,
                    (int)(topRect-fretSpace)  ,
                    (int)(stringSpace)  ,
                    (int)(fretSpace),
                    0,360
                    );
                }
                
            }
            if (startFret!=0)
                graphics.drawString(new Integer(startFret+1).toString(),(int)(leftRect+stringSpace*(numString-5/10)),(int)(leftRect+fretSpace), Graphics.HCENTER | Graphics.BOTTOM);
            graphics.drawString(DenzoChordFinder.finder.last+" "+ItalianNoteName.getName(DenzoChordFinder.finder.root)+" "+DenzoChordFinder.finder.chordName,(int)(leftRect+fretSpace),(int)(leftRect+fretSpace*6), Graphics.HCENTER | Graphics.BOTTOM);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    protected void keyPressed(int i1) {
        int command = getGameAction(i1);
        //System.out.println(j1);
        if (command==5)
            DenzoChordFinder.finder.drawNext();
        if (command==1) {
            DenzoChordFinder.finder.root=(DenzoChordFinder.finder.root+1)%12;
            DenzoChordFinder.finder.changeRoot();
        }
        if (command==6) {
            DenzoChordFinder.finder.root=(DenzoChordFinder.finder.root+11)%12;
            DenzoChordFinder.finder.changeRoot();
        }
        if (command==2)
            DenzoChordFinder.finder.drawPrev();
    }
    
    protected void paint(javax.microedition.lcdui.Graphics graphics) {
        //ChordImage ci=new ChordImage();
        if (cp!=null)
            getImage(cp,graphics,0,0,getWidth(),getHeight());
        
    }
    
}
