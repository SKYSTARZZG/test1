package huaweijishi;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-16
 * @since 1.0.0
 */
public class 链表 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int len=in.nextInt();
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<len;i++){
                list.add(in.nextInt());
            }
            int index=in.nextInt();
            System.out.println(list.get(len-index));
        }
    }
}
