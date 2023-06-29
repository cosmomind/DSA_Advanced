package com.company.BinaryTrees.Hard;

public class children {
    public static int getsum(Node root){
        if(root == null) return 0;
        int sum = root.data;
        int val = 0;
        if(root.left == null && root.right != null){
            val = root.right.data+0;
        }
        else if(root.right == null && root.left != null){
            val = root.left.data+0;
        }
        else{
            val = root.right.data+root.left.data;
        }
        if(sum != val) return 0;



        int l = getsum(root.left);
        int r = getsum(root.right);
        return 1;

    }
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null) return 0;

        if(getsum(root) == 1) return 1;

        return 0;



    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(10);
        isSumProperty(root);

    }
}
