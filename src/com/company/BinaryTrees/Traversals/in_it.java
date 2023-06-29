package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.Stack;
//s.c,t.c -> o(n)
public class in_it {
    static ArrayList < Integer > inOrderTrav(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        if(root == null){
            return ans;
        }
        Node curr = root;
//        s.push(curr);
        while(true){
            if(curr != null){
                s.push(curr);
                curr = curr.left;

            }
            else{
                if(s.isEmpty()) break;
                curr = s.peek();
                ans.add(curr.data);
                s.pop();
                curr = curr.right;

            }

        }

        return  ans;
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

        ArrayList< Integer > inOrder;
        inOrder = inOrderTrav(root);

        System.out.println("The inOrder Traversal is : ");
        for (int i = 0; i < inOrder.size(); i++) System.out.print(inOrder.get(i) + " ");
    }
}
