package com.company.Graphs.Shortestpath_algos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//t.c,s.c ->o(n+m)
public class shortest_path_undirected_unit {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i< n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
        Queue<Integer> q = new LinkedList<>();
        int[] dis = new int[n];
        for(int i = 0;i< n;i++){
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src]= 0;
        q.offer(src);
        while(!q.isEmpty()){
            int num = q.poll();
            for(Integer i:adj.get(num)){
                if(dis[i] == Integer.MAX_VALUE){
                    dis[i] = dis[num] + 1;
                    q.offer(i);
                }
            }
        }
        for(int i = 0;i< n;i++){
            if(dis[i] == Integer.MAX_VALUE) dis[i] = -1;
        }
        return dis;
    }
}
