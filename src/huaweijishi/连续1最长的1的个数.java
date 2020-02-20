package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 连续1最长的1的个数 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int num=in.nextInt();
            String str=Integer.toBinaryString(num);
            char[] arr=str.toCharArray();
            int len=arr.length;
            int max=0,subLen=0;
            for(int i=0;i<len;i++){
                if (arr[i] == '1') {
                    subLen++;
                }else{
                    max=Math.max(max,subLen);
                    subLen=0;
                }
            }
            max=Math.max(max,subLen);
            System.out.println(max);
        }
    }
}
