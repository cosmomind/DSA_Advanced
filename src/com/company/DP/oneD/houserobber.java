package com.company.DP.oneD;

import java.util.Arrays;

public class houserobber {
    public int FindMaxSum(int arr[], int n)
    {
        //memoization - max money till n house

        int[] ans = new int[n];
        ans[0] = arr[0];
        for(int i = 1;i < n;i++){
            int p = arr[i];
            if(i > 1) p += ans[i-2];
            int np = 0 + ans[i-1];

            ans[i] = Math.max(p,np);
        }
        return ans[n-1];
    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length;

        int p = FindMaxSum(Arrays.copyOfRange(nums,1,n),nums.length -1);
        int np = FindMaxSum(Arrays.copyOfRange(nums,0,n-1),nums.length -1);

        return Math.max(p,np);
    }
}
