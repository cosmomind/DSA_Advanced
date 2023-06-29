package com.company.Graphs.Topo_Sort;

import java.util.ArrayList;
import java.util.Stack;
//t.c -> o(3k),s.c ->o(k+e)
public class alien_dict {
    public void getans(int i, int[] vis, Stack<Integer> s, ArrayList<ArrayList<Integer>> adj) {

        for (Integer j : adj.get(i)) {
            if (vis[j] != 1) {
                vis[j] = 1;//mistake1
                getans(j, vis, s, adj);
            }
        }
        s.push(i);
    }

    public String findOrder(String[] dict, int N, int K) {
        //make directed graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }

        }
        //no need to check for connected comp
        Stack<Integer> s = new Stack<>();
        int[] vis = new int[K];
        // int i = 0; vis[i] = 1;
        for (int i = 0; i < K; i++) {
            if (vis[i] != 1) {
                getans(i, vis, s, adj);
            }
        }


        StringBuilder res = new StringBuilder();
        while (!s.isEmpty()) {
            res.append((char) (s.pop() + 'a'));
            //appending a character
        }
        return res.toString();

    }
}