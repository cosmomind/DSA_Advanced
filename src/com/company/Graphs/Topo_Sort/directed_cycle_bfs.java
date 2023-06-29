package com.company.Graphs.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class directed_cycle_bfs {
    //t.c ->o(v+e),s.c ->o(2n)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();


        int[] indegree = new int[V];
        for(int i = 0; i< adj.size();i++){
            for(Integer j:adj.get(i)){
                indegree[j]++;
            }
        }

        for(int i = 0;i < V;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        return getans(V,indegree,adj,q);

    }
    public static boolean getans(int V, int[] indegree, ArrayList<ArrayList<Integer>> adj, Queue<Integer> q){

        int k = 0;int count=0;
        while(!q.isEmpty()){
            int num = q.poll();
            count++;
            for(Integer i:adj.get(num)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        if(count == V) return false;
        return true;

    }
}
