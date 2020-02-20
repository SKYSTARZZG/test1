package huaweijishi;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 最长连续数字串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str=in.nextLine();
            char[] arr=str.toCharArray();
            int len=arr.length;
            Map<String,Integer> map=new LinkedHashMap<>();
            StringBuffer buf=new StringBuffer();
            int max=0;
            for(int i=0;i<len;i++){
                if(arr[i]>='0'&&arr[i]<='9'){
                    buf.append(arr[i]);
                }else{
                    int bufLen=buf.length();
                    if(bufLen>0){
                        max=Math.max(bufLen,max);
                        map.put(buf.toString(),bufLen);
                    }
                    buf.delete(0,bufLen);
                }
            }
            int bufLen=buf.length();
            if(bufLen>0){
                max=Math.max(bufLen,max);
                map.put(buf.toString(),bufLen);
            }
            for (String subStr : map.keySet()) {
                if(map.get(subStr)==max){
                    System.out.print(subStr);
                }
            }
            System.out.println(","+max);
        }
    }
}
