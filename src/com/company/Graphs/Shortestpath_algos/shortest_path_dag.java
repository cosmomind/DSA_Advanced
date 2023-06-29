package com.company.Graphs.Shortestpath_algos;

import java.util.ArrayList;
import java.util.Stack;

class Pairs{
    int adj,wt;
    Pairs(int adj,int wt){
        this.adj = adj;
        this.wt = wt;
    }

}
public class shortest_path_dag {
//t.c,s.c -> o(n+m)
    public void dfs(int j, int[] vis, Stack<Integer> s, ArrayList<ArrayList<Pairs>> adjl){

        vis[j] = 1;
        for(Pairs i:adjl.get(j)){
            int adjn = i.adj;
            if(vis[adjn] != 1){
                dfs(adjn,vis,s,adjl);
            }
        }
        s.push(j);
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        ArrayList<ArrayList<Pairs>> adjl = new ArrayList<>();
        for(int i = 0;i< N;i++){
            adjl.add(new ArrayList<Pairs>());
        }

        for(int i = 0;i<M;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adjl.get(u).add(new Pairs(v,wt));
        }

        //dfs - topo sort;
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[N];

        for(int j = 0;j< N;j++){
            if(vis[j] != 1){
                dfs(j,vis,s,adjl);
            }
        }

        int[] dis = new int[N];
        for(int i = 0;i< N;i++)
        {
            dis[i] = Integer.MAX_VALUE;
        }
        int src = 0;

        while(!s.isEmpty()){
            if(s.peek() == src){break;}
            else s.pop();
        }
        dis[s.peek()] = 0;

        while(!s.isEmpty()){
            int num = s.pop();
            int dis_node = dis[num];
            for(Pairs p:adjl.get(num)){
                int adjn = p.adj;
                int adjwt = p.wt;
                if(dis_node + adjwt < dis[adjn]){
                    dis[adjn] = dis_node + adjwt ;
                }
            }
        }

        for(int j = 0;j< N;j++){
            if(dis[j] == Integer.MAX_VALUE){
                dis[j] = -1;
            }
        }

        return dis;
    }
}
