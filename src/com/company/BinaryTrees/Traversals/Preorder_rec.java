package com.company.BinaryTrees.Traversals;


import java.util.ArrayList;
//.sc,t.c -> o(n)
public class Preorder_rec {

    static void preod(Node curr,ArrayList <Integer> preod){
        if(curr == null){
            return;
        }
        preod.add(curr.data);
        preod(curr.left,preod);
        preod(curr.right,preod);
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

        ArrayList<Integer> preorder  = new ArrayList<>();
        preod(root,preorder);

        System.out.print("The preOrder Traversal is : ");
        for (int i = 0; i < preorder.size(); i++) {
            System.out.print(preorder.get(i) + " ");
        }

    }
}
