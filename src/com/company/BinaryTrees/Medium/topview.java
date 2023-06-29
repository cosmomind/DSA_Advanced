package com.company.BinaryTrees.Medium;

import java.util.*;
//t.c - > o(n),s.c -> o(2*n)
class Pair{
    Node node;
    int vert;
    public Pair(Node node,int vert){
        this.node = node;
        this.vert = vert;
    }

}

public class topview {


    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // add your code
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;

        }

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair rem = q.poll();
            Node node = rem.node;
            int v = rem.vert;

            if (!map.containsKey(v)) map.put(v, node.data);
            if (node.left != null) q.offer(new Pair(node.left, v - 1));
            if (node.right != null) q.offer(new Pair(node.right, v + 1));
        }
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            ans.add(en.getValue());
        }
        return ans;
    }
}

