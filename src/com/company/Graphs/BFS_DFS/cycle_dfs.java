package com.company.Graphs.BFS_DFS;

import java.util.ArrayList;
//s.c ->o(n),t.c ->o(n)+o(v+e)
public class cycle_dfs {
    public boolean dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,
                       int[] vis){


        // vis[node] = 1;


        for(Integer i:adj.get(node)){
            if(vis[i] != 1){
                vis[i] = 1;
                if(dfs(i,node,adj,vis)) return true;//if atleast 1 neighbour return true, pass true to upper layers
            }
            else if(parent != i){
                return true;
            }

        }

        return false;

    }


    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        for(int i = 0; i< V;i++){

            if(vis[i] != 1){
                //  if(bfs(adj,i,vis)) return true;
                //pass 'i' here because of connected components
                vis[i] = 1;
                if(dfs(i,-1,adj,vis)) return true;
            }
        }
        return false;
    }
}
