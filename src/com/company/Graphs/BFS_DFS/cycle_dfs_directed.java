package com.company.Graphs.BFS_DFS;

import java.util.ArrayList;

public class cycle_dfs_directed {
    //t.c -> o(v+e),s.c ->o(2n)
    public boolean dfs(int i, int V, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path){

        for(Integer node: adj.get(i)){
            if(vis[node] != 1){
                vis[node] = 1;
                path[node] = 1;
                if(dfs(node,V,adj,vis,path)) return true;
            }
            else if(path[node] == 1) return true;//don't put false condition here u idiot
        }
        path[i] = 0;
        return false;

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here

        int[] vis = new int[V];
        int[] pathvis = new int[V];

        for(int i = 0;i< V;i++){
            if(vis[i] == 0){
                vis[i] = 1;
                pathvis[i] = 1;
                if(dfs(i,V,adj,vis,pathvis)) return true;;
            }
        }
        return false;
    }
}
