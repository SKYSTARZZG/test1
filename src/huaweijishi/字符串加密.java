package huaweijishi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0b
 */
public class 字符串加密 {
    private static  final String words="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static  final int dif='a'-'A';
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while (in.hasNext()){
            String secretKey=in.nextLine();
            String str=in.nextLine();
            String valueStr=getValueStr(secretKey);
            int len=words.length();
            Map<Character,Character> map=new HashMap<>();
            for(int i=0;i<len;i++){
                map.put(words.charAt(i),valueStr.charAt(i));
            }
            String result=encrypt(str,map);
            System.out.println(result);
        }
    }

    private static String encrypt(String str, Map<Character, Character> map) {
        StringBuffer buf=new StringBuffer();
        int len=str.length();
        char[] charArr=str.toCharArray();
        for (char c : charArr) {
            if(c>='a'&&c<='z'){
                c=(char)(c-dif);
                char value=(char)(map.get(c)+dif);
                buf.append(value);
            }else if(c>='A'&&c<='Z'){
                buf.append(map.get(c));
            }else{
                buf.append(c);
            }
        }
        return buf.toString();
    }

    private static String getValueStr(String secretKey) {
        String str=secretKey.toUpperCase()+words;
        Set<Character> set=new LinkedHashSet<>();
        char[] charArr=str.toCharArray();
        for (char c : charArr) {
            set.add(c);
        }
        StringBuffer buf=new StringBuffer();
        for (Character c : set) {
            buf.append(c);
        }
        return buf.toString();
    }
}
