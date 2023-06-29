package com.company.Graphs.BFS_DFS;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class color{
    int first,sec;

    color(int first,int sec){
        this.first = first;
        this.sec = sec;
    }

}
//t.c ->o(v+2e),s.c -> o(v)
//No need to store color pair,just color array will give the answer
public class bipartite_bfs {
    public boolean bfs(Queue<color> q,ArrayList<ArrayList<Integer>>adj,int[] color){

        while(!q.isEmpty()){

            int node = q.peek().first;
            int curr_color = q.peek().sec;//not required
            q.poll();

            for(Integer i: adj.get(node)){
                if(color[i] == -1){
                    color[i] = 1 - curr_color;//mark as visited with color
                    q.offer(new color(i,color[i])) ;
                }
                else{
                    if(color[i] == curr_color){//color[i] == color[node]
                         return false;
                    }
                }


            }
        }
        return true;

    }


    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        for(int i=0;i < V;i++) color[i] = -1;
        Queue<color> q = new LinkedList<>();
        for(int j = 0; j< V;j++){
            if(color[j] == -1){
                color[j] = 0;
                q.offer(new color(j,0));

                // if(dfs(j,0,adj,color) == false) return false;
                if(bfs(q,adj,color) == false) return false;
            }
        }

        return true;

    }
}
