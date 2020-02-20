package huaweijishi;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-16
 * @since 1.0.0
 */
public class 计算字符串之间的距离 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str1=in.next();
            String str2=in.next();
            int len1=str1.length();
            int len2=str2.length();
            int[][] distance=new int[len1+1][len2+1];
            distance[0][0]=0;
            for(int i=1;i<=len1;i++){
                distance[i][0]=i;
            }
            for(int i=1;i<=len2;i++){
                distance[0][i]=i;
            }
            for(int i=1;i<=len1;i++){
                for(int j=1;j<=len2;j++){
                    if(str1.charAt(i-1)==str2.charAt(j-1)){
                        distance[i][j]=distance[i-1][j-1];
                    }else{
                        distance[i][j]=min(distance[i-1][j],distance[i][j-1],distance[i-1][j-1])+1;
                    }
                }
            }
            System.out.println(distance[len1][len2]);
        }
    }

    private static int min(int i, int i1, int i2) {
        int min=Math.min(i,i1);
        return Math.min(min,i2);
    }
}
