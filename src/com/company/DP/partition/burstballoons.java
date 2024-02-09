package com.company.DP.partition;

import java.util.Arrays;

public class burstballoons {
    public static int getans(int[][] dp,int i,int j,int[] arr) {
        //t.c -> o(n^3)
        //s.c -> o((n) + o(n^2)
        if(i > j) return 0;
        if(dp[i][j] != - 1) return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int ind = i;ind <= j;ind++){
            int cost = arr[i-1]*arr[ind]*arr[j+1] + getans(dp,i,ind-1,arr)+
                    getans(dp,ind+1,j,arr);

            max = Math.max(max,cost);
        }

        return dp[i][j] = max;


    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int m = nums.length+2;
        int[] arr = new int[m];arr[0] = 1;
        for(int i = 1; i <= n;i++){
            arr[i] = nums[i-1];

        }
        arr[m-1]= 1;
        int[][] dp = new int[n+1][n+1];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return getans(dp,1,n,arr);


    }
    public int maxCoinstab(int[] nums) {
        //t.c -> o(n^3)
        //s.c -> o(n^2)
        int n = nums.length;
        int m = nums.length+2;
        int[] arr = new int[m];arr[0] = 1;
        for(int i = 1; i <= n;i++){
            arr[i] = nums[i-1];

        }
        arr[m-1]= 1;
        int[][] dp = new int[n+2][n+2];
        for(int i = n; i >= 1;i--){
            for(int j = 1;j <= n;j++){
                if(i > j) continue;
                int max = Integer.MIN_VALUE;
                for(int ind = i;ind <= j;ind++){
                    int cost = arr[i-1]*arr[ind]*arr[j+1] + dp[i][ind-1]+
                            dp[ind+1][j];

                    max = Math.max(max,cost);
                }

                dp[i][j] = max;
            }

        }




        return dp[1][n];




    }
}
