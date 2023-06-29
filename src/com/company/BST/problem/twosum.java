package com.company.BST.problem;

import java.util.Stack;
//t.c -> o(n)
//s.c ->o(h)*2
class BSTIter{
    Stack<TreeNode> s = new Stack<>();
    boolean reverse = true;

    public BSTIter(TreeNode root,boolean rev){
        reverse = rev;
        pushall(root);
    }

    public void pushall(TreeNode root){

        while(root != null){
            s.push(root);
            if(reverse){
                // s.push(root.right);
                // root = root.right;
                //not checking root.right is null
                root = root.right;
            }
            else{

                root = root.left;
            }
        }
    }
    public int next(){
        TreeNode ans =  s.pop();
        if(reverse){
            pushall(ans.left);
        }
        else{
            pushall(ans.right);
        }
        return ans.val;
    }


}
public class twosum {

    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }

        BSTIter a = new BSTIter(root,false);
        BSTIter d = new BSTIter(root,true);

        int i = a.next();
        int j = d.next();

        while(i < j){//no = because bst doesn't hav duplicate
            if((i + j) == k) return true;
            else{
                if((i+j) > k) j = d.next();
                else i = a.next();
            }
        }
        return false;

    }
}
