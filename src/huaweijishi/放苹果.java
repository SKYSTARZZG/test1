package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 放苹果 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m=in.nextInt();
            int n=in.nextInt();
            int num=placeApple(m,n);
            System.out.println(num);
        }
    }
    //m:苹果  n：盘子
    private static int placeApple(int m, int n) {
        if(m<0)return 0;
        if(n==1) return 1;
        if(m==1||m==0)return 1;
        return placeApple(m,n-1)+placeApple(m-n,n);
    }
}
