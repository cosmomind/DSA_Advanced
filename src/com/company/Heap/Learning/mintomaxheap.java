package com.company.Heap.Learning;

public class mintomaxheap {
    public static int[] MinToMaxHeap(int n, int[] arr){
        int[] res = new int[n];
        res[0] = arr[0];
        for(int i = 1; i< n;i++){
            res[i] = arr[i];
            upheapify(i,res);
        }
        return res;
    }

    public static void upheapify(int i, int[] arr){
        if(i == 0) return;
        int pi = (i-1)/2;
        if(arr[i] > arr[pi]){
            swap(i,pi,arr);
            upheapify(pi, arr);
        }

    }

    public static  void swap(int i, int j,int[] arr) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;



    }
}
