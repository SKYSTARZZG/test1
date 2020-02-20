package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 字符串加解密 {
    public static void main(String[] args) {
        Scanner  in = new Scanner(System.in);
        while(in.hasNextLine()){
            String str1=in.nextLine();
            String str2=in.nextLine();
            String encryptStr1=encrypt(str1);
            String decryptStr2=decrypt(str2);
            System.out.println(encryptStr1);
            System.out.println(decryptStr2);
        }
    }

    private static String decrypt(String str) {
        int len= str.length();
        StringBuffer buf=new StringBuffer();
        for(int i=0;i<len;i++) {
            char c = str.charAt(i);
            char decryptC = decryptChar(c);
            buf.append(decryptC);
        }
        return buf.toString();
    }

    private static char decryptChar(char c) {
        int dif='a'-'A';
        char decryptC=' ';
        if(c>'a'&&c<='z'){
            decryptC=(char)(c-1-dif);
        }else if(c=='a'){
            decryptC='Z';
        }else if(c>'A'&&c<='Z'){
            decryptC=(char)(c-1+dif);
        }else if(c=='A'){
            decryptC='z';
        }else if(c>'0'&&c<='9'){
            decryptC-=1;
        }else{
            decryptC='9';
        }
        return decryptC;
    }

    private static String encrypt(String str) {
        int len= str.length();
        StringBuffer buf=new StringBuffer();
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            char encryptC=encryptChar(c);
            buf.append(encryptC);
        }
        return buf.toString();
    }

    private static char encryptChar(char c) {
        int dif='a'-'A';
        char encryptC=' ';
        if(c>='a'&&c<'z'){
            encryptC=(char)(c+1-dif);
        }else if(c=='z'){
            encryptC='A';
        }else if(c>='A'&&c<'Z'){
            encryptC=(char)(c+1+dif);
        }else if(c=='Z'){
            encryptC='a';
        }else if(c>='0'&&c<'9'){
            encryptC=(char)(c+1);
        }else{
            encryptC='0';
        }
        return encryptC;
    }
}
