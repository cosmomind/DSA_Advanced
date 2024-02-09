package com.company.Heap.Leetcode;

import java.util.*;

public class maxsubseqscore {
   //only 12 testcases pass
        public static long getans(PriorityQueue<Integer> pq,
        long[][][] dp,int[] nums1, int[] nums2,int sum,int min,int k,int ind) {
            if(k == 0){
                return sum*min;
            }

            if(ind < 0) return 0;
            if(dp[ind][min][k] != -1) return dp[ind][min][k];
            pq.offer(nums2[ind]);
            long t = getans(pq,dp,nums1,nums2,sum+nums1[ind],pq.peek(),k-1,ind-1);
            pq.remove(nums2[ind]);
            long nt = getans(pq,dp,nums1,nums2,sum,min,k,ind-1);

            return dp[ind][min][k] = Math.max(t,nt);


        }


        public static long maxScoredp(int[] nums1, int[] nums2, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int n = nums1.length;
            long[][][] dp = new long[n][10001][k+1];
            for(long[][] arr:dp){
                for(long[] a: arr){
                    Arrays.fill(a,-1);}
            }
            int sum = 0;
            // int min = 0;//only positive integers


            return getans(pq,dp,nums1,nums2,sum,0,k,n-1);
        }

        //pq
    //t.c -> o(nlogn)
    //s.c -> o(k)
        public static long maxScore(int[] nums1, int[] nums2, int k) {
            List<int[]> arr = new ArrayList<>();
            for(int i = 0;i < nums1.length;i++){
                int[] a = new int[2];
                a[0] = nums2[i];
                a[1] = nums1[i];
                arr.add(a);
            }
            Collections.sort(arr,(x, y) -> y[0] - x[0]);
            //descending order sort

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long sum = 0;
            long ans = 0;
            for(int[] a:arr){
                pq.add(a[1]);
                sum += a[1];
                if(pq.size() > k) sum -= pq.remove();
                if(pq.size() == k) ans = Math.max(ans,sum * a[0]);


            }

            return ans;
        }

    public static void main(String[] args) {
int[] nums1 = {2,1,3,2};
int[] nums2 = {2,1,3,4};
int k = 3;
        System.out.println(maxScore(nums1,nums2,k));
    }
}
