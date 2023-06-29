package com.company.stack_queue.stack9_3;

import java.util.Stack;

//t.c -> o(n),s.c -> o(n)
public class stock_span {

    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here

        int[] span = new int[n];
        span[0] = 1;
        Stack<Integer> s = new Stack<>();
        s.push(0);

        for(int i = 1;i < n;i++){
            while(!s.empty() && price[s.peek()] <= price[i]){
                s.pop();

            }

            if(s.empty()){
                span[i] = i+1;
            }
            else{
                span[i] = i - s.peek();
            }
            s.push(i);


        }
        return span;
    }
}
