package com.company.BST.concept;

public class intro {
    static boolean isBSTTraversal(int nums[]) {
        // code here
        for(int i = 0;i< nums.length-1;i++){
            if(nums[i] >= nums[i+1]) return false;
        }
       //inorder traversal of binary search tree is sorted
        return true;
    }
}
