package huaweijishi;

import java.util.Scanner;
/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 多线程循环输出ABCD {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Object a=new Object();Object b=new Object();
        Object c=new Object();Object d=new Object();
        while(in.hasNext()){
            int num=in.nextInt();
            MyThread ta=new MyThread("A",d,a,num);
            MyThread tb=new MyThread("B",a,b,num);
            MyThread tc=new MyThread("C",b,c,num);
            MyThread td=new MyThread("D",c,d,num);
            ta.start();Thread.sleep(100);
            tb.start();Thread.sleep(100);
            tc.start();Thread.sleep(100);
            td.start();Thread.sleep(100);
        }
    }
}
class MyThread extends Thread{
    private String name;
    private Object prev;
    private Object cur;
    private int count;
    public MyThread(String name,Object prev,Object cur,int count){
        this.name=name;
        this.prev=prev;
        this.cur=cur;
        this.count=count;
    }

    @Override
    public void run() {
        while(count>0){
            synchronized (prev){
                synchronized (cur){
                    System.out.print(name);
                    count--;
                    cur.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
