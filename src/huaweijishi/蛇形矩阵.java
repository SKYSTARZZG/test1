package huaweijishi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 蛇形矩阵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            int n=Integer.parseInt(str);
            int[][] result=new int[n][n];
            for(int i=0;i<n;i++){
                if(i==0){
                    result[i][0]=1;
                }else{
                    result[i][0]=result[i-1][0]+i;
                }
                for(int j=1;j<n-i;j++){
                    result[i][j]=result[i][j-1]+i+j+1;
                }
            }
            for(int i=0;i<n;i++){
                if(i==n-1){
                    System.out.println(result[i][0]);
                }else{
                    System.out.print(result[i][0]+" ");
                }
                for(int j=1;j<n-i;j++){
                    if(j==n-i-1){
                        System.out.println(result[i][j]);
                    }else{
                        System.out.print(result[i][j]+" ");
                    }
                }
            }
        }
    }
}
