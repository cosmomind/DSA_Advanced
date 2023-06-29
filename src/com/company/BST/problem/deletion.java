package com.company.BST.problem;

public class deletion {
    //t.c -> o(height),s.c ->o(1)
    public static Node deleteNode(Node root, int X) {
        // code here.
        if(root == null){
            return null;
        }
        if(root.data == X){
            return helper(root);
        }
        Node dummy = root;
        while(root != null){
            if(root.data > X){
                if(root.left != null && root.left.data == X){
                    root.left = helper(root.left);//passing the number to be removed
                    break;
                }
                else{
                    root = root.left;
                }
            }
            else{
                if(root.right != null && root.right.data == X){
                    root.right = helper(root.right);
                    break;
                }
                else{
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    public static Node helper(Node root) {

        if(root.left == null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }else{
            Node ins = root.right;
            Node left = root.left;
            Node rightmost = findright(left);
            rightmost.right = ins;
            return left;
        }

    }

    public static Node findright(Node root) {
        if(root.right == null){
            return root;
        }
        return findright(root.right);
    }

}
