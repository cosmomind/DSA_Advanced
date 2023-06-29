package com.company.stack_queue.stack9_3;

import java.util.Stack;

public class p {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
         int[] arr = {3,5,-3};
        s.push(arr[0]);
        for(int i= 1; i < arr.length;i++){
            if((s.peek() > 0 && arr[i] >0) || (s.peek() < 0 && arr[i] < 0)){
                s.push(arr[i]);
            }
            else if(s.peek() < 0 && arr[i] > 0){
                s.push(arr[i]);
            }
            else{
                int y = s.pop();
                if(Math.abs(y) != Math.abs(arr[i])) s.push(Math.max(y,arr[i]));

            }
        }
        int[] res = new int[s.size()];
        int k = 0;
        while(k < s.size()){
            res[k] = s.pop();
        }
      //  return res;
    }
}
