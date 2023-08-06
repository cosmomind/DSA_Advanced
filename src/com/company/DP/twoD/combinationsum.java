package com.company.DP.twoD;

import java.util.ArrayList;
import java.util.List;

public class combinationsum {
    //t.c -> o(2^t *k)
    //s.c -> o(k*x).k -> avg length of combination.x -> number of combination
    public void getans(int index,int[] candidates, int target,
                       List<List<Integer>> ans,ArrayList<Integer> sub) {
        if(index == candidates.length || target == 0){
            if(target == 0){
                ans.add(new ArrayList<>(sub));
                //ans.add((sub)),not possible becuz same memory location of sub and arraylist
                //added to ans..so any chages made to sub will be relected in ans arrayist
            }
            return;
        }
        if(candidates[index] <= target){
            sub.add(candidates[index]);
            //   getans(0,candidates,target - candidates[index],ans,sub);
            //check notebook array,suppose we didn't take 2 and went staright for 3,
            //by putting ind and not 0 we are never going back to 2
            getans(index,candidates,target - candidates[index],ans,sub);
            sub.remove(sub.size() - 1);
        }
        getans(index+1,candidates,target,ans,sub);


    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new   ArrayList();

        getans(0,candidates,target,ans,new ArrayList<>());
        return ans;

    }
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 1;

    }
}
