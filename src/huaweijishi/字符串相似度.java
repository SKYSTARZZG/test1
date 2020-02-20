package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 字符串相似度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            int len1=str1.length();
            int len2=str2.length();
            int[][] dp=new int[len1+1][len2+1];
            dp[0][0]=0;
            for(int i=1;i<=len1;i++){
                dp[i][0]=i;
            }
            for(int j=1;j<=len2;j++){
                dp[0][j]=j;
            }
            for(int i=1;i<=len1;i++){
                for(int j=1;j<=len2;j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1];
                    }else{
                        dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                    }
                }
            }
            System.out.println("1/"+(dp[len1][len2]+1));
        }
    }

    private static int min(int a, int b, int c) {
        int min1=Math.min(a,b);
        int min2=Math.min(min1,c);
        return min2;
    }
}
