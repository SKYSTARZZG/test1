package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 简单错误记录 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        Map<String,Integer> map=new LinkedHashMap<>();
        while((str=br.readLine())!=null){
            int index=str.indexOf(" ");
            String fileName=str.substring(0,index);
            int rowNum=Integer.parseInt(str.substring(index).trim());
            if(fileName.contains("\\")){
                fileName=fileName.substring(fileName.lastIndexOf("\\")+1);
            }
            if(fileName.length()>16){
                fileName=fileName.substring(fileName.length()-16);
            }
            String key=fileName+" "+rowNum;
            if(map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        int size=map.size();
        int i=0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(i<size-8){
                i++;continue;
            }
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
