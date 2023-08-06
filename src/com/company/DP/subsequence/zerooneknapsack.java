package com.company.DP.subsequence;

public class zerooneknapsack {
    static int memoize(int[] weight, int[] value, int n, int cap,int[][] dp) {
        if(n == 0){
            //single element
            if(weight[n] <= cap){
                return value[n];
            }
            else{
                return 0;
            }

        }
        if(dp[n][cap] != -1) return dp[n][cap];

        int ntake = 0 + memoize(weight,value,n-1,cap,dp);
        int take = Integer.MIN_VALUE;
        if(weight[n] <= cap){
            take = value[n]+ memoize(weight,value,n-1,cap-weight[n],dp);
        }
        return dp[n][cap] = Math.max(take,ntake);



    }
//t.c -> o(n * cap)
    //s.c -> o(n)+o(n * cap)
    static int knapsack(int[] weight, int[] value, int n, int cap) {
        int[][] dp = new int[n][cap+1];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < cap +1;j++){
                dp[i][j] = -1;
            }
        }
        return memoize(weight,value,n-1,cap,dp);


    }

    static int knapsacktab(int[] weight, int[] value, int n, int cap) {
        //t.c -> o(n * cap)
        //s.c -> o(n * cap)
        int[][] dp = new int[n][cap+1];
        //base case
        for(int i = weight[0];i < cap+1;i++){
            dp[0][i] = value[0];
        }


        for(int item = 1;item < n;item++){
            for(int citem = 1;citem < cap+1;citem++){
                int ntake = 0 + dp[item-1][citem];
                int take = Integer.MIN_VALUE;
                if(weight[item] <= citem){
                    take = value[item] + dp[item-1][citem - weight[item]];
                }
                dp[item][citem] = Math.max(take,ntake);

            }
        }
        return dp[n - 1][cap];

    }
    static int knapsackspace(int[] weight, int[] value, int n, int cap) {
        //t.c -> o(n * cap)
        //s.c -> o(cap)
        int[] prev = new int[cap+1];
        //base case
        for(int i = weight[0];i < cap+1;i++){
            prev[i] = value[0];
        }


        for(int item = 1;item < n;item++){
            int[] temp = new int[cap+1];
            temp[0] = 0;
            for(int citem = 1;citem < cap+1;citem++){
                int ntake = 0 + prev[citem];
                int take = Integer.MIN_VALUE;
                if(weight[item] <= citem){
                    take = value[item] + prev[citem - weight[item]];
                }
                temp[citem] = Math.max(take,ntake);

            }
            prev = temp;
        }
        return prev[cap];

    }
}
