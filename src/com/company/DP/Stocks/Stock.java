package com.company.DP.Stocks;

import java.util.Arrays;

public class Stock {
    //t.c -> o(n*2)
    //s.c ->  o(n*2) + o(n)
    public static int getans(int[][] dp,int[] prices,int ind,int buy) {
        if(ind == prices.length){
            return 0;
        }
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int profit;
        if(buy == 1){
            profit = Math.max(-prices[ind]+getans(dp,prices,ind+1,0),
                    0+getans(dp,prices,ind+1,1));
        }
        else{
            profit = Math.max(prices[ind]+getans(dp,prices,ind+1,1),
                    0+getans(dp,prices,ind+1,0));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return getans(dp,prices,0,1);//liberty to buy the first days stock

    }

    public int maxProfittab(int[] prices) {
        //t.c -> o(n*2)
        //s.c ->  o(n*2)
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        for(int i = 0;i <= 1;i++) dp[n][i] = 0;

        for(int i = n-1;i >= 0;i--){
            for(int j = 0;j <= 1;j++){
                if(j == 1){
                    dp[i][j] = Math.max(-prices[i]+dp[i+1][0],
                            0+dp[i+1][1]);
                }
                else{
                    dp[i][j] = Math.max(prices[i]+dp[i+1][1],
                            0+dp[i+1][0]);
                }
            }
        }
        return dp[0][1];
    }

    public int maxProfitspace(int[] prices) {
        //t.c -> o(n*2)
        //s.c ->  o(2)
        int n = prices.length;

        int[] prev = new int[2];
        int[] temp = new int[2];
        for(int i = 0;i <= 1;i++) prev[i] = 0;

        for(int i = n-1;i >= 0;i--){
            temp = new int[2];
            for(int j = 0;j <= 1;j++){
                if(j == 1){
                    temp[j] = Math.max(-prices[i]+prev[0],
                            0+prev[1]);
                }
                else{
                    temp[j] = Math.max(prices[i]+prev[1],
                            0+prev[0]);
                }
            }
            prev = temp;
        }
        return prev[1];
    }


}
