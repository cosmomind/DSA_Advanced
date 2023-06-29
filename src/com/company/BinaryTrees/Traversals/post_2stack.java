package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.Stack;
//t.c -> o(n),s.c -> o(2n)
public class post_2stack {

    static ArrayList < Integer > postOrderTrav(Node curr) {
       ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if(curr == null){
            return ans;
        }
        s1.push(curr);
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();

            if(s2.peek().left != null){
                s1.push(s2.peek().left);
            }
            if(s2.peek().right != null){
                s1.push(s2.peek().right);
            }
        }

        while(!s2.isEmpty()){
            ans.add(s2.pop().data);
        }
        return ans;


    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(8);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.left = new Node(9);
        root.right.right.right = new Node(10);

        ArrayList < Integer > postOrder = new ArrayList< >();
        postOrder = postOrderTrav(root);

        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }
}
