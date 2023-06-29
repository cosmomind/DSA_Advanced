package com.company.BinaryTrees.Medium;

import java.util.ArrayList;
//t.c - >o(n) ;s.c -> o(h)
public class left_rightview {

        //Function to return list containing elements of left view of binary tree.
        ArrayList<Integer> getleft(Node root, ArrayList<Integer> ans, int level){
            if(root == null){
                return ans;
            }
            if(ans.size() == level){
                ans.add(root.data);
            }



            getleft(root.left,ans,level+1);
            getleft(root.right,ans,level+1);
            return ans;
        }

        ArrayList<Integer> leftView(Node root)
        {
            // Your code here
            ArrayList<Integer> ans = new ArrayList<>();
            int level = 0;
            if(root == null){
                return ans;
            }
            return getleft(root,ans,level);

        }


}
