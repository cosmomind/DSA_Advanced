package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;

//.sc,t.c -> o(n)
public class Inorder_rec {
    static void inod(Node curr, ArrayList<Integer> inod){
        if(curr == null){
            return;
        }
        inod(curr.left,inod);
        inod.add(curr.data);

        inod(curr.right,inod);
    }

    public static void main(String[] args) {
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

        ArrayList<Integer> inorder  = new ArrayList<>();
        inod(root,inorder);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i) + " ");
        }

    }
}
