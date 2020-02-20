package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 密码截取_获取最长对称字符串 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null) {
            int len=str.length();
            char[] arr=str.toCharArray();
            boolean[][] dp=new boolean[len][len];
            int max=0;
            for(int j=0;j<len;j++){
                for(int i=0;i<=j;i++){
                    if(j-i<2){
                        dp[i][j]=arr[i]==arr[j];
                    }else{
                        dp[i][j]=dp[i+1][j-1]&&(arr[i]==arr[j]);
                    }
                    if(dp[i][j]&&max<j-i+1){
                        max=j-i+1;
                    }
                }
            }
            System.out.println(max);
        }
    }
}
