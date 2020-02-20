package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 自守数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int max=in.nextInt();
            int num=0;
            for(int i=0;i<max;i++){
                if(isZiShouShu(i)){
                    num++;
                }
            }
            System.out.println(num);
        }
    }

    private static boolean isZiShouShu(int num) {
        int num2=num*num;
        if((num2+"").endsWith(num+"")){
            return true;
        }
        return false;
    }
}
