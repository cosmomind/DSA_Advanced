package com.company.BinaryTrees.Medium;

import java.util.LinkedList;
import java.util.Queue;

class  Node{
    int data;
    Node left,right;
    Node(int d){
        data = d;
        right = left = null;
    }
}
public class height {
    int height(Node node)
    {
        // code here

        Queue<Node> q = new LinkedList<>();
        q.offer(node);int ans = 0;

        while(!q.isEmpty()){
            ans++;
            int n = q.size();

            for(int i = 0; i< n;i++){
                if(q.peek().left != null){
                    q.offer(q.peek().left);

                }
                if(q.peek().right != null){
                    q.offer(q.peek().right);

                }
                q.poll();
            }



        }
        return ans;
    }
//t.c - >o(n),s.c ->o(n) for both these algos
    public int maxDepth(Node root) {

        if(root == null){
            return 0;
        }

        int  lh = maxDepth(root.left);
        int  rh = maxDepth(root.right);
        int  max = 1+ Math.max(lh,rh);

        return max;

    }
}
