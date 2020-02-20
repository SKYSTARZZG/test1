package huaweijishi;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 砝码称重 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int num=in.nextInt();
            int[] weights=new int[num];
            int[] amounts=new int[num];
            for(int i=0;i<num;i++){
                weights[i]=in.nextInt();
            }
            for(int j=0;j<num;j++){
                amounts[j]=in.nextInt();
            }
            Set<Integer> set=new HashSet<>(); set.add(0);
            for(int i=0;i<num;i++){
                List<Integer> list=new ArrayList<>(set);
                for(int j=1;j<=amounts[i];j++){
                    for(int k=0;k<list.size();k++){
                        int newWeight=list.get(k)+weights[i]*j;
                        set.add(newWeight);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
