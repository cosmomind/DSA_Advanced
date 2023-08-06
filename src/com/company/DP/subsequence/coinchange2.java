package com.company.DP.subsequence;

public class coinchange2 {
    //t.c -> o(n*target);
    //s.c -> o(n*target) + o(target);
    public static long memoize(int ind,long dp[][],int denominations[], int value){
        if(ind == 0){
            return(long)((value % denominations[0] == 0)? 1:0);
        }
        if(dp[ind][value] != -1) return dp[ind][value] ;
        long nt = memoize(ind-1,dp,denominations,value);
        long t = 0;
        if(denominations[ind] <= value){
            t = memoize(ind,dp,denominations,value-denominations[ind]);
        }
        return dp[ind][value] = (long)t+nt;



    }
    public static long countWaysToMakeChange(int denominations[], int value){
        int n = denominations.length;
        long[][] dp = new long[n][value+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return memoize(n-1,dp,denominations,value);


    }

    public static long countWaysToMakeChangetab(long[][]dp,int denominations[], int value){
        //t.c -> o(n*target);
        //s.c -> o(n*target) ;
        int n = denominations.length;


        for (int j = 0; j < value+1; j++) {
            if(j % denominations[0] == 0) dp[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < value+1; j++) {
                long nt = dp[i-1][j];
                long t = 0;
                if(denominations[i] <= j){
                    t = dp[i][j-denominations[i]];
                }
                dp[i][j] = t+nt;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < value+1; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();}
        return dp[n-1][value];


    }
    public static long countWaysToMakeChangespaceopt(int denominations[], int value){
        //t.c -> o(n*target);
        //s.c -> o(target) ;
        int n = denominations.length;
        long[] prev = new long[value+1];
        long[] temp = new long[value+1];

        for (int j = 0; j < value+1; j++) {
            if(j % denominations[0] == 0) prev[j] = 1;
        }

        for (int i = 1; i < n; i++) {
            temp = new long[value+1];
            for (int j = 0; j < value+1; j++) {
                long nt = prev[j];
                long t = 0;
                if(denominations[i] <= j){
                    t = temp[j-denominations[i]];
                }
                temp[j] = t+nt;
            }
            prev = temp;
        }
        return prev[value];


    }

    public static void main(String[] args) {
        int n = 3;
        int value = 4;
        long[][] dp = new long[n][value+1];
        int[] denominations = {1,2,3};
        countWaysToMakeChangetab(dp,denominations,value);

    }
}
