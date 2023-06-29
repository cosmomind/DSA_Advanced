package com.company.BinaryTrees.Hard;

import java.util.Stack;

public class flatten_bt {
    //s.c ->o(n),t.c ->o(n)
    Node prev = null;
    public  void flatten(Node root)
    {
        //code here
        if(root == null){
            return;
        }

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    //s.c ->o(n),t.c ->o(n)
    public  void flatten1(Node root)
    {
        //code here
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            Node curr = s.peek();
            s.pop();
            if(curr.right != null)s.push(curr.right);
            if(curr.left != null) s.push(curr.left);

            if(!s.isEmpty())curr.right = s.peek();
            curr.left = null;

        }
    }

    //s.c ->o(n),t.c ->o(1)
    public  void flatten3(Node root)
    {
        //code here
        Node curr = root;
        while(curr != null){
            if(curr.left != null){
                Node prev = curr.left;
                while(prev.right != null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;

            }
            else{
                curr = curr.right;
            }
        }
    }
}
