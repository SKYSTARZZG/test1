package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 计算立方根 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            double num=in.nextDouble();
            double result=getCubeRoot(num);
            System.out.printf("%.1f",result);
        }
    }

    private static double getCubeRoot(double num) {
        double left=0.0,right=num;
        double mid=0.0;
        while(right-left>0.001){
             mid=(left+right)/2;
            double cube=mid*mid*mid;
            if(cube<num){
                left=mid;
            }else if(cube>num){
                right=mid;
            }
        }
        return mid;
    }
}
