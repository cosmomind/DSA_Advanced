package com.company.DP.oneD;
//t.c -> o(n),s.c ->o(1)
public class frogjump {
    public int getans(int[] dp,int N,int[] arr){
        if(N == 0) return 0;
        if(dp[N] != -1) return dp[N];

        int one_jump = getans(dp,N-1,arr) + Math.abs(arr[N] - arr[N-1]);
        int second_jump = Integer.MAX_VALUE;
        if(N >1){
            second_jump = getans(dp,N-2,arr) + Math.abs(arr[N] - arr[N-2]);
        }
        return dp[N] = Math.min(one_jump,second_jump);
    }
    public int minimumEnergy(int arr[],int N){
        //code here

        int[] dp = new int[N];
        int[] ans = new int[N];
        for(int i = 0;i< N;i++) dp[i] = -1;
        // return getans(dp,N-1,arr);
        // ans[0] = 0;
        int prev = 0;
        int tprev = 0;
        for(int i = 1;i< N;i++){

            //  int left = ans[i-1] + Math.abs(arr[i] - arr[i-1]);
            int left = prev + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1){
                //  right = ans[i-2] + Math.abs(arr[i] - arr[i-2]);
                right = tprev + Math.abs(arr[i] - arr[i-2]);
            }
            //  ans[i] = Math.min(left,right);
            int cur = Math.min(left,right);
            tprev = prev;
            prev = cur;

        }

        return prev;
        //  return ans[N-1];

    }
}
