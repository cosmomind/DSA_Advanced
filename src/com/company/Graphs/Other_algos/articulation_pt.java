package com.company.Graphs.Other_algos;

import java.util.ArrayList;
import java.util.List;

public class articulation_pt {

//s.c ->o(3n)
    //t.c -> o(v+2e)
    static int timer = 1;
    static void dfs(int node,int par, ArrayList<List<Integer>> bridges,ArrayList<ArrayList<Integer>> adj,
                    int[] vis,int[] toi,int[] low,int[] mark){
        vis[node] = 1;

        toi[node] = timer;
        low[node] = timer;
        timer++;
        int child = 0;
        for(Integer j:adj.get(node)){
            if(j == par) continue;
            if(vis[j] != 1){

                dfs(j,node,bridges,adj,vis,toi,low,mark);//asking if j is a articulation point
                low[node] = Math.min(low[node],low[j]);
                //if low of adj is greater than insertion of node,it is bridge

                if(low[j] >= toi[node] && par != -1 ){
                    mark[node]  = 1;
                }
                child++;

            }
            else{
                low[node] = Math.min(low[node],toi[j]);
            }

        }

        if(child > 1 && par == -1) mark[node] = 1;

    }

    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {


        ArrayList<List<Integer>> bridges = new ArrayList<>();
        int[] vis = new int[V];
        int[] toi = new int[V];
        int[] low = new int[V];
        int[] mark  = new int[V];

        for(int i = 0;i< V;i++){
            if(vis[i] != 1)  dfs(i,-1,bridges,adj,vis,toi,low,mark);

        }


        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i< V;i++){
            if(mark[i] == 1){
                ans.add(i);
            }

        }
        if(ans.size() == 0) ans.add(-1);
        return ans;

    }
}
