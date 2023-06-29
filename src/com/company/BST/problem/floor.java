package com.company.BST.problem;

public class floor {
    //t.c -> o(log2n) log to base 2
    public static int floor(Node root, int x) {
        // Code here
        int floor = -1;

        while(root != null){
            if(root.data == x){
                floor = root.data;
                return floor;
            }
            if(root.data < x){
                floor = root.data;
                root = root.right;
            }
            else{
                root = root.left;
            }


        }
        return floor;
    }
}
