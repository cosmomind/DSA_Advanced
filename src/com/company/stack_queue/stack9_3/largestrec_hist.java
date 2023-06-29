package com.company.stack_queue.stack9_3;

import java.util.Stack;

public class largestrec_hist {
    //t.c -> o(n),s.c -> o(3n)
    public static long getMaxArea(long hist[], long b)
    {
        // your code here
        int n = hist.length;
        Stack<Integer> s = new Stack<>();
        int[] ls = new int[n];
        int[] rs = new int[n];

        for(int i = 0;i < hist.length;i++){

            while(!s.empty() && hist[s.peek()] >= hist[i]){
                s.pop();

            }
            if(s.empty()) ls[i] = 0;
            else{
                ls[i] = s.peek()+1;
            }
            s.push((int)i);



        }
        while(!s.isEmpty()){
            s.pop();
        }


        for(int j = n-1;j >= 0;j--){

            while(!s.empty() && hist[s.peek()] >= hist[j]){
                s.pop();

            }
            if(s.empty()) rs[j] = n-1;
            else{
                rs[j] = s.peek()-1;
            }
            s.push((int)j);



        }

        long max = 0;
        for(int k = 0;k < hist.length;k++){
            max = Math.max(max,hist[k] * (rs[k] - ls[k]+1));
        }
        return max;
    }

    //t.c -> o(n),s.c -> o(n)
    public int getrect(int histo[]){
        int max = 0;
        int n = histo.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while(!s.isEmpty() && (i == n || histo[s.peek()] >= histo[i])){
                int height = histo[s.peek()];
                s.pop();
                int width;
                if(s.isEmpty()) width = i;
                else{
                    width = i - s.peek()-1;
                }
                max = Math.max(max,height*width);

            }
            s.push(i);

        }

        return max;
    }
}
