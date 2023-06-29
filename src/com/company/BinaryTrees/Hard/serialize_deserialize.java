package com.company.BinaryTrees.Hard;

import java.util.LinkedList;
import java.util.Queue;
//t.c ->o(n);s.c ->o(n)
public class serialize_deserialize {
    public static String serialize(Node root) {
        if(root == null) return "";

        Queue<Node> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        q.offer(root);
        while (!q.isEmpty()){
            Node curr = q.poll();
            if(curr != null) {
                res.append(curr.data+" ");
                q.offer(curr.left);
                q.offer(curr.right);
            }
            else {
                res.append("n ");


            }
        }
        deserialize(res.toString());

        return res.toString();
    }
    public static Node deserialize(String data) {

        if(data == "")return null;
        Queue<Node> q = new LinkedList<>();
        String[] values = data.split(" ");
        Node root = new Node(Integer.parseInt(values[0]));
        q.offer(root);
        for (int i = 1; i < values.length; i++) {
            Node curr = q.poll();
           if(!values[i].equals("n")){
               Node left = new Node(Integer.parseInt(values[i]));
               curr.left = left;
               q.offer(left);
           }
            if(!values[++i].equals("n")){
                Node right = new Node(Integer.parseInt(values[i]));
                curr.right = right;
                q.offer(right);
            }
        }

        return root;

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(13);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        System.out.println(serialize(root));
    }
}
