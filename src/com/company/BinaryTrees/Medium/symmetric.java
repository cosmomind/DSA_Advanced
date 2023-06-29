package com.company.BinaryTrees.Medium;


import java.util.ArrayList;

public class symmetric {
    public static boolean issym(Node rootl,Node rootr){
        if(rootl == null || rootr == null){
            return rootl == rootr;
        }

        if(rootl.data != rootr.data  ){
            return false;

        }
        if(issym(rootl.left,rootr.right) == false || issym(rootl.right,rootr.left) == false ) return false;

        return true;

    }
    public static boolean isSymmetric(Node root)
    {
        // add your code here;
        if(root == null || issym(root.left,root.right)) return true;
        else return false;
    }
    public static void main(String args[]) {

        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(10);
        root.left.left = new Node(30);
        root.left.right = new Node(20);
        root.right.left = new Node(30);
       // root.left.right = new Node(20);
        boolean ans;
        ans = isSymmetric(root);
        System.out.println(ans);

    }

}
