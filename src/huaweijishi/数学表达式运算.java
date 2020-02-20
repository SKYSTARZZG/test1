package huaweijishi;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-01-16
 * @since 1.0.0
 */
public class 数学表达式运算 {
    public static void main(String[] args) {
        String str2="1+3";
        System.out.println(str2.indexOf("-"));

        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.next();
            List<String> strs=new ArrayList<>();

            int result=accmulate(str);
        }
    }

    private static int accmulate(String str) {
        if(str.contains("(")){
            String result=xkh(str);

        }
        return 0;
    }
    private static String xkh(String str){
        int start=str.indexOf("(");
        int end=str.indexOf(")");
        String sub=str.substring(start+1,end);
        List<String> list=handle(sub);
        int result=simpleAccumulate(sub);
        return result+"";
    }

    private static List<String> handle(String str) {
        List<String> list=new ArrayList<>();
        int start=0;
        if(!(str.charAt(0)>='0'&&str.charAt(0)<='9')){
            list.add("0");
            list.add(str.substring(0,1));
            start=1;
        }
        for(int i=1;i<str.length();i++){
            char c=str.charAt(i);
            boolean isNum=c>='0'&& c<='9';
            if(!isNum){
                list.add(str.substring(start,i));
                list.add(str.substring(i,i+1));
            }
        }
        return list;
    }

    private static int simpleAccumulate(String str) {
        int indexCheng=str.indexOf("*");
        int indexChu=str.indexOf("\\");
        int indexJia=str.indexOf("+");
        int indexJian=str.indexOf("-");
        String result="";
        if(indexCheng==-1&&indexChu==-1&&indexJia==-1&&indexJian==-1){
            return Integer.parseInt(result);
        }
        if(indexCheng!=-1){
            String chengResult=cheng(str,indexCheng);
            simpleAccumulate(chengResult);
        }
        return 0;
    }

    private static String cheng(String str, int indexCheng) {
        Map<String,Integer>  map=getStartEnd(str,indexCheng);
        StringBuffer buf=new StringBuffer();
        buf.append(str.substring(0,map.get("start")))
                .append(map.get("num1")*map.get("num2"))
                .append(map.get("end")+1);
        return buf.toString();
    }

    private static Map<String,Integer>  getStartEnd(String str, int index) {
        int start=index-1;
        int end=index+1;
        while(str.charAt(start-1)>='0'&&str.charAt(start-1)<='9'){
            start--;
        }
        while(str.charAt(end+1)>='0'&&str.charAt(end+1)<='9'){
            end++;
        }
        String str1=str.substring(start,index);
        String str2=str.substring(index+1,end+1);
        int num1=Integer.parseInt(str1);
        int num2=Integer.parseInt(str2);
        Map<String,Integer> map=new HashMap<>();
        map.put("start",start);map.put("end",end);
        map.put("num1",num1);map.put("num2",num2);
        return map;
    }
}
