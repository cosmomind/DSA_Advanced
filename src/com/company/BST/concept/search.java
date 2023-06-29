package com.company.BST.concept;

class Node{
    int data;
    Node left;
    Node right;
    public Node(int key){
        data = key;
        left = right = null;
    }
}
public class search {
    boolean search(Node root, int x) {
        // Your code here
        if(root.data == x) return true;

        while(root != null){
            if(root.data == x)return true;
            if(x > root.data) root = root.right;
            else root = root.left;

        }

        return false;
    }
}
