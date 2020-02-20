package tree;

import java.util.*;

/**
 * @Author Administrator
 * @Date 2020-02-18
 * @since 1.0.0
 */
public class BinaryTree {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);
        Node n8=new Node(8);
        Node n9=new Node(9);
        Node n10=new Node(10);
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n5;
        n3.left=n6;n3.right=n7;
        n4.left=n8;n4.right=n9;
        n5.left=n10;
        preOrder(n1);
        midOrder(n1);
        levelVisit(n1);
    }
    public static void preOrder(Node root){
        Stack<Node> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        Node cur=root;
        stack.push(cur);
        while(stack.size()>0){
            cur= stack.pop(); list.add(cur.data);
            if(cur.right!=null) stack.push(cur.right);
            if(cur.left!=null) stack.push(cur.left);
        }
        System.out.println(list);
    }
    public static void midOrder(Node root){
        Stack<Node> stack=new Stack<>();
        List<Integer> list=new ArrayList<>();
        Node cur=root;
        while(cur!=null||stack.size()>0){
            while(cur!=null){
                stack.push(cur);cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.data);
            cur=cur.right;
        }
        System.out.println(list);
    }
    public static void levelVisit(Node root){
        Queue<Node> queue=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        queue.add(root);
        Node cur;
        while(queue.size()>0){
            cur=queue.remove();
            list.add(cur.data);
            if(cur.left!=null) queue.add(cur.left);
            if(cur.right!=null) queue.add(cur.right);
        }
        System.out.println(list);
    }
}
class Node{
    int data;
    Node left;
    Node right;
    public Node(int data){
        this.data=data;
    }
}
