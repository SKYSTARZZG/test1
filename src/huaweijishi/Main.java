package huaweijishi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-19
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.nextLine();
            String[] strs=str.split(" ");
            int len=strs.length;
            List<String> list=new ArrayList<>();
            for(int i=1;i<len;i++){
                String string=strs[i];
                addList(string,list);
            }
            Collections.sort(list);
            for(int i=0;i<list.size();i++){
                if(i==list.size()-1){
                    System.out.print(list.get(i));
                }else{
                    System.out.print(list.get(i)+" ");
                }
            }
        }
    }

    private static void addList(String string, List<String> list) {
        int len=string.length();
        if(len%8!=0){
            string+="0000000";
        }
        while(string.length()>=8){
            list.add(string.substring(0,8));
            string=string.substring(8);
        }
    }
}
