package com.company.stack_queue.stack9_4;

import java.util.Stack;
//s.c,t.c -> o(n)
public class celebrity {
    static boolean knows(int a,int b,int[][] m,int n){
        if(m[a][b] == 1) return true;
        return false;
    }
    //Function to find if there is a celebrity in the party or not.
    static int celebrity(int M[][], int n)
    {
        // code here
        Stack<Integer> s = new Stack<>();

        for(int i = 0;i< n;i++){
            s.push(i);
        }

        while(s.size() != 1){
            int a = s.pop();
            int b = s.pop();

            if(knows(a,b,M,n)){
                s.push(b);
            }
            else{
                s.push(a);
            }
        }
        int candidate = s.pop();//here already checking if others know candidate

        boolean knowany = false;
        for(int j = 0;j< n;j++){
            if(knows(candidate,j,M,n)){
                knowany = true;
                break;
            }
        }
        //need to check this or else won't work for 000 000 000
        boolean everyknow = true;
        for(int j = 0;j< n;j++){
            if(knows(j,candidate,M,n) == false && candidate != j){
                everyknow = false;
                break;
            }
        }

        if(knowany == true || everyknow == false)	return -1;//not a celebrity
        else return candidate;
    }
    public static void main(String[] args) {
       int arr[][]  = {{0,0,0},{0,0,0},{0,0,0}};
        //int arr[][] = {{0,1},{1,0}};
        int n = arr.length;
        System.out.println(celebrity(arr,n));

    }
}
