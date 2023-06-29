package com.company.Graphs.BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
//s.c,t.c->o(n*m)
class Paair{
    int row,col,dis;

    Paair(int row,int col,int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}
public class separate01_matrix {
    public void findans(Queue<Paair> q, int[][] grid, int[][] disg, int[][] vis){
        int n = grid.length;
        int m = grid[0].length;


        int[] delrow ={1,0,-1,0};
        int[] delcol ={0,1,0,-1};
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c  = q.peek().col;
            int dist = q.peek().dis;
            q.poll();


            disg[r][c] = dist;

            for(int i = 0;i< 4;i++){
                int newr = r+delrow[i];
                int newc = c+delcol[i];

                if(newr >= 0 && newc >= 0 &&
                        newr < n && newc < m &&
                        vis[newr][newc] != 1 && grid[newr][newc] == 0)
                {//before u push into queue put it as visited
                    vis[newr][newc] = 1;
                    q.offer(new Paair(newr,newc,dist+1));}

            }

        }

    }

    public int[][] nearest(int[][] grid)
    {

        //find all 1's and call bfs
        Queue<Paair> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        int[][] dis = new int[grid.length][grid[0].length];
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j < grid[i].length;j++){

                if(grid[i][j] == 1){
                    q.offer(new Paair(i,j,0));
                    vis[i][j] = 1;
                }


            }
        }
        findans(q,grid,dis,vis);

        return dis;
    }
}
