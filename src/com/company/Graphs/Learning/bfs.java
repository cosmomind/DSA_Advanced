package com.company.Graphs.Learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    //t.c ->o(v),s.c ->o(v+e)
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here


        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];

        q.offer(0);
        vis[0] = true;

        while(!q.isEmpty()){
            int ans = q.poll();
            bfs.add(ans);

            for(Integer i:adj.get(ans)){
                if(vis[i] == false){
                    vis[i] = true;
                    q.offer(i);
                }

            }



        }
        return bfs;
    }
}
