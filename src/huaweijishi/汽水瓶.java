package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Administrator
 * @Date 2020-01-13
 * @since 1.0.0
 */
public class 汽水瓶 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            int empty=Integer.parseInt(str);
            int result=sumFull(empty);
            System.out.println(result);
        }
    }

    private static int sumFull(int empty) {
        if(empty<=1) return 0;
        int result=0;
        while(empty>=2){
            if(empty==2){
                result++;break;
            }
            int full=empty/3;
            result+=full;
            empty=empty%3+full;
        }
        return result;
    }
}
