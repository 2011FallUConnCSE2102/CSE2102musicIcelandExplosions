/*
 * ChordList.java
 *
 * Created on 20 maggio 2004, 17.25
 */

package it.denzosoft.mobile.chordFinder;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;


class TuningList extends List implements CommandListener {
    
    private int mode;
//    private Command exitCommand = new Command( "Exit",Command.SCREEN, 2 );
    private Command selectCommand = new Command( "Select",Command.OK, 1 );
//    private Command nextCommand = new Command( "Next",Command.SCREEN, 2 );
    private Display display;
    public static final String[] items = Tuning.tuningNameList;
        
    TuningList(int mode){
        super( "", mode, items, null );
        display=DenzoChordFinder.finder.display;
//        addCommand( exitCommand );
        addCommand( selectCommand );
//        addCommand( nextCommand );
        setCommandListener( this );
        
//        switch( mode ){
//            case IMPLICIT:
//                setTitle( "Implicit" );
//                break;
//            case EXCLUSIVE:
//                setTitle( "Exclusive" );
//                break;
//            case MULTIPLE:
//                setTitle( "Multiple" );
//                break;
//        }
        
        this.mode = mode;
    }
    
    public void commandAction( Command c, Displayable d ){
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
            DenzoChordFinder.finder.tuning=new Tuning(sel);
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
