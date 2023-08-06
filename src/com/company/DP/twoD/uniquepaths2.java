package com.company.DP.twoD;

import java.util.ArrayList;

public class uniquepaths2 {
    //t.c -> o(m*n),s.c - > o(m*n) + o((m-1)*(n-1))
    public static int getmemans(int[][] dp,int i, int j,ArrayList<ArrayList<Integer>> mat) {

        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(mat.get(i).get(j) == -1) return 0;
        if(dp[i][j] != - 1) return dp[i][j];

        int up = getmemans(dp,i-1,j,mat) % 1000000007;
        int left = getmemans(dp,i,j-1,mat) % 1000000007;
        return dp[i][j] = (up+left) % 1000000007;



    }
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j =0 ;j< m;j++) dp[i][j] = -1;
        }
        return getmemans(dp,n-1,m-1,mat);
    }

    //here onwards row is m,col is n

    static int mazeObstaclestab(int m, int n, ArrayList<ArrayList<Integer>> mat) {
        //t.c ->o(n*m);s.c ->o(m*n)
        int[][] dp = new int[m][n];



        for(int i = 0;i < m;i++){
            for(int  j = 0;j < n;j++){
                if(i == 0 && j == 0){
                    dp[0][0] = 1;
                    continue;
                }
                if(mat.get(i).get(j) == -1){
                    dp[i][j] = 0;
                    continue;
                }
                int up = 0;int le = 0;
                if(i > 0)  up = dp[i-1][j] % 1000000007;
                if(j > 0)  le = dp[i][j-1] % 1000000007;

                dp[i][j] = (up+le) % 1000000007;
            }
        }

        return dp[m-1][n-1];
    }
}
