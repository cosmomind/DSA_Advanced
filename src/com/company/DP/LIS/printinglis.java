package com.company.DP.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class printinglis {
    public static List< Integer > printingLongestIncreasingSubsequence(int []nums, int x) {
        //t.c -> o(n*n)
        //s.c ->  o(n)
        int n = nums.length;
        int[] ans = new int[n];
        int[] hash = new int[n];
        Arrays.fill(ans,1);

        for(int  i = 0; i< n;i++){
            hash[i] = i;
            for(int j = 0;j <= i-1;j++){
                if(nums[j] < nums[i] && 1+ans[j] > ans[i]){//to reduce updations the second condition
                    ans[i] = 1+ ans[i];
                    hash[i] = j;
                }


            }
        }

        int max = ans[0];int lastindex = 0;
        for(int  i = 1; i< n;i++){
            if(ans[i] > max){
                max = ans[i];
                lastindex = i;
            }

        }


        List<Integer> res = new ArrayList<Integer>();

        res.add(nums[lastindex]);
        while(hash[lastindex] != lastindex){
            res.add(nums[lastindex]);
            lastindex = hash[lastindex];
        }

        Collections.reverse(res);

        return res;

    }
}
