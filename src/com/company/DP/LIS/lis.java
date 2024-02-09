package com.company.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lis {
    //t.c -> o(n*n)
    //s.c -> o(n*n) + o(n)
    public static int getans(int[][] dp,int[] arr,int ind,int prev) {

        if(ind == arr.length) return 0;
        if(dp[ind][prev+1] != -1) return dp[ind][prev+1];
        int nt = 0+  getans(dp,arr,ind+1,prev);
        int t = 0;
        if(prev == -1 || arr[prev] < arr[ind]){
            t = 1+ getans(dp,arr,ind+1,ind);
        }

        return dp[ind][prev+1] = Math.max(t,nt);

    }


    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];//because u can't express -1 in index

        for(int[] arr: dp){
            Arrays.fill(arr,-1);
        }

        return getans(dp,nums,0,-1);
    }



    public int lengthOfLIStab(int[] nums) {
        //t.c -> o(n*n)
        //s.c -> o(n*n)
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];


        for(int ind = n-1; ind >= 0;ind--){
            for(int prev = ind - 1;prev >= -1; prev--){
                int nt = 0+  dp[ind+1][prev+1];
                int t = 0;
                if(prev == -1 || nums[prev] < nums[ind]){
                    t = 1+ dp[ind+1][ind+1];
                }

                dp[ind][prev+1] = Math.max(t,nt);

            }
        }

        return dp[0][-1+1];
    }

    public int lengthOfLISspace(int[] nums) {
        int n = nums.length;
        int[] curr = new int[n+1];
        //base case nth row curr is 0
        int[] next = new int[n+1];


        for(int ind = n-1; ind >= 0;ind--){
            for(int prev = ind - 1;prev >= -1; prev--){
                int nt = 0+ curr[prev+1];
                int t = 0;
                if(prev == -1 || nums[prev] < nums[ind]){
                    t = 1+ curr[ind+1];
                }

                next[prev+1] = Math.max(t,nt);

            }
            curr = next;
        }

        return curr[-1+1];
    }


    public int lengthOfLISeasyway(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);

        for(int  i = 1; i< n;i++){
            for(int j = 0;j <= i-1;j++){
                if(nums[j] < nums[i]){
                    ans[i] = Math.max(ans[j]+1,ans[i]);
                }


            }
        }

        int max = ans[0];
        for(int  i = 1; i< n;i++){
            max = Math.max(max,ans[i]);

        }

        return max;

    }


}
