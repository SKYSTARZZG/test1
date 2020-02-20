package huaweijishi;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 坐标移动 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Set<String> set=Stream.of("A","D","W","S").collect(Collectors.toSet());
        while(in.hasNextLine()){
            String input=in.nextLine();
            String[] strs=input.split(";");
            int x=0,y=0;
            for(String str:strs){
                Position position=check(str,set);
                if(position!=null){
                    String first=position.str;
                    if(first.equals("A")){
                        x-=position.num;
                    } else if (first.equals("D")) {
                        x+=position.num;
                    }else if(first.equals("W")){
                        y+=position.num;
                    }else{
                        y-=position.num;
                    }
                }
            }
            System.out.println(x+","+y);
        }
    }

    private static Position check(String str,Set<String> set) {
        if("".equals(str)||str==null) return null;
        if(str.length()>3)return null;
        String first=str.substring(0,1);
        if(!set.contains(first))return null;
        String numStr=str.substring(1);
        try{
            int num=Integer.parseInt(numStr);
            Position position=new Position(first,num);
            return position;
        }catch (Exception e){
            return null;
        }
    }
}
class Position{
    String str;
    int num;

    public Position(String str, int num) {
        this.str = str;
        this.num = num;
    }
}
