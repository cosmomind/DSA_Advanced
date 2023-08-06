package com.company.DP.Stocks;

public class buyselletocks {
//t.c -> o(n)
    //s.c -> o(1)
    public int maxProfit(int[] prices) {
        int profit = 0 ;
        int min = prices[0];
        for(int i = 0;i < prices.length;i++){
            profit = Math.max(profit,prices[i] - min);
            min = Math.min(min,prices[i]);
        }
        return profit;
    }
}
