

import java.util.*;
public class StringTest {
    public static void main(String[] args){
        int[][] nums={{7,0,0,0,0},
                      {3,8,0,0,0},
                      {8,1,0,0,0},
                      {2,7,4,4,0},
                      {4,5,2,6,5}};
        int max=maxSum(nums,0,0);
        System.out.println(max);

    }

    private static int maxSum(int[][] nums,int i,int j) {
        int len=nums.length;
    //    if(i==len-1) return nums[i][j];
        int len2=nums[0].length;
        int[][] maxNums=new int[len][len2];
        int[] maxNums2=nums[len-1];
        for(int m=len-2;m>=0;m--){
            for(int n=0;n<len2-1;n++){
                maxNums2[n]=nums[m][n]+Math.max(maxNums2[n],maxNums2[n+1]);
            }
        }
        return maxNums2[0];
/*        for(int m=len-1;m>=0;m--){
          //  int max;
            for(int n=0;n<len2-1;n++){
                if(m==len-1){
                    maxNums[m][n]=nums[m][n];
                }else{
                    maxNums[m][n]=Math.max(maxNums[m+1][n],maxNums[m+1][n+1])+nums[m][n];
                }
            }
        }*/
        //return maxNums[0][0];
    }
}