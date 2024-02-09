package com.company.BinaryTrees.Medium;

public class balanced {
    //naive approach , t.c -> o(n*n),s.c -> o(n)
    int getdepth(Node root){
        if(root == null){
            return 0;
        }
        int  lh = getdepth(root.left);
        int  rh = getdepth(root.right);

        return 1 + Math.max(lh,rh);
    }
    boolean isBalanced(Node node)
    {

        if(node == null){
            return true;
        }

        int lh = getdepth(node.left);
        int rh = getdepth(node.right);

        if(Math.abs(lh- rh) > 1 || !isBalanced(node.left) || !isBalanced(node.right)){
            return false;
        }
        return true;


    }

    //optimized,t.c -> o(n),s.c ->o(n)
    int getdepth1(Node root){
        if(root == null){
            return 0;
        }
        int  lh = getdepth(root.left);
        int  rh = getdepth(root.right);

        if(lh == -1 || rh == -1){
            return -1;
        }
        if(Math.abs(lh - rh) > 1){
            return -1;
        }

        return 1+ Math.max(lh,rh);
    }
    boolean isBalancedd(Node node1)
    {  if(getdepth1(node1) == -1) return false;
        return true;

    }
}
