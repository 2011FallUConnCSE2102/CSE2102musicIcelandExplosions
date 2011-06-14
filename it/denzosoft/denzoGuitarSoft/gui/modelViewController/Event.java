/*
 * Event.java
 *
 * Created on 30 maggio 2002, 14.23
 */

package it.denzosoft.denzoGuitarSoft.gui.modelViewController;

import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Event implements Eventable {

    Properties lParameters;
    String lName="";
    /** Creates new Event */
    public Event() {
    }

    public Event(String name) {
        lName=name;
    }

    public Event(String name,Properties parameters) {
        lName=name;
        lParameters=parameters;
    }
    
    public void setParameters(Properties parameters) {
        lParameters=parameters;
    }

    public Properties getParameters() {
        return lParameters;
    }
    
    public String getName() {
        return lName;
    }    
   
/*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */    
}
