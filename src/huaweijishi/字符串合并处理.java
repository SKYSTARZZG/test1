package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 字符串合并处理 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String str1=in.next();
            String str2=in.next();
            String str=str1+str2;
            StringBuffer buf0=new StringBuffer();
            StringBuffer buf1=new StringBuffer();
            int len=str.length();
            for(int i=0;i<len;i++){
                if(i%2==0){
                    buf0.append(str.charAt(i));
                }else{
                    buf1.append(str.charAt(i));
                }
            }
            char[] chars0=buf0.toString().toCharArray();
            char[] chars1=buf1.toString().toCharArray();
            Arrays.sort(chars0); Arrays.sort(chars1);
            char[] sortedChars=new char[len];
            for(int i=0;i<len;i++){
                if(i%2==0){
                    sortedChars[i]=chars0[i/2];
                }else{
                    sortedChars[i]=chars1[i/2];
                }
            }
            StringBuffer resultBuf=new StringBuffer();
            for (char c : sortedChars) {
                if(c>='A'&&c<='F'||c>='a'&&c<='f'||c>='0'&&c<='9'){
                    resultBuf.append(handleChar(c));
                }else{
                    resultBuf.append(c);
                }

            }
            System.out.println(resultBuf);
        }
    }
    private static String handleChar(char c) {
        if(c>='A'&&c<='Z'){
            c=(char)(c+'a'-'A');
        }
        int num=Integer.parseInt(c+"",16);
        String binaryStr=Integer.toBinaryString(num);
        int len=binaryStr.length();
        if(len<4){
            binaryStr=("000"+binaryStr).substring(len-1);
        }
        StringBuffer buf=new StringBuffer(binaryStr);
        String reverseStr=buf.reverse().toString();
        int num2=Integer.parseInt(reverseStr,2);
        String hexStr=Integer.toHexString(num2);
        if(num2>=10){
            hexStr=hexStr.toUpperCase();
        }
        return hexStr;
    }
}
