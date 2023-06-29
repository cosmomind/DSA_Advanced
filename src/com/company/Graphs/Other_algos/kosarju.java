package com.company.Graphs.Other_algos;

import java.util.ArrayList;
import java.util.Stack;

public class kosarju {
    //t.c -> 3*o(v+e)
    //s.c ->o(v+e) + o(v)+o(v)
    public void dfs_sort(int i, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s){

        vis[i] = 1;
        for(int j:adj.get(i)){
            if(vis[j] != 1){
                dfs_sort(j,vis,adj,s);
            }
        }
        s.push(i);
    }

    public void dfs(int i,int[] vis,ArrayList<ArrayList<Integer>> adj){

        vis[i] = 1;
        for(int j:adj.get(i)){
            if(vis[j] != 1){
                dfs(j,vis,adj);
            }
        }

    }


    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //use stack to sort the edges according to finishing time

        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V];
        for(int i = 0; i< V;i++){
            if(vis[i] != 1){
                dfs_sort(i,vis,adj,s);
            }
        }

        //reverse the graph

        ArrayList<ArrayList<Integer>> adj_rev = new ArrayList<>();
        for(int i  = 0;i< V;i++){
            vis[i] = 0;
            adj_rev.add(new ArrayList<>());

        }
        for(int i  = 0;i< V;i++){
            for(int j:adj.get(i)){
                adj_rev.get(j).add(i);
            }

        }

        //traverse using stack and dfs
        int scc = 0;
        while(!s.isEmpty()){
            int num = s.peek();
            s.pop();

            if(vis[num] != 1){
                scc++;
                dfs(num,vis,adj_rev);

            }


        }

        return scc;




    }
}
