package com.company.BinaryTrees.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//s.c ,t.c ->o(n)
public class zigzag {

    ArrayList<Integer> zigZagTraversal(Node root)
    {
        //Add your code here.
        Queue<Node> q = new LinkedList<>();
        boolean flag = true;//for left to right
        q.offer(root);
        ArrayList < Integer > sub = new ArrayList <  Integer >();
        int j = 0;
        while (!q.isEmpty()){

            int n = q.size();
            for (int i = 0; i < n; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);

                if(flag){
                    sub.add(q.poll().data);
                }else{
                    sub.add(j,q.poll().data);
                }


            }
            j += n;
            flag = !flag;
        }
        return sub;

    }

    public static ArrayList < ArrayList < Integer >> zigzagLevelOrder(Node root) {

        ArrayList < ArrayList < Integer >> wrap = new ArrayList < ArrayList < Integer >>();
        Queue<Node> q = new LinkedList<>();
        boolean flag = true;//for left to right
        q.offer(root);

        while (!q.isEmpty()){
            ArrayList < Integer > sub = new ArrayList <  Integer >();
             int n = q.size();
            for (int i = 0; i < n; i++) {
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);

                if(flag){
                    sub.add(q.poll().data);
                }else{
                    sub.add(0,q.poll().data);
                }

            }
            flag = !flag;
            wrap.add(sub);
        }
        return wrap;



    }

        public static void main(String args[]) {
            int i, j;
            Node root = new Node(3);
            root.left = new Node(9);
            root.right = new Node(20);
            root.right.left = new Node(15);
            root.right.right = new Node(7);
            ArrayList <ArrayList< Integer >> ans;
            ans = zigzagLevelOrder(root);
            System.out.println("Zig Zag Traversal of Binary Tree ");
            for (i = 0; i < ans.size(); i++) {
                for (j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }

        }

}
