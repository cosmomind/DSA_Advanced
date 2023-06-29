package com.company.BinaryTrees.Hard;
////s.c -> o(n),t.c ->o(n*n)
public class in_post_uniqueBT {

    static int getindex(int val,int[] in){
        int[] arr = new int[in.length];int c =0;
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

    static Node build(int[] post,int pos,int poe,int[] in,int ins,int ine){

        if(pos > poe) return null;

        Node root = new Node(post[poe]);
        int inroot = getindex(root.data,in);
        int numsright = ine - inroot ;

        root.right = build(post,poe - numsright,poe-1,in,inroot+1,ine);

        root.left = build(post,pos,poe-numsright-1,in,ins,inroot-1);


        return root;
    }
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Your code here

        Node root = build(post,0,n-1,in,0,n-1);


        return root;

    }
}
