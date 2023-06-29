package com.company.BinaryTrees.Hard;

public class uniqueBT {
    public static boolean isPossible(int a, int b){
        // Code here
        //inorder traversal + pre/post
        //2 inorder traversals
        if(a == 2 && b == 2){
            return false;
        }
        if(a == 2 || b == 2) return true;

        return false;
    }
}
