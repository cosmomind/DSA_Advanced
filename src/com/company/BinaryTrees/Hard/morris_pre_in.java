package com.company.BinaryTrees.Hard;

import java.util.ArrayList;
//s.c ->o(1);t.c ->o(n)
public class morris_pre_in {
    static ArrayList<Integer> preorder(Node root)
    {
        // Code here
        // ArrayList<Integer> pre  = new ArrayList<>();
        // preod(root,pre);
        ArrayList<Integer> pre = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                pre.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }

                if(prev.right == null){
                    pre.add(curr.data);
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    // in.add(curr.data);
                    curr = curr.right;
                }


            }
        }


        return pre;
    }

    ArrayList<Integer> inOrder(Node root) {
        // Code
        // ArrayList<Integer> in  = new ArrayList<>();
        // inod(root,in);

        ArrayList<Integer> in = new ArrayList<>();
        Node curr = root;
        while(curr != null){
            if(curr.left == null){
                in.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;

                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    in.add(curr.data);
                    curr = curr.right;
                }


            }
        }

        return in;
    }
}
