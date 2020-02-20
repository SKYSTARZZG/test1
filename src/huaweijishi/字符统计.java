package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 字符统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            //英文字符，空格字符，数字字符，其他字符
            int  enCount=0,spaceCount=0,numCount=0,otherCount=0;
            int len=str.length();
            for(int i=0;i<len;i++){
                char c=str.charAt(i);
                if(c>='a'&&c<='z' || c>='A'&&c<='Z'){
                    enCount++;
                }else if(c>='0'&&c<='9'){
                     numCount++;
                }else if(c==' '){
                    spaceCount++;
                }else {
                    otherCount++;
                }
            }
            System.out.println(enCount);
            System.out.println(spaceCount);
            System.out.println(numCount);
            System.out.println(otherCount);
        }
    }
}
