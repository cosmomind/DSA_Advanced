package com.company.SlidingWindow;

public class maxavg {
    public static double findMaxAverage(int[] nums, int k) {
        //o(n)
        int n = nums.length;
        int i=0,j=0;double sum = 0;double max =Double.NEGATIVE_INFINITY;
        while(j < n){
            sum += nums[j];
            if(j - i+1 == k){
                max = Math.max(max, sum);
                sum -= nums[i];
                i++;
                j++;
            }

            if(j - i+1 < k){
                j++;
            }


        }

        return (double)max/k;
    }

    public static void main(String[] args) {
        int[] nums ={-1};
        int  k =1;
        System.out.println(findMaxAverage(nums,k));;
    }
}
