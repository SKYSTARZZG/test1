package huaweijishi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 记负均正 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len=in.nextInt();
            int[] arr=new int[len];
            List<Integer> fuList=new ArrayList<>();
            List<Integer> zhengList=new ArrayList<>();
            for(int i=0;i<len;i++){
                arr[i]=in.nextInt();
                if(arr[i]<0) {
                    fuList.add(arr[i]);
                }else {
                    zhengList.add(arr[i]);
                }
            }
            int fuSize=fuList.size();
            int zhengSize=zhengList.size();
            int sumZheng=0;
            for(int i=0;i<zhengSize;i++){
                sumZheng+=zhengList.get(i);
            }
            BigDecimal num=new BigDecimal(sumZheng);
            BigDecimal result=num.divide(new BigDecimal(zhengSize));
            result=result.setScale(1, RoundingMode.HALF_UP);
            String str=result.toString();
            if(str.endsWith("0")){
                str=str.substring(0,str.length()-2);
            }
            System.out.println(fuSize+" "+str);
        }
    }
}
