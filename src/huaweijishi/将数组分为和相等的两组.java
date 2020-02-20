package huaweijishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 将数组分为和相等的两组 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len=in.nextInt();
            int[] arr=new int[len];
            int sum5=0;
            int sum3=0;
            int sum=0;
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<len;i++){
                arr[i]=in.nextInt();
                if(arr[i]%5==0){
                    sum5+=arr[i];
                }else if(arr[i]%3==0){
                    sum3+=arr[i];
                }else{
                    list.add(arr[i]);
                }
                sum+=arr[i];
            }
            boolean flag=canDivided(sum,sum5,sum3,list);
            System.out.println(flag);
        }
    }

    private static boolean canDivided(int sum, int sum5, int sum3, List<Integer> list) {
        if(sum%2!=0) return false;
        int otherSum=0;
        for (Integer num : list) {
            otherSum+=num;
        }

        int dif=(otherSum+sum3-sum5)/2;
        int len=list.size();

        StringBuffer buf=new StringBuffer();
        StringBuffer endBuf=new StringBuffer();
        for(int i=0;i<len;i++){
            buf.append('0');
            endBuf.append('1');
        }
        char[] arr=buf.toString().toCharArray();
        String increaseStr=new String();
        while(!increaseStr.equals(endBuf.toString())){
            increaseStr=increase(arr);
            arr=increaseStr.toCharArray();
            int val=0;
            for(int i=0;i<len;i++){
                if(arr[i]=='1'){
                    val+=list.get(i);
                }
            }
            if(dif==val)return true;
        }
        return false;
    }

    private static String increase(char[] arr) {
        int len1=arr.length;
        StringBuffer buf=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            buf.append(arr[i]);
        }
        String str=buf.toString();
        buf=new StringBuffer();
        int num=Integer.parseInt(str,2);
        num++;
        String binaryStr=Integer.toBinaryString(num);
        int len2=binaryStr.length();
        if(len1>len2){
            for(int i=0;i<len1-len2;i++){
                buf.append(0);
            }
        }
        for(int i=0;i<len2;i++){
            buf.append(binaryStr.charAt(i));
        }
        return buf.toString();
    }
}
