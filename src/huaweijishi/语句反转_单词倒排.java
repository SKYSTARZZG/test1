package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 语句反转_单词倒排 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            List<String> list=formatStr(str);
            int len=list.size();
            for(int i=len-1;i>=0;i--){
                if(i==0){
                    System.out.print(list.get(i));
                }else {
                    System.out.print(list.get(i) + " ");
                }
            }
        }
    }

    private static List<String> formatStr(String str) {
        List<String> list=new ArrayList<>();
        while(str.length()>0){
            char c=str.charAt(0);
            boolean isChar= c>='a'&&c<='z'||c>='A'&&c<='Z';
            if(isChar){
                int lenChar=getlenChar(str);
                String subStr=str.substring(0,lenChar);
                list.add(subStr);
                str=str.substring(lenChar);
            }else{
                int lenNoChar=getLenNoChar(str);
                str=str.substring(lenNoChar);
            }
        }
        return list;
    }

    private static int getLenNoChar(String str) {
        int len=str.length();
        int result=0;
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            boolean isChar= c>='a'&&c<='z'||c>='A'&&c<='Z';
            if(isChar){
                break;
            }else{
                result++;
            }
        }
        return result;
    }

    private static int getlenChar(String str) {
        int len=str.length();
        int result=0;
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            boolean isChar= c>='a'&&c<='z'||c>='A'&&c<='Z';
            if(isChar){
                result++;
            }else{
                break;
            }
        }
        return result;
    }
}
