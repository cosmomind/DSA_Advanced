package com.company.DP.oneD;

public class fibonacci {
    //s.c ->o(n)
    //t.c ->o(n)
    static long mem(int n,long[] dp){
        if(n <= 1) return n % 1000000007;

        if(dp[n] != -1) return dp[n]% 1000000007;

        return dp[n] = (mem(n-1,dp) + mem(n-2,dp))% 1000000007;


    }

    static long topDown(int n) {
        long[] dp = new long[n+1];
        for(int i = 0;i <= n;i++)dp[i] = -1;

        return mem(n,dp);

    }

    static long bottomUp(int n) {
        //tabulation;
        long[] dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            dp[i] = (dp[i-1]+dp[i-2]) % 1000000007;
        }

        return dp[n] % 1000000007;
    }
}
