package com.company.BinaryTrees.Medium;

public class maxpathsum {
    //s.c,t.c ->o(n)
    int getmax(Node node,int[] sum){
        if(node == null){
            return 0;
        }
        int lv = Math.max(0,getmax(node.left,sum));
        int rv = Math.max(0,getmax(node.right,sum));
        sum[0] = Math.max(sum[0],lv+node.data+rv);

        return Math.max(lv+node.data,rv+node.data);

    }
    int findMaxSum(Node node)
    {
        //your code goes here
        if(node == null){
            return 0;

        }
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        getmax(node,sum);
        return sum[0];
    }
}
