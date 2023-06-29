package com.company.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int nrow;
    int ncol;

    Pair(int nrow,int ncol){
        this.nrow = nrow;
        this.ncol = ncol;
    }
}
//t.c -> o(n*m);s.c ->o(n*m)
public class islands {

    private void bfs(int row,int col,char[][] grid,int[][] vis){

        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        q.offer(new Pair(row,col));
        vis[row][col] = 1;

        while(!q.isEmpty()){
            int crow = q.peek().nrow;
            int ccol = q.peek().ncol;
            q.poll();

            for(int i = -1;i<= 1;i++){
                for(int j = -1;j<= 1;j++){
                    int rneigh = crow + i;
                    int cneigh = ccol +j;

                    if(rneigh >= 0 && rneigh < n &&
                            cneigh >= 0 && cneigh < m && grid[rneigh][cneigh] == '1'
                            &&
                            vis[rneigh][cneigh] == 0){
                        vis[rneigh][cneigh]  = 1;
                        q.add(new Pair(rneigh,cneigh));


                    }



                }

            }



        }




    }

    public int numIslands(char[][] grid) {
        // Code here


        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];//vis
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    //vis[i][j] = 1;
                    bfs(i,j,grid,vis);
                    count++;
                }

            }
        }

        return count;


    }
}
