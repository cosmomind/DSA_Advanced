package com.company.BinaryTrees.Hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
//s.c,t.c ->o(n)
public class burn_tree {
    public static Node markparent(Map<Node,Node> map, Node root, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);Node ans = new Node(0);


        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0 ;i< n;i++){
                Node curr = q.poll();
                if(curr.data == target) ans = curr;
                if(curr.left!= null){
                    q.offer(curr.left);
                    map.put(curr.left,curr);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                    map.put(curr.right,curr);//child,parent
                }
            }


        }
        return ans;
    }
    public static int minTime(Node root, int target)
    {
        // Your code goes here
        Map<Node,Node> map = new HashMap<>();
        Node temp = markparent(map,root,target);
        Queue<Node> q = new LinkedList<>();
        Map<Node,Boolean> visited = new HashMap<>();
        int time = 0;
        q.offer(temp);
        visited.put(temp,true);
        while(!q.isEmpty()){
            int n = q.size();int flag = 0;
            for(int i = 0;i< n;i++){

                Node curr = q.poll();
                if(curr.left!= null && visited.get(curr.left) == null){
                    flag = 1;
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right != null && visited.get(curr.right) == null){
                    flag = 1;
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(map.get(curr) != null && visited.get(map.get(curr)) == null){
                    flag = 1;
                    q.offer(map.get(curr));
                    visited.put(map.get(curr),true);
                }

            }
            if(flag == 1) time++;

        }
        return time;

    }
}
