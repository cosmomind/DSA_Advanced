package com.company.Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class provinces {
    //s.c ->o(n);t.c -> o(v+2*e)
    static int bfs(ArrayList<ArrayList<Integer>> ans, int V){
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[V];


        int cnt = 0;
        for(int i = 0;i< V;i++){

            if(vis[i] != true){
                q.add(i);
                while(!q.isEmpty()){
                    int a = q.poll();


                    for(Integer m: ans.get(a)){
                        if(vis[m] != true){
                            vis[m] = true;
                            q.add(m);

                        }
                    }

                }
                cnt++;
            }
        }
        return cnt;

    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i < V;i++){
            ans.add(new ArrayList<Integer>());
        }

        for(int i = 0;i < V;i++){
            for(int j = 0;j < V;j++){
                if(adj.get(i).get(j) == 1 && i != j){
                    ans.get(i).add(j);
                }
            }
        }

        return bfs(ans,V);
    }
}
