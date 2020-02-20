package huaweijishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 截取包含汉字的字符串 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.next();
            int len=in.nextInt();
            String sub=getSubStr(str,len);
            System.out.println(sub);
        }
    }

    private static String getSubStr(String str, int len) {
        StringBuffer buf=new StringBuffer();
        int resultLen=0;
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            if(c>='a'&&c<='z' || c>='A'&&c<='Z'){
                resultLen++;
            }else{
                resultLen+=2;
            }
            if(resultLen<=len)buf.append(c);
        }
        return buf.toString();
    }

    private static int getHalfHanNum(String str, int len) {
        int result=0;
        for(int i=len-1;i>=0;i--){
            char c=str.charAt(i);
            if(c>='a'&&c<='z'||c>='A'&&c<='Z'){
                break;
            }else{
                result++;
            }
        }
        return result;
    }


}
