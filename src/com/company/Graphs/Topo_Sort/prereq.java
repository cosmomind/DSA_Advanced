package com.company.Graphs.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class prereq {
    //s.c ->o(2n),t.c->o(v+e)
    static boolean getans(int[] indegree, Queue<Integer> q, ArrayList<ArrayList<Integer>> adj){
        int k= 0;int count = 0;  int[] ans = new int[adj.size()];
        while(!q.isEmpty()){
            int num = q.poll();

            for(Integer i:adj.get(num)){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.offer(i);
                }
            }
            count++;
            ans[k++] = num;

        }
        if(count == adj.size())return true;
        return false;
    }


    public boolean isPossible(int N, int[][] prereq)
    {
        Queue<Integer> q = new LinkedList<>();

        //creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < N;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0;i< prereq.length;i++){

            adj.get(prereq[i][1]).add(prereq[i][0]);

        }

        int indegree[] = new int[N];

        //indegree
        for(int i = 0;i< N;i++){
            for(Integer j: adj.get(i)){
                indegree[j]++;
            }
        }



        for(int i = 0;i< N;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }



        return getans(indegree,q,adj);

    }
}
