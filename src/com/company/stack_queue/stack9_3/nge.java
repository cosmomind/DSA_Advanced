package com.company.stack_queue.stack9_3;

import java.util.Stack;

public class nge {
    //t.c => o(n+n),s.c -> o(n)
    public static long[] nextLargerElement(long[] arr, int n)
    {
        // Your code here
        long[] nge = new long[n];

        Stack<Long> s = new Stack<>();

        for(int  i = n-1;i >= 0 ;i--){
            while(!s.isEmpty() && arr[i] >= s.peek()){
                s.pop();
            }
            if(!s.isEmpty()){
                nge[i] = s.peek();
            }
            else{
                nge[i] = -1;
            }

            s.push(arr[i]);
        }
        return nge;
    }
}
