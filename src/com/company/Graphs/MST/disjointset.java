package com.company.Graphs.MST;

import java.util.ArrayList;
//t.c ->o(4),const time,check out gfg problem
class ds{
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> sizze = new ArrayList<>();

    public ds(int n){

        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i,i);
            sizze.add(1);


        }
        }
    public int findultpar(int num){
        if(num == parent.get(num)){
             return num;
        }
        int ultp = findultpar(parent.get(num));
        parent.set(num,ultp);//doing path compression doing backtracking

        return  ultp;
    }

    public void unionbysize(int u,int v){
        int ult_u = findultpar(u);
        int ult_v = findultpar(v);
        if(ult_v == ult_u) return;//belongs to the same component
        if(rank.get(ult_v)< rank.get(ult_u)){
            parent.set(ult_v,ult_u);
            int s = sizze.get(ult_u) +sizze.get(ult_v);
            sizze.set(ult_u,s);
        }

        else{
            parent.set(ult_u,ult_v);//or opposite way also correct
            int s = sizze.get(ult_u) +sizze.get(ult_v);
            sizze.set(ult_v,ult_u);
        }
    }



    public void unionbyrank(int u,int v){
        int ult_u = findultpar(u);
        int ult_v = findultpar(v);
        if(ult_v == ult_u) return;//belongs to the same component
        if(rank.get(ult_v)< rank.get(ult_u)){
            parent.set(ult_v,ult_u);
        }
        else  if (rank.get(ult_u)< rank.get(ult_v)){
            parent.set(ult_u,ult_v);
        }
        else{
            parent.set(ult_v,ult_u);//or opposite way also correct
            int ranku = rank.get(ult_u);
            rank.set(ult_u,ranku+1);
        }
    }




}

public class disjointset {
    public static void main(String[] args) {
        ds dsj = new ds(7);
        dsj.unionbysize(1, 2);
        dsj.unionbysize(2, 3);
        dsj.unionbysize(4, 5);
        dsj.unionbysize(6, 7);
        dsj.unionbysize(5, 6);

        // if 3 and 7 same or not
        if (dsj.findultpar(3) == dsj.findultpar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        dsj.unionbysize(3, 7);
        if (dsj.findultpar(3) == dsj.findultpar(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }

}
