package com.company.BinaryTrees.Hard;

import java.util.LinkedList;
import java.util.Queue;
//s.c-> o(n),t.c->o(n)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }


class Pair{
    TreeNode node;
    int num;
    public Pair(TreeNode node,int i){
        this.node = node;
        num = i;

    }
}


class  max_width{

    public int widthOfBinaryTree(TreeNode root) {

        if(root == null){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,0));
        int ans = 0;
        while(!q.isEmpty()){
            int n = q.size();
            int min_level = q.peek().num;
            int f = 0;int l =0;
            for(int i = 0;i < n;i++){
                int curr_id = q.peek().num - min_level;
                TreeNode temp = q.poll().node;
                if(i == 0) f = curr_id;
                if(i == n-1) l = curr_id;
                if(temp.left != null) q.offer(new Pair(temp.left,2*curr_id+1));
                if(temp.right != null) q.offer(new Pair(temp.right,2*curr_id+2));

            }

            ans = Math.max(ans,l-f+1);

        }


        return ans;

    }
}
