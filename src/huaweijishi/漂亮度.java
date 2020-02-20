package huaweijishi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 漂亮度 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            String[] strs=new String[n];
            for(int i=0;i<n;i++){
                strs[i]=in.next();
                int maxBeauty=getMaxBeauty(strs[i]);
                System.out.println(maxBeauty);
            }
        }
    }

    private static int getMaxBeauty(String str) {
        int[] array=new int[26];
        char[] arr=str.toCharArray();
        int dif='a'-'A';
        for (char c : arr) {
            if(c>='A'&&c<='Z'){
                c=(char)(c+dif);
            }
            int index=c-'a';
            array[index]++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(array[i]!=0){
                list.add(array[i]);
            }
        }
        list=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        int result=0;
        for(int i=0;i<list.size();i++){
            result+=list.get(i)*(26-i);
        }
        return result;
    }
}


