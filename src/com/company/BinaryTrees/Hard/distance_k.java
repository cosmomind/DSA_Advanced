package com.company.BinaryTrees.Hard;

import java.util.*;
//s.c ->o(n),s.c ->o(n)
public class distance_k {
    //marking the parents of each node except root node
    public void markparents(Map<Node,Node> parent_track,Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null){
                q.offer(curr.left);
                parent_track.put(curr.left,curr);
                //child ,parent
            }
            if(curr.right != null){
                q.offer(curr.right);
                parent_track.put(curr.right,curr);
                //child ,parent
            }


        }

    }
    public List<Integer> distk(Node root,Node target,int k){
        Map<Node,Node> parents = new HashMap<>();
        markparents(parents,root);
        Queue<Node> q = new LinkedList<>();
        Map<Node,Boolean> visited  = new HashMap<>();

        q.offer(target);
        visited.put(target,true);
        int curr_dist = 0;
        while (!q.isEmpty()){
            int n  = q.size();
            if(curr_dist == k) break;
            curr_dist++;
            for (int i = 0; i < n; i++) {
                Node curr = q.poll();
               if(curr.left != null && visited.get(curr.left) != true){
                   q.offer(curr.left);
                   visited.put(curr.left,true);
               }
                if(curr.right != null && visited.get(curr.right) != true){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parents.get(curr) != null && visited.get(parents.get(curr)) != true){
                    q.offer(parents.get(curr));
                    visited.put(parents.get(curr),true);
                }


            }


        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()){
            Node vall = q.poll();
            ans.add(vall.data);
        }

        return ans;

    }
}
