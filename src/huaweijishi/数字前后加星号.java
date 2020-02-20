package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 数字前后加星号 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str=in.nextLine();
            char[] arr=str.toCharArray();
            int len=arr.length;
            String result=sddXing(arr);
            System.out.println(result);
        }
    }

    private static String sddXing(char[] arr) {
        int len=arr.length;
        if(len==0) return "";
        if(len==1){
            char c=arr[0];
            if(isNum(c)){
                return "*"+c+"*";
            }else{
                return c+"";
            }
        }
        StringBuffer buf=new StringBuffer();
        if(isNum(arr[0])){
            buf.append('*');
        }
        buf.append(arr[0]);
        if(isNum(arr[0])&&!isNum(arr[1])){
            buf.append('*');
        }
        int i=1;
        while(i<len-1){
            char pre=arr[i-1];
            char cur=arr[i];
            char next=arr[i+1];
            if(!isNum(pre)&&isNum(cur)){
                buf.append('*');
            }
            buf.append(cur);
            if(isNum(cur)&&!isNum(next)){
                buf.append('*');
            }
            i++;
        }
            if (isNum(arr[len - 1]) && !isNum(arr[len - 2])) {
                buf.append('*').append(arr[len - 1]).append('*');
            } else if (isNum(arr[len - 1]) && isNum(arr[len - 2])) {
                buf.append(arr[len - 1]).append('*');
            } else {
                buf.append(arr[len - 1]);
            }

        return buf.toString();
    }
    public static boolean isNum(char c){
        return c>='0'&&c<='9';
    }
}
