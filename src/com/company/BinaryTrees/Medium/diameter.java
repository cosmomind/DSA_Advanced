package com.company.BinaryTrees.Medium;

public class diameter {
//naive approach, t.c -> o(n*n);s.c -> o(n)
    int max = 0;
    // Function to return the diameter of a Binary Tree.
    int findd(Node node){
        if(node == null){
            return 0;
        }

        int lh = findd(node.left);
        int rh = findd(node.right);
        return 1+ Math.max(lh,rh);
    }

    int diameter(Node root) {
        // Your code here
        if(root == null){
            return 0;
        }

        int lefth = findd(root.left);
        int righth = findd(root.right);
        max = Math.max(1+lefth+righth,max);
        diameter(root.left);
        diameter(root.right);
        return max;
    }
//optimized t.c -> o(n);s.c -> o(n)
    //in java always pass by value especially for primitives
    //unless we create a new memory allocation for non primitives like array or object copy of the memory reference is passed
int geth(Node node,int[] dia){
    if(node == null){
        return 0;
    }

    int lh = geth(node.left,dia);
    int rh = geth(node.right,dia);
    dia[0] = Math.max(dia[0],1+lh+rh);
    return 1+ Math.max(lh,rh);
}

    int diameter1(Node root) {
        int[] dia = new int[1];
        if(root == null){
            return 0;
        }
        //  int max = 0;
        geth(root,dia);
        return dia[0];
    }



    public static void main(String[] args) {

    }
}
