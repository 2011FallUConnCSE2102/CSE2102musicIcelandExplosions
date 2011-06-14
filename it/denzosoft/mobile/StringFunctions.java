/*
 * StringFunctions.java
 *
 * Created on 24 maggio 2002, 10.50
 */

package it.denzosoft.mobile;

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

//    public static String[] split(String string) {
//        StringTokenizer st = new StringTokenizer(string);
//        int i=st.countTokens();
//        String[] retVal=new String[i];
//        for(int n=0; n<i; n++)
//            retVal[n]=st.nextToken();
//        return retVal;
//    }
    
    public static String[] split(String string) {
        String strToSplit = string;
        // String strToSplit = null;
        // String separator = "__";
        String separator = " ";
        int i = 0;
        int count = 1;
        int j = 0;
        boolean b = true;
        String[] array = null;
        
        while (b) {
            
            if (strToSplit.indexOf(separator, i) >= 0) {
                count = count + 1;
                i = strToSplit.indexOf(separator, i) + separator.length();
                if ( i == strToSplit.length() ) {
                    count = count - 1;
                    b = false;
                }
            } else
                b = false;
        }
        
        array = new String[count];
        
        i = 0;
        j = 0;
        b = true;
        while (b) {
            if (strToSplit.indexOf(separator, i) >= 0) {
                array[j] = strToSplit.substring(i, strToSplit.indexOf(separator, i));
                j = j + 1;
                i = strToSplit.indexOf(separator, i) + separator.length();
                if ( i == strToSplit.length() ) {
                    count = count - 1;
                    b = false;
                }
            } else {
                array[j] = strToSplit.substring(i, strToSplit.length());
                b = false;
            }
        }
        
//        j = 0;
//        while (j < count) {
//            System.out.println(array[j]);
//            j = j + 1;
//        }
        
        return array;
    }
        
     public static void main(String args[]) {
        
        String[] pippo=split("a vb de##ffrt # s ## h");
        System.out.println(pippo[0]);
        System.out.println(pippo[1]);
        System.out.println(pippo[2]);
        System.out.println(pippo[3]);
     }
    
}
