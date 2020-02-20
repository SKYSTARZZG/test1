package huaweijishi;

import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 矩阵乘法 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int x=Integer.parseInt(in.nextLine());
            int y=Integer.parseInt(in.nextLine());
            int z=Integer.parseInt(in.nextLine());
            int[][] arr1=new int[x][y];
            int[][] arr2=new int[y][z];
            for(int i=0;i<x;i++){
                String str1=in.nextLine();
                String[] strs=str1.split(" ");
                for(int j=0;j<y;j++){
                    arr1[i][j]=Integer.parseInt(strs[j]);
                }
            }
            for(int i=0;i<y;i++){
                String str2=in.nextLine();
                String[] strs=str2.split(" ");
                for(int j=0;j<y;j++){
                    arr2[i][j]=Integer.parseInt(strs[j]);
                }
            }
            int[][] result=new int[x][z];
            for(int i=0;i<x;i++){
                for(int j=0;j<z;j++){

                }
            }
        }
    }
}
