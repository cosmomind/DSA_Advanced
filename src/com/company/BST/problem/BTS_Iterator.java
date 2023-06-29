package com.company.BST.problem;

import java.util.Stack;

public class BTS_Iterator {
//s.c -> o(h) ,t.c->o(1)
    Stack<TreeNode> s = new Stack<>();
    public BTS_Iterator(TreeNode root) {
        s.push(root);
        pushall(root);

    }
    public void pushall(TreeNode root){
        while(root.left != null){
            s.push(root.left);
            root = root.left;
        }
    }

    public int next() {
        TreeNode  ans = new TreeNode(0);
        if(!s.isEmpty()) {
            ans = s.pop();
        }

        if(ans.right != null){
            s.push(ans.right);
            pushall(ans.right);
        }

        return ans.val;
    }

    public boolean hasNext() {
        return (!s.isEmpty()) ;
    }
}
