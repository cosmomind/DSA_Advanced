package com.company.TwoPointer;

public class move_zeroes {
    public void moveZeroes(int[] nums) {
        //u can't sort,onlt thing u can do is get count
        //of zeros and fix non-zero numbers in respective index
        int n = nums.length;
        int l = 0;
        int z_count = 0;
        for(int i = 0; i < n ;i++){
            if(nums[i] != 0){
                nums[l] = nums[i];
                l++;
            }
            else{
                z_count++;
            }
        }
        for(int i = n-z_count;i < n;i++){
            nums[i] = 0;
        }


    }
}
