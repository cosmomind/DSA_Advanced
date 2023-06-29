package com.company.Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//s.c -> o(n),t.c ->o(v+e)
class Pairr{
    int node;
    int par;
    Pairr(int node,int par){
        this.node = node;
        this.par = par;
    }
}
public class cycle_bfs {
    public boolean bfs(ArrayList<ArrayList<Integer>> adj,
                       int v,int[] vis){
        Queue<Pairr> q   = new LinkedList<>();
        q.offer(new Pairr(v,-1));
        vis[v] = 1;


        while(!q.isEmpty()){
            int curr_node = q.peek().node;
            int parent = q.peek().par;
            q.poll();

            for(Integer i:adj.get(curr_node)){
                if(vis[i] != 1){
                    vis[i] = 1;
                    q.offer(new Pairr(i,curr_node));
                }
                else if(parent != i){
                    return true;
                }



            }


        }
        return false;



    }



    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] vis = new int[V];
        for(int i = 0; i< V;i++){

            if(vis[i] != 1){
                if(bfs(adj,i,vis)) return true;//pass 'i' here because of connected components
            }
        }
        return false;
    }
}
