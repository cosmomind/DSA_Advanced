package com.company.DP.oneD;
//t.c -> o(n),s.c ->o(1)
public class max_nonadj_sum {
    int rec(int[] arr,int i){//recursion causes tle

        if( i == 0)return arr[i];
        if(i  < 0) return 0;
        int p = arr[i] + rec(arr,i - 2);
        int np = 0 + rec(arr,i-1);
        return Math.max(p,np);
    }

    int mem(int[] dp,int[] arr,int i){


        if(i  < 0) return 0;
        if(dp[i] != -1) return dp[i];
        int p = arr[i] + mem(dp,arr,i - 2);
        int np = 0 + mem(dp,arr,i-1);
        return dp[i] = Math.max(p,np);
    }


    int findMaxSum(int arr[], int n) {

        int[] dp =new int[n];
        for(int i = 0;i< n;i++){dp[i] = -1;}
        int[] ans = new int[n];
        //return rec(arr,n-1);
        //memoization
        //return mem(dp,arr,n-1);
        ans[0] = arr[0];

        //space optimization
        int prev = arr[0];
        int tprev  = 0;

        // for(int i = 1;i< n;i++){
        //     int t = arr[i];
        //     if(i > 1) t += ans[i - 2];

        //     int nt = 0 + ans[i-1];

        //     ans[i] =  Math.max(t,nt);


        // }

        for(int i = 1;i< n;i++){
            int t = arr[i];
            if(i > 1) t += tprev;

            int nt = 0 + prev;

            int cur =  Math.max(t,nt);
            tprev = prev;
            prev = cur;

        }

        return prev;



    }
}
