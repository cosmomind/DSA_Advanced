package com.company.BST.problem;
class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        data = key;
        left = right = null;
    }
}

//t.c -> o(log2n) log to base 2
public class ceil {
    int findCeil(Node root, int key) {

        // Code here
        int ceil = -1;
        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(root.data > key){
                ceil = root.data;
                root = root.left;

            }
            else{
                root = root.right;
            }
        }
        return ceil;
    }
}
