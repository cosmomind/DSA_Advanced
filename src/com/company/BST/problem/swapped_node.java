package com.company.BST.problem;

public class swapped_node {
    //t.c -> o(n),s.c ->o(1)
    TreeNode first;
    TreeNode last;
    TreeNode middle;
    TreeNode prev;


    public void getans(TreeNode root) {
        if(root == null) return;

        getans(root.left);
        if(prev.val > root.val){
            if(first != null) last = root;
            else{
                first = prev;
                middle = root;
            }
        }

        prev = root;

        getans(root.right);


    }

    public void recoverTree(TreeNode root) {
        last = middle = first = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        getans(root);

        if(last == null){

            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
        else{
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }
}
