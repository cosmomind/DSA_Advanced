package com.company.BinaryTrees.Medium;
//t.c - > o(n),s.c -> o(2*n)

import java.util.*;

public class bottomview {
    public ArrayList<Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> m = new TreeMap<>();
        if(root == null){
            return ans;
        }

        q.offer(new Pair(root,0));
        while(!q.isEmpty())
        {
            Pair it = q.poll();
            Node node = it.node;
            int ver = it.vert;

            m.put(ver,node.data);
            if(node.left != null) q.offer(new Pair(node.left,ver-1));
            if(node.right != null) q.offer(new Pair(node.right,ver+1));

        }

        for(Map.Entry<Integer,Integer> en:m.entrySet()){
            ans.add(en.getValue());
        }

        return ans;
    }
}
