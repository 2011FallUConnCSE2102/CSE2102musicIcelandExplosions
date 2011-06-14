/*
 * ChordPrinter.java
 *
 * Created on 31 maggio 2002, 11.20
 */

package it.denzosoft.denzoGuitarSoft.gui.graphic.chord;

import it.denzosoft.denzoGuitarSoft.guitar.position.*;
import java.awt.*;
/**
 *
 * @author  De Sanctis
 * @version
 */
public interface ChordPrinter extends it.denzosoft.denzoGuitarSoft.gui.graphic.GraphicCreator {
    public void getImage(Positions positions,Graphics graphics,int top, int left,int width, int height);
}

