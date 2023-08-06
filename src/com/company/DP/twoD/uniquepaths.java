package com.company.DP.twoD;

import java.util.ArrayList;

public class uniquepaths {
    //t.c -> o(m*n),s.c - > o(m*n) + o((m-1)*(n-1))
    public static int getmemans(int[][] dp,int i, int j) {
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != - 1) return dp[i][j];

        int up = getmemans(dp,i-1,j);
        int left = getmemans(dp,i,j-1);
        return dp[i][j] = up+left;



    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j =0 ;j< n;j++) dp[i][j] = -1;
        }
        return getmemans(dp,m-1,n-1);
    }

    public static int uniquePathstabulation(int m, int n) {

//t.c ->o(n*m);s.c ->o(m*n)
        int[][] dp = new int[m][n];



        for(int i = 0;i < m;i++){
            for(int  j = 0;j < n;j++){
                if(i == 0 && j == 0){
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;int le = 0;
                if(i > 0)  up = dp[i-1][j];
                if(j > 0)  le = dp[i][j-1];

                dp[i][j] = up+le;
            }
        }

        return dp[m-1][n-1];
    }

    public static int uniquePathsspaceoptimal(int m, int n) {


        int[] prev = new int[n];//top array



//t.c ->o(n*m);s.c ->o(n)
        for(int i = 0;i < m;i++){
            int[] temp = new int[n];
            for(int  j = 0;j < n;j++){
                if(i == 0 && j == 0){
                    temp[0] = 1;
                    continue;
                }
                int up = 0;int le = 0;
                up = prev[j];
                if(j > 0)  le = temp[j-1];

                temp[j] = up+le;
            }
            prev = temp;
        }

        return prev[n-1];
    }


    static int mazeObstaclesspace(int m, int n, ArrayList<ArrayList<Integer>> mat) {

        int[] prev = new int[n];//top array
        //t.c ->o(n*m);s.c ->o(n)
        for(int i = 0;i < m;i++){
            int[] temp = new int[n];
            for(int  j = 0;j < n;j++){
                if(i == 0 && j == 0){
                    temp[0] = 1;
                    continue;
                }
                if(mat.get(i).get(j) == -1){
                    temp[j] = 0;
                    continue;
                }
                int up = 0;int le = 0;
                up = prev[j];
                if(j > 0)  le = temp[j-1]% 1000000007;

                temp[j] = (up+le)% 1000000007;;
            }
            prev = temp;
        }

        return prev[n-1];
    }

}

