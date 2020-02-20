package huaweijishi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 字符串倒叙 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str=in.nextLine();
            int len=str.length();
            char[] arr=str.toCharArray();
            Stack<Character> stack=new Stack<>();
            for (char c : arr) {
                stack.push(c);
            }
            while (stack.size()>0){
                System.out.print(stack.pop());
            }
        }
    }
}
