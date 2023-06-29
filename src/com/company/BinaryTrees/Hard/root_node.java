package com.company.BinaryTrees.Hard;
//t.c ->o(n),s.c ->o(h)
import java.nio.file.Paths;
import java.util.ArrayList;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class root_node {
//    static boolean getPath(Node root, ArrayList< Integer > arr, int x) {
//       if(root == null){
//           return false;
//       }
//
//       arr.add(root.data);
//       if(root.data == x){
//           return true;
//       }
//
//       if(getPath(root.left,arr,x) || getPath(root.right,arr,x)){
//           return true;//the subtrees don't have value
//       }
//
//       arr.remove(arr.size()-1);
//       return false;
//
//
//    }


    public static boolean  findp(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> ds){
        if(root == null){
            return false ;
        }
        ds.add(root.data);
        if(findp(root.left,ans, ds) == false && findp(root.right,ans, ds) == false){

            ans.add(new ArrayList<>(ds));
            ds.remove(ds.size() - 1);


        }
        return true;
    }
    static public ArrayList<ArrayList<Integer>> Paths(Node root){
        // Code here

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> newone = new ArrayList<>();
        findp(root,ans,newone);
        return ans;

    }
    public static void main(String args[]) {

        Node root = new Node(1);
        root.left = new Node(2);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.right.left = new Node(6);
//        root.left.right.right = new Node(7);
     root.right = new Node(3);
//
//        ArrayList < Integer > arr = new ArrayList < > ();
//
//        boolean res;
//        res = getPath(root, arr, 7);
//
//        System.out.print("The path is ");
//        for (int it: arr) {
//            System.out.print(it + " ");
//        }
        Paths(root);

    }
}
