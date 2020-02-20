package huaweijishi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 字符串排序 {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      while(in.hasNextLine()){
          String str=in.nextLine();
          char[] charArr=str.toCharArray();
          int len=charArr.length;
          List<CharPosition> lowers=new ArrayList<>();
          List<CharPosition> uppers=new ArrayList<>();
          Map<Integer,CharPosition> others=new HashMap<>();
          for(int i=0;i<len;i++){
              char c=charArr[i];
              CharPosition cp=new CharPosition(i,c);
              if(c>='a'&&c<='z'){
                  lowers.add(cp);
              }else if(c>='A'&&c<='Z'){
                  uppers.add(cp);
              }else {
                  others.put(i,cp);
              }
          }
          int dif='a'-'A';
          int p1=0,p2=0,index=0;
          int lenLower=lowers.size(),lenUpper=uppers.size();
          lowers=sortList(lowers);
          uppers=sortList(uppers);
          StringBuffer buf=new StringBuffer();
           while(p1<lenLower&&p2<lenUpper){
               index=check(index,others,buf);
               CharPosition cp1=lowers.get(p1);
               CharPosition cp2=uppers.get(p2);
               int dif2=cp1.c-cp2.c;
               if(dif2==dif){
                   if(cp1.index>cp2.index){
                       buf.append(cp2.c);index++;p2++;
                   }else{
                       buf.append(cp1.c);index++;p1++;
                   }
               }else if(dif2>dif){
                   buf.append(cp2.c);index++;p2++;
               }else{
                   buf.append(cp1.c);index++;p1++;
               }
          }
          while(p1<lenLower){
              index=check(index,others,buf);
              CharPosition cp1=lowers.get(p1);
              buf.append(cp1.c);index++;p1++;
          }
          while(p2<lenUpper){
              index=check(index,others,buf);
              CharPosition cp2=uppers.get(p2);
              buf.append(cp2.c);index++;p2++;
          }
          check(index,others,buf);
          System.out.println(buf.toString());
      }
    }

    private static List<CharPosition> sortList(List<CharPosition> list) {
        list=list.stream().sorted(
                Comparator.comparing(CharPosition::getC).thenComparing(CharPosition::getIndex)
             ).collect(Collectors.toList());
        return list;
    }

    private static int check(int index, Map<Integer, CharPosition> others,StringBuffer buf) {
        while(others.containsKey(index)){
            buf.append(others.get(index++).c);
        }
        return index;
    }
}
class CharPosition{
    char c;
    int index;

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public CharPosition(int index, char c) {
        this.c = c;
        this.index = index;
    }

    @Override
    public String toString() {
        return "["+index+" "+c+"]";
    }
}
