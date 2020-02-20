package huaweijishi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author Administrator
 * @Date 2020-01-15
 * @since 1.0.0
 */
public class 迷宫_二维数组 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        while(in.hasNext()){
            int m=in.nextInt(),n=in.nextInt();
            int[][] a=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    a[i][j]=in.nextInt();
                }
            }
            findPath(m,n,a);
        }
    }

    private static void findPath(int m, int n, int[][] a) {
        Node start=new Node(0,0);
        Stack<Node> stack=new Stack<>();
        stack.push(start);
        int[][] visited=new int[m][n];
        int[][] direct={{1,0},{0,1}};
        outer:while(stack.size()>0){
            Node cur=stack.peek();
            if(cur.x==m-1&&cur.y==n-1){
                break;
            }
            for(int i=0;i<2;i++){
                Node nbr=new Node(cur.x+direct[i][0],cur.y+direct[i][1]);
                if (nbr.x < m && nbr.y < n && visited[nbr.x][nbr.y]==0&&a[nbr.x][nbr.y]==0) {
                    stack.push(nbr);
                    visited[nbr.x][nbr.y]=1;
                    continue outer;
                }
            }
            stack.pop();
        }
        Stack<Node> stack1=new Stack<>();
        while(stack.size()>0){
            stack1.push(stack.pop());
        }
        while(stack1.size()>0){
            Node node=stack1.pop();
            System.out.println("("+node.x+","+node.y+")");
        }
    }
}
class Node{
    int x,y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}