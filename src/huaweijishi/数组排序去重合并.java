package huaweijishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 数组排序去重合并 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len1 = in.nextInt();
            StringBuffer buf=new StringBuffer();
           int[] arr1=new int[len1];
           for(int i=0;i<len1;i++){
               arr1[i]=in.nextInt();
            //   buf.append(arr1[i]+" ");
           }
           arr1=  Arrays.stream(arr1).sorted().distinct().toArray();
            len1=arr1.length;
           int len2=in.nextInt();
            int[] arr2=new int[len2];
            for(int i=0;i<len2;i++){
                arr2[i]=in.nextInt();
             //   buf.append(arr2[i]+" ");
            }
            arr2=Arrays.stream(arr2).sorted().distinct().toArray();
            len2=arr2.length;
            int p1=0,p2=0;
            while(p1<len1&&p2<len2){
                int num1=arr1[p1];
                int num2=arr2[p2];
                if(num1==num2){
                    buf.append(num1);
                    p1++;p2++;
                }else if(num1<num2){
                    buf.append(num1); p1++;
                }else{
                    buf.append(num2); p2++;
                }
            }
            while(p1<len1){
                buf.append(arr1[p1++]);
            }
            while(p2<len2){
                buf.append(arr2[p2++]);
            }
            System.out.println(buf.toString());


        }
    }
}
