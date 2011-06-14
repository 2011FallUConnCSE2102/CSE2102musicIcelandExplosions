/*
 * ChordList.java
 *
 * Created on 20 maggio 2004, 17.25
 */

package it.denzosoft.mobile.chordFinder;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


class ChordList extends List implements
CommandListener {
    
    private int mode;
//    private Command exitCommand = new Command( "Exit",Command.SCREEN, 2 );
    private Command selectCommand = new Command( "Select",Command.OK, 1 );
//    private Command nextCommand = new Command( "Next",Command.SCREEN, 2 );
    private Display display;
    public static final String[] items = {
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
    
    ChordList( int mode ){
        super( "", mode, items, null );
        display=DenzoChordFinder.finder.display;
//        addCommand( exitCommand );
        addCommand( selectCommand );
//        addCommand( nextCommand );
        setCommandListener( this );
        
        switch( mode ){
            case IMPLICIT:
                setTitle( "Implicit" );
                break;
            case EXCLUSIVE:
                setTitle( "Exclusive" );
                break;
            case MULTIPLE:
                setTitle( "Multiple" );
                break;
        }
        
        this.mode = mode;
    }
    
    public void commandAction( Command c,
    Displayable d ){
//        if( c == exitCommand ){
//            exitMIDlet();
//        } else 
        if( c == selectCommand ){
//            showSelection( false );
            int sel=getSelectedIndex();
            display.setCurrent( DenzoChordFinder.finder.canvas ); 
        } else if( c == SELECT_COMMAND ){
//            showSelection( true );
            int sel=getSelectedIndex();
            DenzoChordFinder.finder.chordFormula=chordFormulas[sel];
            DenzoChordFinder.finder.chordName=items[sel];
            DenzoChordFinder.finder.changeRoot();
            display.setCurrent( DenzoChordFinder.finder.canvas );        
        } 
//        else if( c == nextCommand ){
//            if( mode == List.IMPLICIT ){
//                mode = List.EXCLUSIVE;
//            } else if( mode == List.EXCLUSIVE ){
//                mode = List.MULTIPLE;
//            } else {
//                mode = List.IMPLICIT;
//            }
            
//            display.setCurrent( new ChordList( List.IMPLICIT ) );
//         }
    }
    
    private void showSelection( boolean implicit ){
//        Alert alert = new Alert(
//        implicit ? "Implicit Selection"
//        : "Explicit Selection" );
//        StringBuffer buf = new StringBuffer();
//        
//        if( mode == MULTIPLE ){
//            boolean[] selected = new boolean[ size() ];
//            getSelectedFlags( selected );
//            
//            for( int i = 0; i < selected.length; ++i ){
//                if( selected[i] ){
//                    if( buf.length() == 0 ){
//                        buf.append(
//                        "You selected: " );
//                    } else {
//                        buf.append( ", " );
//                    }
//                    
//                    buf.append( getString( i ) );
//                }
//            }
//            
//            if( buf.length() == 0 ){
//                buf.append( "No items are selected." );
//            }
//        } else {
//            buf.append( "You selected " );
//            buf.append( getString(
//            getSelectedIndex() ) );
//        }
//        
//        alert.setString( buf.toString() );
//        alert.setTimeout( Alert.FOREVER );
        
        display.setCurrent( DenzoChordFinder.finder.canvas );
    }
}
