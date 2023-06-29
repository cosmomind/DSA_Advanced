package com.company.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
// s.c,t.c ->o(n*m)
class Ppair{
    int row,col;
    Ppair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
public class enclaves {

    public void findans(Queue<Ppair> q, int[][] vis, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;

        int[] delrow = {1,0,-1,0};
        int[] delcol = {0,1,0,-1};


        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            for(int i = 0;i< 4;i++){
                int nr = r+delrow[i];
                int nc = c+delcol[i];

                if(nr >=  0 && nc >= 0 && nr< n&& nc < m && vis[nr][nc] != 1){
                    vis[nr][nc] = 1;
                    q.offer(new Ppair(nr,nc));

                }

            }

        }


    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        Queue<Ppair> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        for(int i =0 ;i < n;i++){
            for(int j = 0;j < m;j++){
                if(i == 0 ||j == 0|| i == n-1|| j == m-1 ){
                    if(grid[i][j] == 1){
                        vis[i][j] = 1;
                        q.offer(new Ppair(i,j));
                    }

                }
                if(grid[i][j] == 0) vis[i][j] = 1;
            }
        }
        findans(q,vis,grid);
        int count = 0;
        for(int k =0 ;k < n;k++){
            for(int l = 0;l < m;l++){

                if(grid[k][l] == 1 && vis[k][l] == 0){
                    count++;
                }

            }
        }

        return count;
    }
}
