package huaweijishi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2020-01-18
 * @since 1.0.0
 */
public class 成绩排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len=Integer.parseInt(in.nextLine());
            int type=Integer.parseInt(in.nextLine());
            String str;
            List<NameScore> list=new ArrayList<>();
            for(int i=0;i<len;i++){
                str=in.nextLine();
                String[] strs=str.split(" ");
                String name=strs[0];
                int score=Integer.parseInt(strs[1]);
                NameScore nameScore=new NameScore(name,score);
                list.add(nameScore);
            }
            if(type==0){
                list=list.stream()
                        .sorted(Comparator.comparing(NameScore::getScore).reversed())
                        .collect(Collectors.toList());
            }else{
                list=list.stream()
                        .sorted(Comparator.comparing(NameScore::getScore))
                        .collect(Collectors.toList());
            }
            for (NameScore nameScore : list) {
                System.out.println(nameScore.name+" "+nameScore.score);
            }
        }
    }
}
class NameScore{
    String name;
    int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public NameScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
