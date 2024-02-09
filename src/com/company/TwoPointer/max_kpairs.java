package com.company.TwoPointer;

import java.util.Arrays;

public class max_kpairs {
    //o(nlogn),o(1)
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int r = n-1;
        int count = 0;
        while(l < r){
            if(nums[l] + nums[r] == k)
            {
                l++;
                r--;count++;
            }
            else if(nums[l] + nums[r] > k)
            {
                r--;
            }
            else{

                l++;
            }
        }
        return count;
    }
}
