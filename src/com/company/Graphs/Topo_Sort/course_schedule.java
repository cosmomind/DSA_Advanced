package com.company.Graphs.Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//s.c ->o(3n),t.c->o(v+e)
public class course_schedule {

    static int[] getans(int[] indegree,Queue<Integer> q,ArrayList<ArrayList<Integer>> adj){
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
        if(count == adj.size())return ans;
        return new int[0];
    }
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prereq)
    {
        //if using dfs,cycle detection and ordering
        //bfs - just kahn's algo
        Queue<Integer> q = new LinkedList<>();

        //creating adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0;i< m;i++){

            adj.get(prereq.get(i).get(1)).add(prereq.get(i).get(0));

        }

        int indegree[] = new int[n];

        //indegree
        for(int i = 0;i< n;i++){
            for(Integer j: adj.get(i)){
                indegree[j]++;
            }
        }



        for(int i = 0;i< n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        // int[] res =
        // if(res.length == n) return res;

        return getans(indegree,q,adj);
    }
    public static void main(String[] args) {

        int n = 4; int m = 4;
        int[][] adj = {{1, 0},
                {2, 0},
                {3, 1},
                {3, 2}};
            Queue<Integer> q = new LinkedList<>();
            //if using dfs,cycle detection and ordering
            //bfs - just kahn's algo

            int indegree[] = new int[n];int[] ans = new int[n];

            for(int i = 0;i< m;i++){
                for(int j = 1;j< adj[i].length;j++){
                 //   int num = adj[i][j];
                    indegree[adj[i][j]]++;
                }
            }

            for(int k = 0 ;k<n;k++){
                System.out.println(indegree[k]);
            }


    }
}
