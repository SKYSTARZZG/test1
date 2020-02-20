package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 每月兔子个数 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int month=in.nextInt();
            int num=getTotalNum(month);
            System.out.println(num);
        }
    }

    private static int getTotalNum(int month) {
        if(month<3) return 1;
        return getTotalNum(month-1)+getTotalNum(month-2);
    }
}
