package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.Stack;

//s.c,t.c -> o(n)
public class pre_it {

    static ArrayList < Integer > preOrderTrav(Node curr) {

        ArrayList<Integer> pre = new ArrayList<>();
        if(curr == null){
            return pre;
        }
        Stack<Node> s  = new Stack<>();
        s.push(curr);
        while (!s.isEmpty()){
            Node top = s.peek();
            pre.add(top.data);
            s.pop();

            if(top.right!= null){
                s.push(top.right);
            }
            if(top.left!= null){
                s.push(top.left);
            }
        }

        return pre;
    }

    public static void main(String args[]) {


        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);




        ArrayList< Integer > preOrder = new ArrayList < > ();
        preOrder = preOrderTrav(root);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < preOrder.size(); i++) {
            System.out.print(preOrder.get(i) + " ");
        }

    }
}
