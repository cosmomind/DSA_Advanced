package com.company.BST.concept;

public class min_ele {
    int minValue(Node node) {
        if(node == null) return -1;
        if(node.left == null) return node.data;

        while(node.left != null){
            node = node.left;
        }
        return node.data;

    }
}
