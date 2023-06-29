package com.company.Graphs.Learning;

import java.util.ArrayList;

public class dfs {
    //t.c ->o(v),s.c ->o(v+e)
    public void dfs(int node,boolean[] vis,ArrayList<Integer> dfs,
                    ArrayList<ArrayList<Integer>> adj) {

        dfs.add(node);
        vis[node] = true;

        for(Integer i:adj.get(node)){
            if(vis[i] != true){
                dfs(i,vis,dfs,adj);
            }
        }



    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<Integer> dfs = new ArrayList<>();
        boolean[] vis = new boolean[V];

        dfs(0,vis,dfs,adj);

        return dfs;

    }
}
