package huaweijishi;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author Administrator
 * @Date 2020-02-13
 * @since 1.0.0
 */
public class 排序 {
    public static void main(String[] args) {
        int[] arr=new Random()
                .ints(10,1,100).toArray();
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        if(arr==null||arr.length<=1) return;
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int cur=arr[i+1];
            int preIndex=i;
            while(preIndex>=0&&cur<arr[preIndex]){
                arr[preIndex+1]=arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1]=cur;
        }
    }
    public static void shellSort(int[] arr){
        int len=arr.length,gap=len/2;
        while(gap>0){
            for(int i=gap;i<len;i++){
                int cur=arr[i],preIndex=i-gap;
                while(preIndex>=0&&cur<arr[preIndex]){
                    arr[preIndex+gap]=arr[preIndex];
                    preIndex-=gap;
                }
                arr[preIndex+gap]=cur;
            }
            gap/=2;
        }
    }
    public static int[] mergeSort(int[] arr){
        if(arr.length<2) return arr;
        int len=arr.length;
        int[] left=Arrays.copyOfRange(arr,0,len/2);
        int[] right=Arrays.copyOfRange(arr,len/2,len);
        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int len1=left.length,len2=right.length,len=len1+len2;
        int[] arr=new int[len];
        for(int leftI=0,rightI=0,i=0;i<len;i++){
            boolean flag=leftI<len1&&rightI<len2&&left[leftI]<right[rightI]
                    || leftI<len1&&rightI>=len2;
            arr[i]=flag?left[leftI++]:right[rightI++];
        }
        return arr;
    }
    public static void quickSort(int[] arr,int left,int right){
      if(left>=right)return;
      int p1=left,p2=right,key=arr[left];
      while(p1<p2){
          while(p1<p2&&arr[p2]>=key) p2--;
          arr[p1]=arr[p2];
          while(p1<p2&&arr[p1]<=key)p1++;
          arr[p2]=arr[p1];
      }
      arr[p1]=key;
      quickSort(arr,left,p1-1);
      quickSort(arr,p1+1,right);
    }
}
