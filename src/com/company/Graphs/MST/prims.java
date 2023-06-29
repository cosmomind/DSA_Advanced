package com.company.Graphs.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class MST{
    int node;
    int wt;

    MST(int node,int wt){
        this.node = node;
        this.wt = wt;
    }
//t.c -> o(e*loge)
    //s.c ->o(v)+o(e)
}
public class prims {
    static int spanningTree(int V, int E, int edges[][]){

        PriorityQueue<MST> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0;i< V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0;i< edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,weight)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u,weight)));
        }

        int[] vis = new int[V];
        int sum = 0;
        pq.offer(new MST(0,0));

        while(!pq.isEmpty()){
            int curr_node = pq.peek().node;
            int curr_wt = pq.peek().wt;
            pq.poll();

            if(vis[curr_node] == 1)continue;
            //there is no point in going ahead if vis is 1 becuz all adjacent
            //nodes have already been visited
            vis[curr_node] = 1; sum += curr_wt;


            for(ArrayList<Integer> k:adj.get(curr_node)){
                int adj_node = k.get(0);
                int w =  k.get(1);
                if(vis[adj_node] != 1){
                    //here we are not marking it as visited because this edge may not be the minimum one
                    //and hence may not be included in the prim's algo
                    pq.offer(new MST(adj_node,w));
                }

            }



        }
        return sum;

    }



    public static void main(String[] args) {
        int[][] edges ={{0,1,2},
                {0,2,1},
                {2,1,1},
                {2,4,2},
                {2,3,2},
                {3,4,1 }};
        spanningTree(5,6,edges);
    }
}
