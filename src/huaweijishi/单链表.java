package huaweijishi;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 单链表 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int len=in.nextInt();
            int headValue=in.nextInt();
            LinkedList<Integer> list=new LinkedList<>();
            list.add(0,headValue);
            for(int i=0;i<len-1;i++){
                int value=in.nextInt();
                int beforeValue=in.nextInt();
                if(list.contains(value))continue;
                insertValue(value,beforeValue,list);
            }
            int delValue=in.nextInt();
            int index=list.indexOf(delValue);
            list.remove(index);
            printList(list);
        }
    }
    private static void printList(LinkedList<Integer> list) {
        for (Integer num : list) {
            System.out.print(num+" ");
        }
    }
    private static void insertValue(int value, int beforeValue, LinkedList<Integer> list) {
        int size=list.size();
        for(int i=0;i<size;i++){
            if(list.get(i)==beforeValue){
                list.add(i+1,value);
            }
        }
    }
}

