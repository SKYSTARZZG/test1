package huaweijishi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-16
 * @since 1.0.0
 */
public class 字符串最长重复字符 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String str=in.next();
            char[] chars=str.toCharArray();
            Map<Character,Integer> map=new HashMap<>();
            for (char c : chars) {
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                }
            }
            List<Integer> lens=new ArrayList<>(map.values());
            lens=lens.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            int max=lens.get(0);
            List<Character> charList=new ArrayList<>();
            for (Character c : map.keySet()) {
                if(map.get(c)==max){
                    charList.add(c);
                }
            }
            charList=charList.stream().sorted().collect(Collectors.toList());
            char maxChar=charList.get(0);
            for(int i=0;i<max;i++){
                System.out.print(maxChar);
            }
        }
    }
}
