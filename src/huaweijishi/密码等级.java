package huaweijishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author Administrator
 * @Date 2020-01-17
 * @since 1.0.0
 */
public class 密码等级 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str=in.nextLine();
            char[] arr=str.toCharArray();
            int  len=arr.length;
            List<Character> intList=new ArrayList<>();
            List<Character> lowerList=new ArrayList<>();
            List<Character> upperList=new ArrayList<>();
            List<Character> otherList=new ArrayList<>();
            for(int i=0;i<len;i++){
                char c=arr[i];
                if(c>='0'&&c<='9'){
                    intList.add(c);
                }else if(c>='a'&&c<='z'){
                    lowerList.add(c);
                }else if(c>='A'&&c<='Z'){
                    upperList.add(c);
                }else {
                    otherList.add(c);
                }
            }
            int numLen=intList.size();
            int lowerLen=lowerList.size();
            int upperLen=upperList.size();;
            int otherLen=otherList.size();
            int score=0;
            if(len<=4) {
                score+=5;
            }else if(len>=5&&len<=7){
                score+=10;
            }else{
                score+=25;
            }

            if(lowerList.size()>0&&upperList.size()>0){
                score+=20;
            }else if(lowerList.size()>0||upperList.size()>0){
                score+=10;
            }

            if(intList.size()>1){
                score+=20;
            }else if(intList.size()==1){
                score+=10;
            }

            if(otherList.size()>1){
                score+=25;
            }else if(otherList.size()==1){
                score+=10;
            }
            /*五、奖励:
       2 分: 字母和数字
       3 分: 字母、数字和符号
       5 分: 大小写字母、数字和符号*/
            if(upperLen>0&&lowerLen>0&&numLen>0&&otherLen>0){
                score+=5;
            }else if((upperLen+lowerLen)>0&&numLen>0&&otherLen>0) {
                score += 3;
            }else if((upperLen+lowerLen)>0&&numLen>0){
                score+=2;
            }

            String result;
            if(score>=90){
                result="VERY_SECURE";
            }else if (score>=80){
                result="SECURE";
            }else if(score>=70){
                result="VERY_STRONG";
            }else if(score>=60){
                result="STRONG";
            }else if(score>=50){
                result="AVERAGE";
            }else if(score>=25){
                result="WEAK";
            }else{
                result="VERY_WEAK";
            }
            System.out.println(result);
        }
    }
}
