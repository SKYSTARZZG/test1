package huaweijishi;

import java.io.IOException;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 密码回文 {
    public static void main(String[] args) throws IOException {
       Scanner in=new Scanner(System.in);
       while(in.hasNext()){
           String str=in.next();
           char[] arr=str.toCharArray();
           int len=arr.length;
           boolean[][] dp=new boolean[len][len];
           int max=0;
           for(int j=0;j<len;j++){
               for(int i=0;i<=j;i++){
                   if(j-i<2){
                       dp[i][j]=arr[i]==arr[j];
                   }else{
                       dp[i][j]=dp[i+1][j-1]&&arr[i]==arr[j];
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
