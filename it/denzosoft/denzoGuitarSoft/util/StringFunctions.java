/*
 * StringFunctions.java
 *
 * Created on 24 maggio 2002, 10.50
 */

package it.denzosoft.denzoGuitarSoft.util;

import java.util.*;

/**
 *
 * @author  De Sanctis
 * @version 
 */
public class StringFunctions {

    /** Creates new StringFunctions */
    private StringFunctions() {
    }

    public static String[] split(String string) {
        StringTokenizer st = new StringTokenizer(string);
        int i=st.countTokens();
        String[] retVal=new String[i];
        for(int n=0; n<i; n++)
            retVal[n]=st.nextToken();
        return retVal;
    }
    
     public static void main(String args[]) {
        
        String[] pippo=split("a vb de##ffrt # s ## h");
        System.out.println(pippo[0]);
        System.out.println(pippo[1]);
        System.out.println(pippo[2]);
        System.out.println(pippo[3]);
     }
    
}
