package com.company.DP.subsequence;

public class rodcutting {
    //t.c -> o(n*n)
    //s.c -> o(target)+o(n*n)
    public static int getans(int price[], int index,int tar,int[][] dp) {
        if(tar == 0) return 0;
        if(index == 1){
            if(tar % index == 0)   return (tar/index) * price[index - 1];
        }
        if(dp[index][tar] != -1) return dp[index][tar];
        int nt = getans(price,index - 1,tar,dp)+0;
        int t = Integer.MIN_VALUE;
        if(index <= tar){
            t = getans(price,index,tar - index,dp)+price[index-1];
        }
        return dp[index][tar] = Math.max(nt,t);
    }


    public static int cutRodmemoize(int price[], int n) {

        int[][] dp = new int[n+1][n+1];//ind,target
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        return getans(price,n,n,dp);
    }


    public static int cutRodtab(int price[], int n) {
        //t.c -> o(n*n)
        //s.c -> o(n*n)
        int[][] dp = new int[n+1][n+1];//ind,target

        for (int i = 0; i <= n; i++) {

            dp[1][i] = i*price[0];

        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n; j++) {



                int nt = 0+dp[i-1][j];
                int t = Integer.MIN_VALUE;
                if(i <= j){
                    t = price[i-1]+dp[i][j - i];;
                }
                dp[i][j] = Math.max(nt,t);
            }
        }



        return dp[n][n];
    }

    public static int cutRod(int price[], int n) {
        //t.c -> o(n*n)
        //s.c -> o(n)
        int[] prev = new int[n+1];//target
        int[] temp = new int[n+1];
        for (int i = 0; i <= n; i++) {

            prev[i] = i*price[0];

        }

        for (int i = 2; i <= n; i++) {
            temp = new int[n+1];
            for (int j = 1; j <= n; j++) {



                int nt = 0+prev[j];
                int t = Integer.MIN_VALUE;
                if(i <= j){
                    t = price[i-1]+temp[j - i];;
                }
                temp[j] = Math.max(nt,t);
            }
            prev = temp;
        }



        return prev[n];
    }
}
