package com.company.DP.twoD;

public class minpathsum {
    public static int getmemans(int[][] grid,int i,int j,int[][] dp) {
        //t.c -> o(m*n),s.c - > o(m*n) + o((m-1)*(n-1))
        if(i == 0 && j == 0)
        {
            return grid[0][0];

        }
        if(i < 0 || j <0) return (int)Math.pow(10,9);
        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + getmemans(grid,i-1,j,dp);
        int le = grid[i][j] + getmemans(grid,i,j-1,dp);


        return dp[i][j] = Math.min(up,le);

    }

    public static int minSumPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i ++){
            for(int j = 0; j< m;j++) dp[i][j] = -1;
        }

        return getmemans(grid,n-1,m-1,dp);


    }


    public static int minSumPathtab(int[][] grid) {
        //t.c ->o(n*m);s.c ->o(m*n)
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i ++){
            for(int j = 0; j< m;j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[0][0];
                    continue;
                }
                int up =  (int)Math.pow(10,9);int le =  (int)Math.pow(10,9);
                if(i > 0) up =  grid[i][j] + dp[i-1][j];
                if(j > 0) le =  grid[i][j] + dp[i][j-1];

                dp[i][j] = Math.min(up,le);
            }
        }
        return dp[n-1][m-1];


    }


    public static int minSumPathspace(int[][] grid) {
        //t.c ->o(n*m);s.c ->o(n)
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];
        for(int j = 0; j< m;j++){
            prev[j] = (int)Math.pow(10,9);
        }
        for(int i = 0;i < n;i ++){
            int[] temp = new int[m];
            for(int j = 0; j< m;j++){
                if(i == 0 && j == 0){
                    temp[j] = grid[0][0];
                    continue;
                }
                //int up =  (int)Math.pow(10,9);
                int le =  (int)Math.pow(10,9);
                int up  =  grid[i][j] + prev[j];
                if(j > 0) le =  grid[i][j] + temp[j-1];

                temp[j] = Math.min(up,le);
            }
            prev= temp;
        }
        return prev[m-1];


    }

    public static int getMaxPathSum(int[][] m) {
        int n = m.length;
        int col = m[0].length;//columns
        int[] prev = new int[col];

        for(int i = 0;i < col;i++){
            prev[i] = m[0][i];

        }
        for(int i = 1;i < n;i++){
            int[] curr = new int[col];
            for(int j = 0 ;j < col;j++){

                int  up = m[i][j] + prev[j];
                int ld = m[i][j];
                if(j > 0)  ld +=   prev[j-1];
                else ld += (int) Math.pow(-10,9);
                int rd = m[i][j];
                if(j < col-1)  rd += prev[j+1];
                else rd += (int) Math.pow(-10,9);
                curr[j] = Math.max(up,Math.max(ld,rd));
            }
            prev = curr;

        }



        int max = prev[0];
        for (int i = 1; i < col; i++) {
            int ans = prev[i];
            if(ans > max) max = ans;
        }

        return max;
    }

}
