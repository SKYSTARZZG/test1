package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 密码验证 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String result = check(str);
            System.out.println(result);
        }
    }

    private static String check(String str) {

        int[] arr={0,0,0,0};
        int len=str.length();
        if(len<9)return "NG";
        for(int i=0;i<len;i++){
            char c=str.charAt(i);
            if(c>='0'&&c<='9'){
                arr[0]=1;
            }else if(c>='a'&&c<='z'){
                arr[1]=1;
            }else if(c>='A'&&c<='Z'){
                arr[2]=1;
            }else{
                arr[3]=1;
            }
        }
        if(arr[0]+arr[1]+arr[2]+arr[3]<3){
            return "NG";
        }
        for(int i=0;i<len-3;i++){
            String sub1=str.substring(i,i+3);
            String sub2=str.substring(i+3);
            if(sub2.contains(sub1)){
                return "NG";
            }
        }
        return "OK";
    }

}
