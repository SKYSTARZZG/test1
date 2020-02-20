package huaweijishi;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-01-14
 * @since 1.0.0
 */
public class 数据分类处理 {
    public static void main(String[] args) {
        // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int lenI = in.nextInt();
            int[] arrI = new int[lenI];
            for (int i = 0; i < lenI; i++) {
                arrI[i] = in.nextInt();
            }
            int lenR = in.nextInt();
            int[] arrR = new int[lenR];
            for (int i = 0; i < lenR; i++) {
                arrR[i] = in.nextInt();
            }
            int[] sortedR = Arrays.stream(arrR).distinct().sorted().toArray();
            System.out.println(Arrays.toString(sortedR));
            Map<Integer, List<Num>> map = new HashMap<>();
            for (int r : sortedR) {
                map.put(r, new ArrayList<>());
                for (int i = 0; i < lenI; i++) {
                    if ((arrI[i] + "").contains(r + "")) {
                        Num num = new Num(i, arrI[i]);
                        map.get(r).add(num);
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            result.add(0);
            for (int r : sortedR) {
                if (map.get(r).size() == 0) {
                    continue;
                }
                result.add(r);
                List<Num> nums = map.get(r);
                result.add(nums.size());
                nums.forEach(num -> {
                    result.add(num.index);
                    result.add(num.value);
                });
            }
            int resultSize = result.size();
            result.set(0, resultSize - 1);
            for (int i = 0; i < resultSize; i++) {
                if (i == resultSize - 1) {
                    System.out.println(result.get(i));
                } else {
                    System.out.print(result.get(i) + " ");
                }
            }
        }
    }
}
class Num{
    int index;
    int value;
    public Num(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
