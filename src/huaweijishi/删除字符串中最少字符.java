package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 删除字符串中最少字符 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            Map<Character,Integer> map=new HashMap<>();
            int len=str.length();
            for(int i=0;i<len;i++){
                char c=str.charAt(i);
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                }
            }
            List<Integer> values=map.values().stream().sorted().collect(Collectors.toList());
            int min=values.get(0);
            String result=str;
            for(char c:map.keySet()){
                if(map.get(c)==min){
                    result=result.replaceAll(c+"","");
                }
            }
            System.out.println(result);
        }
    }
}
