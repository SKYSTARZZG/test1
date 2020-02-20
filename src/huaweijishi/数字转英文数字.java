package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 数字转英文数字 {
    private static Map<Integer,String> intMapEn=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            int len=str.length();
            Map<String,String> map=new HashMap<>();
            if(len<=3){
                map.put("",str);
            }else if(len>3&&len<=6){
                String str1=str.substring(len-3);
                String str2=str.substring(0,len-3);
                map.put("",str1);
                map.put("thousand",str2);
            }else{
                String str1=str.substring(len-3);
                String str2=str.substring(len-6,len-3);
                String str3=str.substring(0,len-6);
                map.put("",str1);
                map.put("thousand",str2);
                map.put("million",str3);
            }
            initIntMapEn();
            String result=getResult(map);
            System.out.println(result);
        }
    }
    private static String getResult(Map<String, String> map) {
        StringBuffer buf=new StringBuffer();
        if(map.containsKey("million")){
            String millionStr=getEn(map.get("million"));
            buf.append(millionStr.trim()+" ").append("million ");
        }
        if(map.containsKey("thousand")) {
            String thousandStr = getEn(map.get("thousand"));
            buf.append(thousandStr.trim()+" ").append("thousand ");
        }
        String str=getEn(map.get(""));
        buf.append(str.trim());
        return buf.toString().trim();
    }
    private static void initIntMapEn() {
        int[] nums={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90};
        String[] numStrs={"zero","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
        for(int i=0;i<nums.length;i++){
            intMapEn.put(nums[i],numStrs[i]);
        }
    }
    private static String getEn(String str){
        int num=Integer.parseInt(str);
        if(num==0) return "zero";
        StringBuffer buf=new StringBuffer();
        int num3=num/100;
        int num21=num%100;
        int num2=num21/10*10;
        int num1=num21%10;
        if(num3!=0){
            buf.append(" "+intMapEn.get(num3)).append(" hundred");
        }
        if(num21!=0){
            if(num3!=0)buf.append(" and");
            if(intMapEn.containsKey(num21)) {
                buf.append(" "+intMapEn.get(num21));
            }else{
                if(num2!=0) buf.append(" "+intMapEn.get(num2));
                if(num1!=0) buf.append(" "+intMapEn.get(num1));
            }
        }


        return buf.toString();
    }
}
