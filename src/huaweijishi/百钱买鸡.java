package huaweijishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 百钱买鸡 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num=in.nextInt();
            List<String> list2=new ArrayList<>();
            List<int[]> list=new ArrayList<>();
            for(int k=0;k<100;k++){
                for(int m=0;m<100;m++){
                    if(7*k+4*m==100){
                        int[] arr={k,m};
                        list.add(arr);
                    }
                }
            }
            for (int[] ints : list) {
                int k=ints[0],m=ints[1];
                int n=100-m-k;
                System.out.println(k+" "+m+" "+n);
            }

        }
    }
}
