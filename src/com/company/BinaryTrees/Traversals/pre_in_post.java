package com.company.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class pair{
    Node tree;
    int num;

    pair(Node _tree,int _num){
        tree = _tree;
        num = _num;
    }
}
//s.c -> o(4n),t.c -> o(3n)
public class pre_in_post {
    public static void allTraversal(Node root, List < Integer > pre, List < Integer > in , List < Integer > post) {
        Stack<pair> s = new Stack<>();
        if(root == null){
            return;
        }
        s.push(new pair(root,1));
       while (!s.isEmpty()){
           pair it = s.pop();

           if(it.num == 1){
               pre.add(it.tree.data);
               it.num++;
               s.push(it);
               if(it.tree.left != null){
                   s.push(new pair(it.tree.left,1));
               }
           }
           else if(it.num == 2){
               in.add(it.tree.data);
               it.num++;
               s.push(it);
               if(it.tree.right != null){
                   s.push(new pair(it.tree.right,1));
               }
           }
           else {
               post.add(it.tree.data);
           }
       }



    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List< Integer > pre = new ArrayList< >();
        List < Integer > in = new ArrayList < > ();
        List < Integer > post = new ArrayList < > ();
        allTraversal(root, pre, in , post);

        System.out.println("The preorder Traversal is : ");
        for (int nodeVal: pre) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The inorder Traversal is : ");
        for (int nodeVal: in ) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
        System.out.println("The postorder Traversal is : ");
        for (int nodeVal: post) {
            System.out.print(nodeVal + " ");
        }
        System.out.println();
    }
}
