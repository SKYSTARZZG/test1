package huaweijishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Item
{
    int price;
    int weight;
    int affiliation;
    public Item(int price,int weight,int affiliation) {
        this.price=price;
        this.weight=weight;
        this.affiliation=affiliation;
    }
}
public class 购物单 {
    public static void main(String[] arg) {
        ArrayList<Item> items;
        Scanner scan=new Scanner(System.in);
        int allCash=scan.nextInt()/10;
        int itemNum=scan.nextInt();
        items=new ArrayList<>(itemNum);
        int i,j,multi,multiFather,idx;
        Item father,itm;
        boolean[][] visit=new boolean[allCash+1][itemNum];
        int[] box=new int[allCash+1];
        for(i=0;i<itemNum;i++)
        {
            items.add(new Item(scan.nextInt()/10, scan.nextInt(), scan.nextInt()));
        }
        for(i=0;i<itemNum;i++)
        {
            itm=items.get(i);
            multi=itm.price*itm.weight;
            if(itm.affiliation>0)
            {
                father=items.get(itm.affiliation-1);
                multiFather=father.price*father.weight;
                for(j=allCash;j>=itm.price;j--)
                {
                    idx=j-itm.price;
                    if(!visit[idx][itm.affiliation-1])
                    {
                        idx-=father.price;
                        if(idx>=0&&box[j]<box[idx]+multi+multiFather)
                        {
                            box[j]=box[idx]+multi+multiFather;
                            visit[j]=Arrays.copyOf(visit[idx], itemNum);
                            visit[j][i]=true;
                            visit[j][itm.affiliation-1]=true;
                        }
                    }
                    else if(box[j]<box[idx]+multi){
                        box[j]=box[idx]+multi;
                        visit[j]=Arrays.copyOf(visit[idx], itemNum);
                        visit[j][i]=true;
                    }
                }
            }
            else {
                for(j=allCash;j>=itm.price;j--)
                {
                    idx=j-itm.price;
                    if(box[j]<box[idx]+multi)
                    {
                        box[j]=box[idx]+multi;
                        visit[j]= Arrays.copyOf(visit[idx], itemNum);
                        visit[j][i]=true;
                    }

                }
            }

        }
        System.out.println(box[allCash]*10);
    }
}
