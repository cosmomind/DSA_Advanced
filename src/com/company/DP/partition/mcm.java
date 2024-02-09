package com.company.DP.partition;

import java.util.Arrays;

public class mcm {
    //t.c -> o(n^3)
    //s.c -> o(n^2)+o(n)
    static int getans(int[] arr,int[][] dp,int i,int j){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i;k <= j-1;k++){
            int steps = arr[i-1]*arr[k]*arr[j]+ getans(arr,dp,i,k)+getans(arr,dp,k+1,j);
            min = Math.min(min,steps);
        }
        return dp[i][j] = min;
    }

    public static int mcm(int[] p){
        int n = p.length;
        int[][] dp = new int[n][n];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return getans(p,dp,1,n-1);

    }


}
