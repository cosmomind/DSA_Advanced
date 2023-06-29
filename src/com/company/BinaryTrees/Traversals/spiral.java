package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class spiral {
    static ArrayList<Integer> findSpiral(Node root)
    {
        // Your code here
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans  =new ArrayList<>();
        boolean flag = true;//left to right
        if(root == null){
            return ans;
        }
        q.offer(root);int j = 0;
        while (!q.isEmpty()){
            int n = q.size();
            for(int i = 0;i< q.size();i++){
                if(q.peek().left != null){
                    q.offer(q.peek().left);
                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);
                }
                if(flag){
                    ans.add(j,q.poll().data);
                }
                else{
                    ans.add(q.poll().data);
                }
            }
            flag = !flag;
            j += n;


        }

        return ans;

    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);




        ArrayList< Integer > preOrder = new ArrayList < > ();
        preOrder = findSpiral(root);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }
    }
}
