package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 字符串通配符 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str1=in.nextLine();
            String str2=in.nextLine();
            str1=str1.replaceAll("\\?","[0-9a-zA-Z]");
            str1=str1.replaceAll("\\*","[0-9a-zA-Z]*");
            str1=str1.replaceAll("\\.","\\.");
            System.out.println(str2.matches(str1));
        }
    }
}
