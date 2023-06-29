package com.company.BST.problem;

import java.util.Stack;

public class k_smallest {
    //time complexity refer notes
    public int KthSmallestElement(Node root, int K) {
        // Write your code here
        Stack<Node> s = new Stack<>();

        int num = 0;Node curr = root;
        while(true){

            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            else{
                if(s.isEmpty())break;
                curr = s.peek();
                s.pop();
                num++;


                if(num == K) return curr.data;


                curr = curr.right;

            }




        }
        return -1;

    }
}
