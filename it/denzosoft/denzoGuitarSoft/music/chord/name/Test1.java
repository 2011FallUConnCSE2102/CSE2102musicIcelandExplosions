package it.denzosoft.denzoGuitarSoft.music.chord.name;

import java.util.StringTokenizer;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Test1 {

   public static String chordListArr[] = {
      "major\t major\t 1\t 3\t 5", "5\t     5th\t 1\t 5", "6\t     major 6th\t 1\t 3\t 5\t 6", "6/9\t   major 6th add 9th\t 1\t 3\t 5\t 6\t 9", "7\t     7th\t 1\t 3\t 5\t b7", "7sus\t  7th suspended\t 1\t 4\t 5\t b7", "7+5\t   augmented 7th\t 1\t 3\t #5\t b7", "7-5\t   7th diminished 5th\t 1\t 3\t b5\t b7", "7/6\t   7th add 6th\t 1\t 3\t 5\t 6\t b7", "7-9\t   7th minor 9th\t 1\t 3\t 5\t b7\t b9",
      "7+9\t   7th augmented 9th\t 1\t 3\t 5\t b7\t #9", "7/13\t  7th add 13th\t 1\t 3\t 5\t b7\t 13", "9\t     9th\t 1\t 3\t 5\t b7\t 9", "9-5\t   9th minor 5th\t 1\t 3\t b5\t b7\t 9", "9+5\t   9th augmented 5th\t 1\t 3\t #5\t b7\t 9", "9/6\t   9th added 6th\t 1\t 3\t 5\t 6\t b7\t 9", "9+11\t  9th augmented 11th\t 1\t 3\t 5\t b7\t 9\t #11", "11\t    11th\t 1\t 3\t 5\t b7\t 9\t 11", "11-9\t  11th minor 9th\t 1\t 3\t 5\t b7\t b9\t 11", "11#7\t  11th sharp 7th\t 1\t 3\t 5\t 7\t 9\t 11",
      "13\t    13th\t 1\t 3\t 5\t b7\t 9\t 13", "dim\t   diminished\t 1\t b3\t b5", "dim7\t  diminished 7th\t 1\t b3\t b5\t 6", "m\t     minor\t 1\t b3\t 5", "m-5\t   minor 5th\t 1\t b3\t b5", "m6\t    minor 6th\t 1\t b3\t 5\t 6", "m6/9\t  minor 6th add 9th\t 1\t b3\t 5\t 6\t 9", "m7\t    minor 7th\t 1\t b3\t 5\t b7", "m7-5\t  minor 7th diminished 5th\t 1\t b3\t b5\t b7", "m7+5\t  minor 7th augmented 5th\t 1\t b3\t #5\t b7",
      "m7-9\t  minor 7th minor 9th\t 1\t b3\t 5\t b7\t b9", "m#7\t   minor sharp 7th\t 1\t b3\t 5\t 7", "m#7-5\t minor sharp 7th diminished 5th\t 1\t b3\t b5\t 7", "m#7+5\t minor sharp 7th augmented 5th\t 1\t b3\t #5\t 7", "m#7-9\t minor sharp 7th minor 9th\t 1\t b3\t 5\t 7\t b9", "m9\t    minor 9th\t 1\t b3\t 5\t b7\t 9", "madd9\t minor add 9th\t 1\t b3\t 5\t 9", "m#9\t   minor sharp 9th\t 1\t b3\t 5\t 7\t 9", "m9#7\t  minor 9th sharp 7th\t 1\t b3\t 5\t 7\t 9", "m11\t   minor 11th\t 1\t b3\t 5\t b7\t 9\t 11",
      "maug11\t  minor augmented 11th\t 1\t b3\t 5\t b7\t 9\t #11", "m13\t     minor 13th\t 1\t b3\t 5\t b7\t 9\t 13", "maj7\t    major 7th\t 1\t 3\t 5\t 7", "maj7-5\t  major 7th diminished 5th\t 1\t 3\t b5\t 7", "maj7+5\t  major 7th augmented 5th\t 1\t 3\t #5\t 7", "maj7sus\t major 7th suspended\t 1\t 4\t 5\t 7", "maj7-9\t  major 7th minor 9th\t 1\t 3\t 5\t 7\t b9", "maj7+9\t  major 7th augmented 9th\t 1\t 3\t 5\t 7\t #9", "maj9\t    major 9th\t 1\t 3\t 5\t 7\t 9", "maj9sus\t major 9h suspended\t 1\t 4\t 5\t 7\t 9",
      "maj11\t   major 11th\t 1\t 3\t 5\t 7\t 9\t 11", "maj13\t   major 13th\t 1\t 3\t 5\t 7\t 9\t 13", "add9\t    dominant\t 1\t 3\t 5\t 9\t", "sus2\t major suspended 2nd\t 1\t 2\t 5", "sus4\t major suspended 4th\t 1\t 4\t 5", "+\t    augmented (5th)\t 1\t 3\t #5", "+9\t   augmented 9th\t 1\t 3\t 5\t b7\t #9", "+11\t  augmented 11th\t 1\t 3\t 5\t b7\t 9\t #11", "-5\t   major diminished 5th\t 1\t 3\t b5", "-9\t   lowered 9th\t 1\t 3\t 5\t b7\t b9",
      "-9+5\t lowered 9th augmented 5th\t 1\t 3\t #5\t b7\t b9", "-9-5\t lowered 9th minor 5th\t 1\t 3\t b5\t b7\t b9", "-9+11\t lowered 9th augmented 11th\t 1\t 3\t 5\t b7\t b9\t 11", "-13\t   lowered 13th\t 1\t 3\t 5\t b7\t 9\t b13"
  };

  public static int[] degree={0,2,4,5,7,9,11,0,2,4,5,7,9,11};
  public Test1() {
  }
  public static void main(String[] args) {
    Test1 test11 = new Test1();
    String nameArr="";
    String formulaArr="";
    for(int i=0;i<chordListArr.length;i++) {
      String name=chordListArr[i].substring(0,chordListArr[i].indexOf('\t'));
      //String name2=chordListArr[i].substring(0,chordListArr[i].indexOf('\t'));
      System.out.println(name);
      nameArr=nameArr+"\""+name+"\",";
      String formula=chordListArr[i].substring(chordListArr[i].indexOf('\t')+1);
      formula=formula.substring(formula.indexOf('\t')+1);
      formula=formula.replace('\t',' ').trim();
      //System.out.println(formula);
      StringTokenizer st=new StringTokenizer(formula);
      String retVal="";
      while (st.hasMoreTokens()) {
        String item=st.nextToken();
        int alt=0;
        int val=0;
        if (item.indexOf("#")>-1) {
          alt=+1;
          val=Integer.parseInt(item.substring(1));
        }
        if (item.indexOf("b")>-1) {
          alt=-1;
          val=Integer.parseInt(item.substring(1));
        }
        if ((item.indexOf("#")==-1) && (item.indexOf("b")==-1)) {
          val=Integer.parseInt(item);
        }
        retVal=retVal+new Integer(degree[val-1]+alt).toString()+" ";
      }
    System.out.println(retVal);
    formulaArr=formulaArr+"\""+retVal+"\",";
    }
    System.out.println(nameArr);
    System.out.println(formulaArr);

  }
}