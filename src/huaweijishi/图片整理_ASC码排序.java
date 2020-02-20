package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 图片整理_ASC码排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String result=new String(arr);
            System.out.println(result);
        }
    }
}
