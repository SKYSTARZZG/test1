package huaweijishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] arr={186,186 ,150 ,200, 160, 130, 197 ,200};
        int len=arr.length;
        int[] dp=new int[len];
        for(int i=0;i<len;i++){
            dp[i]=1;
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
        }
        int result=Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}
