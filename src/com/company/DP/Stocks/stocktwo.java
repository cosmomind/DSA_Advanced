package com.company.DP.Stocks;

import java.util.Arrays;

public class stocktwo {
    //t.c -> o(n*2*3);
    //s.c -> o(n*2*3) + o(n);
    public static int getans(int[][][] dp,int[] prices,int ind,int buy,int cap) {
        if(cap == 0) return 0;
        if(ind == prices.length)return 0;
        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + getans(dp,prices,ind+1,0,cap),
                    0 +  getans(dp,prices,ind+1,1,cap));
        }
        else{
            profit = Math.max(prices[ind] + getans(dp,prices,ind+1,1,cap-1),
                    0 +  getans(dp,prices,ind+1,0,cap));
        }
        return dp[ind][buy][cap]  = profit;

    }



    public int maxProfit(int[] prices) {
        //t.c -> o(n*2*3);
        //s.c -> o(n*2*3) + o(n);
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] a:dp){
            for(int[] arr:a){
                Arrays.fill(arr,-1);
            }
        }

        return getans(dp,prices,0,1,2);


    }

    public int maxProfittab(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];


        for(int i = 0;i <= 1;i++){
            for(int j = 0;j <= 2;j++){
                dp[n][i][j] = 0;
            }
        }
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= 1;j++){
                dp[i][j][0] = 0;
            }
        }

        for(int i = n-1;i >= 0;i--){
            for(int j = 0;j <= 1;j++){
                for(int k = 1;k <= 2;k++){

                    if(j == 1){
                        dp[i][j][k] = Math.max(-prices[i]+dp[i+1][0][k],
                                0+dp[i+1][1][k]);
                    }
                    else{
                        dp[i][j][k] = Math.max(prices[i]+dp[i+1][1][k-1],
                                0+dp[i+1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][2];


    }

    public int maxProfitsp(int[] prices) {
        //t.c -> o(n*2*3);
        //s.c -> o(1) ;
        int n = prices.length;

        int[][] prev = new int[2][3];
        int[][] curr = new int[2][3];

        for(int i = 0;i <= 1;i++){
            for(int j = 0;j <= 2;j++){
                prev[i][j] = 0;
            }
        }


        for(int i = n-1;i >= 0;i--){
            curr = new int[2][3];

            for(int j = 0;j <= 1;j++){
                curr[j][0] = 0;
                for(int k = 1;k <= 2;k++){

                    if(j == 1){
                        curr[j][k] = Math.max(-prices[i]+prev[0][k],
                                0+prev[1][k]);
                    }
                    else{
                        curr[j][k] = Math.max(prices[i]+prev[1][k-1],
                                0+prev[0][k]);
                    }
                }

            }
            prev = curr;
        }
        return prev[1][2];


    }
}
