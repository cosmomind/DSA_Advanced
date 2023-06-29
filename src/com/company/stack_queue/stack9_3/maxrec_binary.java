package com.company.stack_queue.stack9_3;

import java.util.Stack;
//s.c ->o(m) ;t.c -> o(n*m)
public class maxrec_binary {
    static int max = 0;
    static public int maxArea(int arr[][], int n, int m) {
        // add code here.
        int[] hist =    new int[m];;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j< m;j++){
                if(arr[i][j] == 0){
                    hist[j] = 0;
                }
                else{
                    hist[j] += arr[i][j];
                }
            }

            for (int j = 0; j < hist.length; j++) {
                System.out.print(hist[j]);
            }
            System.out.println();
            getrec(hist,hist.length);





        }


   return max;
    }


    static void getrec(int[] hist,int lenn){

        int[] ls = new int[hist.length];
        int[] rs = new int[hist.length];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < hist.length; i++) {
            while(!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if(s.isEmpty()) ls[i] = 0;
            else {
                ls[i] = s.peek()+1;
            }
            s.push(i);
        }

        while (!s.isEmpty()){
            s.pop();
        }

        for (int i = hist.length -1; i >= 0 ; i--) {
            while(!s.isEmpty() && hist[s.peek()] >= hist[i]){
                s.pop();
            }
            if(s.isEmpty()) rs[i] = hist.length-1;
            else {
                rs[i] = s.peek()-1;
            }
            s.push(i);
        }

        for (int i = 0; i < hist.length; i++) {
            int ht = hist[i];
            max = Math.max(max,ht *(rs[i] - ls[i] + 1));
        }

       // System.out.println(max);



    }

    public static void main(String[] args) {
//        int[][] arr ={{0,1,1,0},
//                {1,1,1,1},
//                {1,1,1,1},
//                {1,1,0,0},
//        };
        int[][] arr ={{1,1,1,1,1},
                {0,1,0,0,0}

        };
        System.out.println(maxArea(arr,2,5));
    }
}
