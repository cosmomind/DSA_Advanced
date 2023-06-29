package com.company.BST.problem;

public class insertion {
    //t.c -> o(log2n) log to base 2
    Node insert(Node prev, int key) {
        // your code here
        if(prev == null) return new Node(key);

        Node root = prev;
        while(true){

            if(root.data > key){
                if(root.left != null) root = root.left;
                else{
                    root.left = new Node(key);
                    break;
                }
            }

            else if(root.data < key){
                if(root.right != null) root = root.right;
                else{
                    root.right =  new Node(key);
                    break;
                }
            }

            else {
                return prev;
            }


        }
        return prev;
    }
}
