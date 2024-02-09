package com.company.DP.LIS;

import java.util.Arrays;

public class numoflis {
    //t.c -> o(n*n)
    //s.c -> o(n)
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int max = 1;
        for(int i = 1;i < n;i++){
            for(int j = 0; j<= i-1;j++){
                if(arr[i] > arr[j] && dp[j]+1 > dp[i] ){
                    dp[i] = dp[j]+1;
                    //just adding at end
                    cnt[i] = cnt[j];
                }
                else if(arr[i] > arr[j] && dp[j]+1 == dp[i])
                    cnt[i] += cnt[j];
            }
            max = Math.max(max,dp[i]);



        }
        int res = 0;
        for(int i = 0;i < n;i++){
            if(dp[i] == max){
                res += cnt[i];

            }
        }
        return res;
    }
}
