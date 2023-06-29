package com.company.Graphs.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//t.c->o(n),s.c ->o(v+e)
public class kahn_algo {
    public static int[] getans(int[] indegree, ArrayList<ArrayList<Integer>> adj, Queue<Integer> q,int[] ans){

        int k = 0;
        while(!q.isEmpty()){
            int num = q.poll();
            ans[k++] = num;
            for(Integer i:adj.get(num)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
        }
        return ans;

    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] ans = new int[V];
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
        return getans(indegree,adj,q,ans);}
}
