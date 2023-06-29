package com.company.stack_queue.stack9_3;

import java.util.Stack;
//t.c,s.c => o(n),another approach too
public class immediatesmallerele {

    static void immediateSmaller(int arr[], int n) {
        // code here
        // Your code here


        Stack<Integer> s = new Stack<>();
        for(int i = 0;i <= n-2;i++){
            s.push(arr[i+1]);
            if(arr[i] > s.peek()){
                arr[i] = s.pop();
            }
            else{
                arr[i] = -1;
            }
        }
        arr[n-1] = -1;

    }
    public static void main(String[] args) {
        int[] arr ={4 ,2, 1, 5, 3};
        immediateSmaller(arr, arr.length);
    }
}
