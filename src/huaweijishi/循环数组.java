package huaweijishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-16
 * @since 1.0.0
 */
public class 循环数组 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()) {
            int num=in.nextInt();
            int result=0;
            for(int i=1;i<=num;i++){
                if(isPerfect(i)){
                    result++;
                }
            }
            System.out.println(result);
        }

    }

    private static boolean isPerfect(int num) {
        int mid=num/2;
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=mid;i++){
            if(num%i==0)list.add(i);
        }
        int num2=0;
        for (Integer i : list) {
            num2+=i;
        }
        return num==num2;
    }
}
