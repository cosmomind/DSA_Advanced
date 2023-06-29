package com.company.Graphs.Other_algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bridges {
//s.c ->o(v+2e) + o(3n)
    //t.c -> o(v+2e)
    static int timer = 1;
    static void dfs(int node, int par, ArrayList<List<Integer>> bridges, ArrayList<ArrayList<Integer>> adj,
                    int[] vis, int[] toi, int[] low){
        vis[node] = 1;

        toi[node] = timer;
        low[node] = timer;
        timer++;
        for(Integer j:adj.get(node)){
            if(j == par) continue;
            if(vis[j] != 1){

                dfs(j,node,bridges,adj,vis,toi,low);
                low[node] = Math.min(low[node],low[j]);
                //if low of adj is greater than insertion of node,it is bridge

                if(low[j] > toi[node]){
                    bridges.add(Arrays.asList(j,node));
                }

            }
            else{
                low[node] = Math.min(low[node],low[j]);
            }

        }


    }
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here

        ArrayList<List<Integer>> bridges = new ArrayList<>();
        int[] vis = new int[V];
        int[] toi = new int[V];
        int[] low = new int[V];

        for(int i = 0;i< V;i++){
            if(vis[i] != 1)  dfs(i,-1,bridges,adj,vis,toi,low);

        }


        for(int i = 0; i< bridges.size();i++){
            int a = bridges.get(i).get(0);
            int b = bridges.get(i).get(1);

            if((a == c && b == d) || (a == d && b == c)) return 1;

        }
        return 0;




    }
}
