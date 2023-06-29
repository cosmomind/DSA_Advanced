package com.company.stack_queue.stack9_3;

import java.util.Stack;

public class ngetoright {
    // Program to print the next greater elements to the index in the
// array



        static void findNext(int next[], int a[], int n){
            Stack<Integer> s = new Stack<Integer>();
            s.push(0);

            for(int i = 1; i < n; i++){
                while(s.size() > 0){
                    int current = s.peek();
                    if(a[current] < a[i]){
                        next[current] = i;
                        s.pop();
                    }
                    else{
                        break;
                    }
                }
                s.push(i);
            }

            while(s.size() > 0){
                int current = s.peek();
                next[current] = -1;
                s.pop();
            }
        }

        static void count(int a[], int dp[], int n){

            int next[] = new int[n];
            for(int i = 0; i < n; i++){
                next[i] = 0;
            }

            findNext(next, a, n);

            for(int i = n-2; i >= 0; i--){
                if(next[i] == -1){
                    dp[i] = 0;
                }
                else{
                    dp[i] = 1 + dp[next[i]];
                }
            }
        }

        static int answerQuery(int dp[], int index){
            return dp[index];
        }

        public static void main(String args[]){
            int a[] = {3,4,2,7,5,8,10,6};
            int n = a.length;

            int dp[] = new int[n];

            count(a, dp, n);

            System.out.println(answerQuery(dp, 0));
            System.out.println(answerQuery(dp, 1));
            System.out.println(answerQuery(dp, 5));
        }
    }

