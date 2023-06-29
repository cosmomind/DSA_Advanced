package com.company.BST.problem;
//t.c -> o(n),s.c->o(1)
public class lca {
    Node LCA(Node root, int n1, int n2)
    {
        // code here.
        if(root == null) return null;

        int curr = root.data;
        if(curr < n1 && curr < n2){
            return LCA(root.right,n1,n2);
        }
        if(curr > n1 && curr > n2){
            return LCA(root.left,n1,n2);
        }
        return root;
    }
}
