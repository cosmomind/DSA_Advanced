package com.company.Graphs.MST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class ds1{
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> sizze = new ArrayList<>();

    public ds1(int V){
        for(int i = 0;i< V;i++){
            parent.add(i);
            sizze.add(1);
        }
    }




    public int finp(int n){//does path compression when trying to connect 2 edges
        if(n == parent.get(n)) return n;

        int myp = finp(parent.get(n));
        parent.set(n,myp);
        return myp;
    }


    public void unibysize(int u,int v){//connects u and v
        int up = parent.get(u);
        int vp = parent.get(v);
        if(up == vp) return;
        if(sizze.get(up) > sizze.get(vp)){
            parent.set(vp,up);
            int s = sizze.get(up)+sizze.get(vp);
            sizze.set(up,s);
        }
        else{
            parent.set(up,vp);
            int s = sizze.get(up)+sizze.get(vp);
            sizze.set(vp,s);

        }

    }


}

class Edge implements Comparable<Edge>{
    int src;int dest;int weight;

    public Edge(int src,int dest,int weight)
    {
        this.src = src;
        this.dest = dest;
        this.weight = weight;

    }

    public int compareTo(Edge compareobj){
        return this.weight - compareobj.weight;
    }

}

//min heap can be used,but gives tle,read comments
//t.c-> O(N+E) + O(E logE) + O(E*4α*2)
//s.c ->o(n)+o(n)+o(e)
public class kruskals {

    static int spanningTree(int V, int E, int edges[][]){

        //try using Priorit Queue for revision
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for(int i = 0;i< V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i =0;i< edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            adj.get(u).add(new ArrayList<>(Arrays.asList(v,weight)));
            adj.get(v).add(new ArrayList<>(Arrays.asList(u,weight)));
        }

        ArrayList<Edge> e = new ArrayList<>();

        for(int  i =0;i <V;i++){
            for(int j = 0;j < adj.get(i).size();j++){
                int adj_node = adj.get(i).get(j).get(0);
                int w = adj.get(i).get(j).get(1);
                int s = i;
                Edge temp = new Edge(s,adj_node,w);
                e.add(temp);
            }
        }

        ds1  d = new ds1(V);
        Collections.sort(e);
        int mstwt = 0;


        for(int i = 0;i < e.size();i++){
            int se = e.get(i).src;
            int adj_e = e.get(i).dest;
            int we = e.get(i).weight;


            if(d.finp(se) != d.finp(adj_e)){
                mstwt += we;
                d.unibysize(se,adj_e);
            }
        }

        return mstwt;






    }
}
