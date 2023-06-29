package com.company.stack_queue.stack9_4;

import java.util.LinkedList;
import java.util.Queue;
//s.c,t.c = o(n*m)
public class rottenorange {
    public int orangesRotting(int[][] grid)
        {
            // Code here
            if(grid == null|| grid.length == 0){
                return 0;
            }
            int n = grid.length;
            int m = grid[0].length;

            int cf = 0;
            Queue<int[]> q = new LinkedList<>();

            for(int i = 0;i< n;i++){
                for(int j = 0;j < m ; j++){
                    if(grid[i][j] == 2){
                        q.offer(new int[]{i,j});

                    }

                    if(grid[i][j] != 0){
                        cf += 1;
                    }
                }
            }

            if(cf == 0)return 0;

            int time = 0;int cp = 0;
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};


            while(!q.isEmpty()){//for each level
                int siz = q.size();
                cp += siz;
                for(int j = 0;j< siz;j++){
                    int[] p = q.poll();

                    for(int i = 0;i< 4;i++){
                        int x = p[0] + dx[i];
                        int y = p[1] + dy[i];

                        if(x<0 ||  y<0 || x >= n|| y >= m|| grid[x][y] == 2|| grid[x][y] == 0){

                            continue;
                        }


                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});

                    }
                }
                if(!q.isEmpty()){
                    time ++;
                }



            }
            if(cf != cp){
                return -1;
            }
            return time;




        }
    }

