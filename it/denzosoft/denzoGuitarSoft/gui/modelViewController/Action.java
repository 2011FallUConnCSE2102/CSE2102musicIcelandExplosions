/*
 * Action.java
 *
 * Created on 30 maggio 2002, 14.24
 */

package it.denzosoft.denzoGuitarSoft.gui.modelViewController;

import it.denzosoft.denzoGuitarSoft.util.*;
/**
 *
 * @author  De Sanctis
 * @version 
 */
public class Action implements Actionable{
    
    String lName="";
    Properties lParameters;
    
    public Action() {}
    
    public Action(String name) {
        lName=name;
    }

    public Action(String name, Properties parameters) {
        lName=name;
        lParameters=parameters;
    }

    public String getName() {
        return lName;
    }
    
    public Properties getParameters() {
        return lParameters;
    }
    
    public void setParameters(Properties parameters) {
        lParameters=parameters;
    }    

    /*
     public static void main(String args[]) {
        Class tmp=new Class();
        System.out.println("Hello!");
     }
     */    
}
