package com.company.Graphs.Shortestpath_algos;

import java.util.ArrayList;
import java.util.PriorityQueue;

class dij{
    int node,dis;
    public dij(int dis,int node){
        this.node = node;
        this.dis = dis;

    }


}
public class dijkstra {
    //t.c ->o(e * log(v))
    //s.c ->o(v*e)
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        PriorityQueue<dij> pq = new PriorityQueue<dij>((x, y) -> x.dis - y.dis);
        int[] dist = new int[V];
        for(int i = 0;i< V;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[S] = 0;
        pq.offer(new dij(0,S));
        while(!pq.isEmpty()){

            int curr_node = pq.peek().node;
            int curr_wt = pq.peek().dis;
            pq.poll();
            for(int i =0;i < adj.get(curr_node).size();i++){//for each adjacent pairs
                int adj_node = adj.get(curr_node).get(i).get(0);
                int adj_dis = adj.get(curr_node).get(i).get(1);
                if(curr_wt + adj_dis < dist[adj_node]){
                    dist[adj_node] = curr_wt + adj_dis;
                    pq.offer(new dij(dist[adj_node],adj_node));
                }

            }
        }
        return dist;
    }

}
