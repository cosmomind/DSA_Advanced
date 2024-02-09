package com.company.DP.LIS;

import java.util.ArrayList;

public class lisbs {
    //t.c -> o(n*logn)
    //s.c -> o(n)

    public static int bs(int key,ArrayList<Integer> temp) {
        int s = 0;
        int e = temp.size() - 1;
        while(s <= e){
            int m = s + (e-s)/2;
            if(temp.get(m) == key){
                return m;
            }
            else if(key > temp.get(m)){
                s = m+1;
            }
            else{
                e = m-1;
            }


        }
        return s;




    }


    public static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);
        for(int i = 1;i < n;i++){
            if(arr[i] > temp.get(temp.size()-1)){
                temp.add(arr[i]);
            }
            else{
                int res = bs(arr[i],temp);
                if(temp.get(res) != arr[i]){
                    temp.set(res,arr[i]);
                }
            }



        }

        return temp.size();
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }
}
