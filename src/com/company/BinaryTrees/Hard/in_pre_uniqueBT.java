package com.company.BinaryTrees.Hard;

//s.c,t.c -> o(n)
import java.util.HashMap;
import java.util.Map;



    //utility function to insert node in the list
    class in_pre_uniqueBT {
        static TreeNode buildTree(int[] preorder, int[] inorder) {
            Map < Integer, Integer > inMap = new HashMap< Integer, Integer >();

            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i);
            }

            TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0,
                    inorder.length - 1, inMap);
            return root;
        }

        static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[]
                inorder, int inStart, int inEnd, Map< Integer, Integer > inMap) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);
            int inRoot = inMap.get(root.val);
            int numsLeft = inRoot - inStart;

            root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder,
                    inStart, inRoot - 1, inMap);
            root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder,
                    inRoot + 1, inEnd, inMap);

            return root;
        }

        static int getindex(int val,int[] in,int[] arr){
            int c =0;
            //deals with duplicate elements
            for(int i = 0 ;i< in.length;i++){
                if(in[i] == val && arr[i] != 1){
                    arr[i] = 1;
                    c = i;
                    break;
                }

            }
            return c;
        }

        static Node build(int[] pre,int pes,int pee,int[] in,int ins,int ine,int[] arr){

            if(pes > pee || ins > ine) return null;

            Node root = new Node(pre[pes]);
            int inroot = getindex(root.data,in,arr);
            int numsleft =  inroot - ins;

            root.left = build(pre,pes+1,pes + numsleft,in,ins,inroot-1,arr);

            root.right = build(pre,pes + numsleft +1,pee,in,inroot+1,ine,arr);


            return root;
        }
        public static void main(String args[]) {

            int inorder[] = {7,3,11,1,17,3,18};
            int preorder[] = {1,3,7,11,3,17,18};
            int  n = preorder.length;
            int[] arr = new int[n];
            Node root = build(preorder,0,n-1,inorder,0,n-1,arr);
        }


}
