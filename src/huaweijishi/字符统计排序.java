package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 字符统计排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=br.readLine())!=null) {
            char[] arr = str.toCharArray();
            int[] nums=new int[200];
            int len=arr.length;
            int max=0;
            for(int i=0;i<len;i++){
                int index=(int)arr[i];
                nums[index]++;
                max=Math.max(max,nums[index]);
            }
            StringBuffer buf=new StringBuffer();
            while(max>0){
                for(int i=0;i<200;i++){
                    if(nums[i]==max){
                        buf.append((char)i);
                    }
                }
                max--;
            }
            System.out.println(buf.toString());
        }
    }
}
