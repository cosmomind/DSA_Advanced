package com.company.Graphs.Shortestpath_algos;

import java.util.ArrayList;

public class bellmanford {
    //t.c ->o(v*e),s.c ->o(v)
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int dis[] = new int[V];
        for(int i = 0;i< V;i++){
            dis[i] = (int)1e8;

        }
        dis[S] = 0;
        for(int i = 0;i< V - 1;i++){
            for(ArrayList<Integer> it:edges){
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);
                if(dis[u] != (int)1e8 &&(dis[u]+ w < dis[v])){
                    dis[v] = dis[u]+ w;
                }
            }
        }


        for(int i = 0;i< 1;i++){
            for(ArrayList<Integer> it:edges){
                int u = it.get(0);
                int v = it.get(1);
                int w = it.get(2);
                if(dis[u] != (int)1e8 &&(dis[u]+ w < dis[v])){
                    int[] arr = new int[]{ -1 };
                    return arr;
                }
            }
        }
        return dis;


    }
}
