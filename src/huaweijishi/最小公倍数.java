package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 最小公倍数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num1=in.nextInt();
            int num2=in.nextInt();
            int result=getResult(num1,num2);
            System.out.println(result);
        }
    }

    private static int getResult(int num1, int num2) {
        int min=Math.min(num1,num2);
        int mid=min/2;
        int maxGongYueShu=1;
        for(int i=2;i<=mid;i++){
            if(num1%i==0&&num2%i==0){
                maxGongYueShu=i;
            }
        }
        num1/=maxGongYueShu;
        num2/=maxGongYueShu;
        return num1*num2*maxGongYueShu;
    }
}
