package com.company.Graphs.Learning;

import java.util.ArrayList;

//s.c,t.c ->o(v+e)
public class graph_rep {
    public ArrayList<ArrayList<Integer>> printGraph(
            int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here

        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i< adj.size();i++){
            ArrayList<Integer> res = new ArrayList<Integer>();
            ans.add(res);
            res.add(i);
            for(int j = 0;j< adj.get(i).size();j++){
                res.add(adj.get(i).get(j));

            }
        }

        return ans;
    }
}
