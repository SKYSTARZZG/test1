package huaweijishi;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-01-16
 * @since 1.0.0
 */
public class 高精度十进制加减法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1 = in.next();
            String str2 = in.next();
            int len1 = str1.length();
            int len2 = str2.length();
            String longStr = str1, shortStr = str2;
            if (len1 < len2) {
                longStr = str2;
                shortStr = str1;
            }
            int longLen = longStr.length();
            int shortLen = shortStr.length();
            StringBuffer buf1=new StringBuffer(longStr);
            StringBuffer buf2=new StringBuffer(shortStr);
            for(int i=0;i<longLen-shortLen;i++){
                buf2.insert(0,'0');
            }
            StringBuffer result=new StringBuffer();
            int jinwei=0;
            for(int i=longLen-1;i>=0;i--){
                int num1=buf1.charAt(i)-'0';
                int num2=buf2.charAt(i)-'0';
                int num=num1+num2+jinwei;
                jinwei=num/10;
                num%=10;
                result.insert(0,num);
            }
            if(jinwei==1){
                result.insert(0,jinwei);
            }
            System.out.println(result.toString());
        }
    }
}
