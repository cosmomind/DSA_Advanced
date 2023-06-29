package com.company.BinaryTrees.Medium;

public class identical {
    //t.c,s.c -> o(n)
    boolean isIdentical(Node root1, Node root2)
    {
        // Code Here
        if(root1 == null && root2 == null){
            return true;
        }

        if(root1 == null || root2 == null||root1.data != root2.data){
            return false;
        }

        boolean l = isIdentical(root1.left, root2.left);
        boolean r =  isIdentical(root1.right, root2.right);
        if(l == false || r == false){
            return false;
        }
        return true;

    }
}
