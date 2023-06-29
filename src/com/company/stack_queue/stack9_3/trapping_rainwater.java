package com.company.stack_queue.stack9_3;

import java.util.Stack;

public class trapping_rainwater {


    class Solution {
        //T.C -> O(N),s.c -> O(N)
        public  int maxWater(int[] height) {
            int n = height.length;
            int ans = 0;
            Stack<Integer> s  =new Stack<>();
            for (int i = 0; i < n; i++) {
                while((!s.isEmpty()) && (height[s.peek()] < height[i])){
                    int pop_ht = s.peek();//this is the index
                    s.pop();

                    if(s.isEmpty()){
                        break;
                    }

                    int dis = i - s.peek()-1;//left boundary is not popped but the base height is popped
                    int min_ht = Math.min(height[i],height[s.peek()]) - height[pop_ht];

                    ans += dis * min_ht;

                }

                s.push(i);
            }
           return ans;

        }
            //T.C -> O(N),s.c -> O(1)
        public int trap(int[] height) {
            int n = height.length;
            int l=0,r=n-1;
            int res = 0;
            int lmax=0,rmax = 0;



            while(l <= r){
                if(height[l] <= height[r]){
                    if(height[l] > lmax){
                        lmax = height[l];
                    }
                    else{
                        res += lmax - height[l];

                    }
                    l++;
                }
                else{
                    if(height[r] > rmax){
                        rmax = height[r];
                    }
                    else{
                        res += rmax - height[r];
                    }
                    r--;
                }



            }
            return res;

        }
    }
}
