package com.company.BST.problem;

public class bst_frompre {
    //t.c -> o(h),s.c->o(1)
    int t = 0 ;
    public TreeNode gettree(int up,int[] arr){
        if(t == arr.length  || arr[t] > up) return null;

        TreeNode root = new TreeNode(arr[t++]);
        root.left = gettree(root.val,arr);
        root.right = gettree(up,arr);
        return root;


    }

    public TreeNode bstFromPreorder(int[] preorder) {

        t = 0;
        return gettree(Integer.MAX_VALUE,preorder);


    }
}
