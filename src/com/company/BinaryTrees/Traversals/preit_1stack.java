package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.Stack;
//s.c -> o(n),t.c -> o(2n)
public class preit_1stack {
    static ArrayList < Integer > postOrderTrav(Node curr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        while(curr != null && !s.isEmpty()){
            if(curr != null){
                s.push(curr);
                curr = curr.left;
            }
            else{//reach left leaf node
                Node temp = s.peek().right;//moving to right of root
                if(temp == null){//right leaf node
                    temp = s.peek();
                    s.pop();
                    ans.add(temp.data);
                    while (!s.isEmpty() && temp == s.peek().right){
                        temp = s.peek();
                        s.pop();
                        ans.add(temp.data);
                    }//this condition becomes false when there is a branch shift
                    //going to prev level node and going to right subtree

                }
                else{
                    curr = temp;
                }

            }
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

        ArrayList< Integer > postOrder = new ArrayList < > ();
        postOrder = postOrderTrav(root);

        System.out.println("The postOrder Traversal is : ");
        for (int i = 0; i < postOrder.size(); i++) {
            System.out.print(postOrder.get(i) + " ");
        }
    }
}
