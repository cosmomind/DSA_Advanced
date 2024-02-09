package com.company.Heap.Leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class maxkele {
    public int findKthLargest(int[] nums, int k) {
        //o(nlogn)+o(klogk)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i < nums.length;i++)
        {
            pq.offer(nums[i]);
        }
        for(int i = 0; i < k-1;i++){
            pq.remove();
        }
        return pq.poll();


    }

    public int findKthLargestminheap(int[] nums, int k) {

//t.c->o(nlogk)
        //s.c->o(k)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0;i < nums.length;i++)
        {
            if(pq.size() < k){
                pq.offer(nums[i]);
            }
            else{
                if(pq.peek() < nums[i]){
                    pq.remove();
                    pq.offer(nums[i]);
                }
            }
        }


        return pq.poll();
    }
}
