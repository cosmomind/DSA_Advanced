package com.company.stack_queue.stack9_3;

import java.util.Stack;

public class nge2 {
    //t.c => o(2n+2n),s.c -> o(n)
    static int[] nextGreaterElement(int N, int arr[]) {
        // code here
        int[] nge = new int[N];
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        for(int i = 2*N-2 ; i>= 0;i--){
            while(!s.isEmpty() && arr[i%n] >= s.peek()){
                s.pop();
            }
            if(i < n){
                if(!s.isEmpty()){
                    nge[i] = s.peek();
                }
                else{
                    nge[i] = -1;
                }
            }
            s.push(arr[i%n]);



        }
        return nge;
    }

}
