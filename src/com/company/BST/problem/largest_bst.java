package com.company.BST.problem;

class NodeValue {
    public int maxi, mini, size;

    NodeValue(int size, int maxi, int mini) {
        this.size = size;
        this.maxi = maxi;
        this.mini = mini;

    }
}
//t.c ->o(n),s.c->o(1)

public class largest_bst {

     static NodeValue largestBSTSubtreeHelper(Node root) {

            // An empty tree is a BST of size 0.
            if (root == null) {
                return new NodeValue(0,Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            // Get values from left and right subtree of current tree.
            NodeValue left = largestBSTSubtreeHelper(root.left);
            NodeValue right = largestBSTSubtreeHelper(root.right);

            // Current node is greater than max in left AND smaller than min in right, it is a BST.
            if (left.maxi < root.data && root.data < right.mini) {
                // It is a BST.
                return new NodeValue(left.size + right.size + 1,Math.max(root.data, right.maxi),
                        Math.min(root.data, left.mini));
            }

            // Otherwise, return [-inf, inf] so that parent can't be valid BST
            //making left.maxi veryyy big
            return new NodeValue(Math.max(left.size, right.size),
                    Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static int largestBSTSubtree(Node root) {
        return largestBSTSubtreeHelper(root).size;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(4);
        root.right = new Node(6);
       // root.left.left = new Node(30);
        root.left.right = new Node(9);
      //  root.right.left = new Node(30);

        largestBSTSubtree(root);
    }
}
