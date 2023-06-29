package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//s.c,t.c ->o(n)
public class Levelorder {
    public List<Integer> levelOrder(Node root) {

        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> ans  =new ArrayList<>();

        if(root == null){
            return ans;
        }
        q.offer(root);
        while (!q.isEmpty()){
            if(q.peek().left != null){
                q.offer(q.peek().left);
            }
            if(q.peek().right != null){
                q.offer(q.peek().right);
            }
            ans.add(q.poll().data);

        }

        return ans;
    }
}
