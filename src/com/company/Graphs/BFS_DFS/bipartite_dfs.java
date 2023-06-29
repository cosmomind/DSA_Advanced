package com.company.Graphs.BFS_DFS;

import java.util.ArrayList;
//t.c ->o(v+2e),s.c -> o(v)
public class bipartite_dfs {

    public static boolean dfs(int node,int curr_color, ArrayList<ArrayList<Integer>>adj,int[] color){
        //here u need curr_color,or else how will you store the color of the very first node
        for(Integer i: adj.get(node)){
            if(color[i] == -1){
                color[i] = 1 - curr_color;//mark as visited with color
                if(dfs(i,1 - curr_color,adj,color)  == false) return false;;
            }
            else{
                if(color[i] == curr_color){
                    return false;
                }
            }


        }
        return true;

    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {

        int[] color = new int[V];
        for(int i=0;i < V;i++) color[i] = -1;

        for(int j = 0; j< V;j++){
            if(color[j] == -1){
                color[j] = 0;
                if(dfs(j,0,adj,color) == false) return false;
            }
        }

        return true;



    }


}
