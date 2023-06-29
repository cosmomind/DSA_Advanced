package com.company.Graphs.BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;

//s.c,t.c ->o(n*m)
public class distinct_island {
    public static void dfs(int crow,int ccol,ArrayList<String> arr,int[][] grid,
                           int[][] vis,int rowz,int colz){

        int n = grid.length;
        int m = grid[0].length;
        //arr.add(toString(crow,ccol));
        int[] delrow ={1,0,-1,0};
        int[] delcol = {0,1,0,-1};
        for(int i = 0; i< 4;i++){
            int newr = crow + delrow[i];
            int newc = ccol + delcol[i];

            if(newr >= 0 && newc >= 0 && newr <n &&
                    newc < m && grid[newr][newc] == 1
                    && vis[newr][newc] == 0){
                vis[newr][newc] = 1;
                arr.add(toString(newr - rowz,newc - colz));
                dfs(newr,newc,arr,grid,vis,rowz,colz);
            }

        }



    }

    public static String toString(int r,int c){
        return Integer.toString(r)+Integer.toString(c);
    }
    static int  countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        HashSet<ArrayList<String>> st = new HashSet<>();

        for(int i = 0;i< n;i++){
            for(int j = 0;j < m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    ArrayList<String> arr = new ArrayList<>();

                    vis[i][j] = 1;
                    dfs(i,j,arr,grid,vis,i,j);
                    st.add(arr);
                }

            }
        }
        return st.size();
    }

    public static void main(String[] args) {
        int[][] grid ={{1, 1, 0, 0, 0 },{1, 1, 0, 0, 0},{0, 0, 0, 1, 1},{0, 0, 0, 1, 1}};
        countDistinctIslands(grid);
    }

}
