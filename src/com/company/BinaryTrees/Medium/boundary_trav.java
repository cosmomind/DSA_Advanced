package com.company.BinaryTrees.Medium;

import java.util.ArrayList;
//s.c,t.c -> o(n)
public class boundary_trav {

    static Boolean isLeaf(Node root) {
        return (root.left == null) && (root.right == null);
    }
    static void addLeftBoundary(Node root, ArrayList < Integer > res) {
    Node curr = root.left;

    while(curr != null){
        if(!isLeaf(curr)) res.add(curr.data);
        if(curr.left != null) curr = curr.left;
        else{
            curr = curr.right;
        }
    }

    }

    static void addRightBoundary(Node root, ArrayList < Integer > res) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr = root.right;

        while(curr != null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else{
                curr = curr.left;
            }
        }
        for (int i = temp.size() -1; i >= 0 ; i--) {
            res.add(temp.get(i));
        }

    }
    static void addLeaves(Node root, ArrayList < Integer > res) {
        //can be inorder,postorder or preorder
        if (root.left != null) addLeaves(root.left, res);
        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }
        if (root.right != null) addLeaves(root.right, res);

    }
    static ArrayList < Integer > printBoundary(Node node) {
        ArrayList < Integer > ans = new ArrayList<>();
        if(isLeaf(node) == false){
            ans.add(node.data);
        }
        addLeftBoundary(node, ans);
        addLeaves(node, ans);
        addRightBoundary(node, ans);
        return ans;


    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        ArrayList< Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
    }
}
