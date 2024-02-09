package com.company.Heap.Leetcode;

import java.util.PriorityQueue;

public class smallestinfiniteset {

    //t.c -> o(nlogn)
    public PriorityQueue<Integer> pq;

    public smallestinfiniteset() {
        pq = new PriorityQueue<Integer>();
        for(int i = 1 ; i <= 1000; i ++){
            pq.add(i);
        }

    }

    public int popSmallest() {

        return pq.poll();


    }

    public void addBack(int num) {
        if(num > -1 && !pq.contains(num)){
            pq.offer(num);
        }
    }






















}
