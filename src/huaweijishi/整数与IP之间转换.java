package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 整数与IP之间转换 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            String ip=str;
            String longIpStr=br.readLine();
            String[] strs=ip.split("\\.");
            StringBuffer buf=new StringBuffer();
            for (String string : strs) {
                int num= Integer.parseInt(string);
                String binaryStr=Integer.toBinaryString(num);
                int len1=binaryStr.length();
                if(len1<8){
                    binaryStr=("0000000"+binaryStr).substring(len1-1);
                }
                buf.append(binaryStr);
            }
            Long result1=Long.parseLong(buf.toString(),2);
            System.out.println(result1);
            Long longIp=Long.parseLong(longIpStr);
            String binaryIp=Long.toBinaryString(longIp);
            int len2=binaryIp.length();
            if(len2<32){
                binaryIp=("00000000"+binaryIp).substring(len2-24);
            }
            StringBuffer buf2=new StringBuffer();
            while (binaryIp.length()>0){
                String sub=binaryIp.substring(0,8);
                binaryIp=binaryIp.substring(8);
                int num=Integer.parseInt(sub,2);
                if(binaryIp.length()==0){
                    buf2.append(num);
                }else{
                    buf2.append(num+ "");
                }
            }
            String result2=buf2.toString();
            System.out.println(result2);
        }
    }
}
