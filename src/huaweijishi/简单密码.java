package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 简单密码 {
    public static void main(String[] args) throws IOException {
        Map<Character,Integer> map=new HashMap<>();
        init(map);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            String password=decrypt(str,map);
            System.out.println(password);
        }
    }
    private static void init(Map<Character, Integer> map) {
        map.put('a',2);map.put('b',2);map.put('c',2);
        map.put('d',3);map.put('e',3);map.put('f',3);
        map.put('g',4);map.put('h',4);map.put('i',4);
        map.put('j',5);map.put('k',5);map.put('l',5);
        map.put('m',6);map.put('n',6);map.put('o',6);
        map.put('p',7);map.put('q',7);map.put('r',7);map.put('s',7);
        map.put('t',8);map.put('u',8);map.put('v',8);
        map.put('w',9);map.put('x',9);map.put('y',9);map.put('z',9);
    }

    private static String decrypt(String str,Map<Character,Integer> map) {
        int len=str.length();
        StringBuffer buf=new StringBuffer();
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            if(c>='A'&&c<'Z'){
                c+=1;
                buf.append((c+"").toLowerCase());
            }else if(c=='Z'){
                buf.append('a');
            }else if(c>='a'&&c<='z'){
                buf.append(map.get(c));
            }else{
                buf.append(c);
            }
        }
        return buf.toString();
    }
}
