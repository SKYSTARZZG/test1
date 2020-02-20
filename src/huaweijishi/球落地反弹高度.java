package huaweijishi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 球落地反弹高度 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            double h=in.nextDouble();
            double[] downs=new double[5];
            double[] ups=new double[5];
            for(int  i=0;i<5;i++){
                downs[i]=h/Math.pow(2,i);
                ups[i]=h/Math.pow(2,i+1);
            }
            double allLen=downs[0]+ups[0]+downs[1]+ups[1]+downs[2]+ups[2]+
                    downs[3]+ups[3]+downs[4];
            System.out.println(fixDouble(allLen));
            System.out.println(fixDouble(ups[4]));
        }
    }

    public static double fixDouble(double num, int n) {
        if(num == 0) {
            return 0;
        }

        final double d = Math.ceil(Math.log10(num < 0 ? -num: num));
        final int power = n - (int) d;

        final double magnitude = Math.pow(10, power);
        final long shifted = Math.round(num*magnitude);
        return shifted/magnitude;
    }

    public static String fixDouble(double num){
        String str=num+"";
        String[] strs=str.split("\\.");
        if(strs.length==1){
            return num+"";
        }
        String zsStr=strs[0];
        int zsLen=zsStr.length();
        int xsLen;
        if(zsLen>=6){
           return (int)Math.round(num)+"";
        }else{
            xsLen=6-zsLen;
            BigDecimal bd=new BigDecimal(num);
            String result=bd.setScale(xsLen, RoundingMode.HALF_DOWN).toString();
         //   String result=bd.setScale(xsLen, RoundingMode.HALF_UP).toString();
            String xsResult=result.split("\\.")[1];
            if(Integer.parseInt(xsResult)==0){
                return result.split("\\.")[0];
            }
            while(result.endsWith("0")){
                int len=result.length();
                result=result.substring(0,len-1);
            }
            return result;
        }
    }
}
