package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 素数伴侣 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNextInt()){
            int len=in.nextInt();
            int[] arr=new int[len];
            for(int i=0;i<len;i++){
                arr[i]=in.nextInt();
            }
            int[] dp=new int[len+1];
            for(int i=1;i<len;i++){
                for(int j=i+1;j<len;j++){
                    int num=(isSushu(arr[i]+arr[j]))?dp[i-1]+dp[j-1]-dp[j]+1:dp[i-1];
                    dp[i]=Math.max(num,dp[i]);
                }
            }
            System.out.println(dp[len-1]);
        }
    }

    private static boolean isSushu(int num) {
        if(num<=2)return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

}
