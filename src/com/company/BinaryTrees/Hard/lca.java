package com.company.BinaryTrees.Hard;

public class lca {
    //t.c -> o(n);s.c ->o(n)
    Node lca(Node root, int n1,int n2)
    {
        // Your code here
        if(root == null){
            return null;

        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node l = lca(root.left,n1,n2);
        Node r = lca(root.right,n1,n2);
        if(l == null && r == null) return null;
        if(l == null && r != null) return r;
        if(r == null && l != null) return l;
        return root;

    }
}


