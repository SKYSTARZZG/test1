package huaweijishi;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 线性插值 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int m=in.nextInt();
            int n=in.nextInt();
            Map<Integer,Integer> input=new LinkedHashMap<>();
            Map<Integer,Integer> result=new LinkedHashMap<>();
            for(int i=0;i<m;i++){
                int key=in.nextInt();
                if(input.containsKey(key)){
                    int num=in.nextInt();
                    continue;
                }
                input.put(key,in.nextInt());
            }
            xxcz(input,result);
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }

    private static void xxcz(Map<Integer, Integer> input, Map<Integer, Integer> result) {
        Set<Integer> set=input.keySet();
        List<Integer> list=new ArrayList<>(set);
        int len=list.size();
        for(int i=0;i<len-1;i++){
            int key1=list.get(i),key2=list.get(i+1);
         //   if(key2<key1)continue;
            result.put(key1,input.get(key1));
            if(key2-key1>1){
                for(int n=key1+1;n<key2;n++){
                    int value1=input.get(key1);
                    int value2=input.get(key2);
                    int valueN=(value2-value1)/(key2-key1)*(n-key1)+value1;
                    result.put(n,valueN);
                }
            }
        }
        result.put(list.get(len-1),input.get(list.get(len-1)));
    }
}
