package com.company.BinaryTrees.Hard;

public class count_totnodes {
//s.c -> o(logN);t.c -> o((logN) ^2);

        public static int count(Node root) {
            if(root == null) return 0;

            int lh = depthl(root.left);
            int rh = depthr(root.right);
            if(lh == rh) return (1 << (lh+1)) - 1;

            int l = count(root.left);
            int r = count(root.right);

            return 1+l+r;

        }

        public static int depthl(Node root) {
            int cnt = 0;
            while(root != null){
                cnt++;
                //  depthl(root.left)
                root = root.left;
            }
            return cnt;
        }

        public static int depthr(Node root) {
            int cnt = 0;
            while(root != null){
                cnt++;
                //  depthl(root.right);
                root = root.right;
            }
            return cnt;
        }



        public static int countNodes(Node root) {
            // Code here
            if(root == null) return 0;
            return count(root);
        }
    }

