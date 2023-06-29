package com.company.Graphs.Topo_Sort;

import java.util.ArrayList;
import java.util.Stack;

public class top_sort {
    //s,c ->o(n),t.c ->o(v+e)
    public static void topo(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> s){

        for(Integer i:adj.get(node)){
            if(vis[i] != 1){
                vis[i] = 1;
                topo(i,vis,adj,s);
            }
        }
        s.push(node);


    }
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[V];int[] ans = new int[V];
        for(int  i = 0;i< V;i++){
            if(vis[i] != 1){
                vis[i] = 1;
                topo(i,vis,adj,s);
            }

        }



        int k = 0;
        while(!s.isEmpty()){
            ans[k++] = s.pop();
        }

        return ans;
    }
}
