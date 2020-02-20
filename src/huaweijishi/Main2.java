package huaweijishi;

import java.util.Scanner;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Administrator
 * @Date 2020-01-19
 * @since 1.0.0
 */
public class Main2 {
    public static void main(String[] args) {
        Thread t=new Thread();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int num=in.nextInt();
            String reuslt=change(num);
            System.out.println(reuslt);
        }
    }

    private static String change(int num) {

        StringBuffer buf=new StringBuffer();
        int yushu=0;
        while(num>26){
            yushu=(num-1)%26;
            if(yushu==0){
                buf.insert(0,'z');
                num=num/26-1;
                continue;
            }
            char c=(char)(yushu+'a');
            buf.insert(0,c);
            num/=26;
        }
        if(yushu==0&&num!=1){
            char c=(char)(num-1+'a');
            buf.append(c);
        }
    /*    if(num!=0){
            char c=(char)(num-1+'a');
            buf.insert(0,c);
        }*/
        return buf.toString();
    }
}
