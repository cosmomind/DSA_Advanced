package com.company.Graphs.BFS_DFS;

public class OXMatrix {
//s.c,t.c ->o(n*m)
    public static void dfs(int[][] vis,char[][] a,int r,int c){

        int n = a.length;
        int m = a[0].length;

        int[] delrow ={1,0,-1,0};
        int[] delcol ={0,1,0,-1};

        for(int i = 0;i< 4;i++){
            int newr = r+ delrow[i];
            int newc = c+delcol[i];
            if(newr >= 0 && newc >=0 &&
                    newr <n && newc< m && a[newr][newc] == 'O' && vis[newr][newc] == 0){
                vis[newr][newc] = 1;
                dfs(vis,a,newr,newc);
            }

        }

    }
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        int[][] vis = new int[n][m];
        for(int i =0;i < n;i++){
            for(int j = 0;j< m;j++){
                if(i == 0|| j == 0|| i == n-1|| j == m-1){
                    if(a[i][j] == 'O'){
                        vis[i][j] = 1;
                        dfs(vis,a,i,j);
                    }

                }
                if(a[i][j] == 'X'){
                    vis[i][j] = 1;
                }


            }
        }

        for(int i =0;i < n;i++){
            for(int j = 0;j< m;j++){

                if(a[i][j] == 'O' && vis[i][j] == 0){
                    a[i][j] = 'X';
                }

            }



        }
        return a;


    }
}
