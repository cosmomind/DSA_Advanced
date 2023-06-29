package com.company.BST.problem;


public class valid_BST {
    //t.c->o(n),s.c->o(1)
    boolean findans(TreeNode root,long min,long max){
        if(root == null){
            return true;
        }

        if(min >= root.val || root.val >=  max) return false;


        if(findans(root.left,min,root.val) && findans(root.right,root.val,max))return true;

        return false;

    }
    public boolean isValidBST(TreeNode root) {
        return findans(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

//Morris traversal
    public boolean isValidBST1(TreeNode root) {
        //   return findans(root,Long.MIN_VALUE,Long.MAX_VALUE);
        long min = Long.MIN_VALUE;
        if(root == null) return true;
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                if(curr.val <= min) {
                    return false;
                }
                else{
                    min = curr.val;
                }
                curr = curr.right;
            }
            else{
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    if(curr.val <= min) {
                        return false;
                    }
                    else{
                        min = curr.val;
                    }
                    curr = curr.right;
                }

            }


        }
        return true;
    }
}
