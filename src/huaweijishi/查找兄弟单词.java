package huaweijishi;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 查找兄弟单词 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int dictLen=in.nextInt();
            List<String> dict=new ArrayList<>();
            for(int i=0;i<dictLen;i++){
                String str=in.next();
                dict.add(str);
            }
            String word=in.next();
            int num=in.nextInt();
            List<String> brothers=getBrotherList(dict,word);
            Collections.sort(brothers);
            System.out.println(brothers.size());
            if(brothers.size()>=num) {
                System.out.println(brothers.get(num - 1));
            }
        }
    }
    private static List<String> getBrotherList(List<String> dict, String word) {
        List<String> brothers=new ArrayList<>();
        for (String str: dict) {
            boolean flag=checkBrother(str,word);
            if(flag)brothers.add(str);
        }
        return brothers;
    }

    private static boolean checkBrother(String str, String word) {
        if(str.length()!=word.length())return false;
        if(str.equals(word)) return false;
        char[] c1=str.toCharArray();
        char[] c2=word.toCharArray();
        Arrays.sort(c1);Arrays.sort(c2);
        str=String.copyValueOf(c1);
        word=String.copyValueOf(c2);
        if(str.equals(word)){
            return true;
        }
        return false;
    }
}
