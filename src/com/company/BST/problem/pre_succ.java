package com.company.BST.problem;

public class pre_succ {
    //t.c ->o(h),s.c ->o(1)
    public static void findPreSuc(Node root, int key)
    {
        // code here.

       Node pre=null,suc=null;
    /* There are two static nodes defined above pre(representing predecessor) and suc(representing successor) as follows:
       static Node pre=null,suc=null
       You need to update these both.
       And the data inside these classes will be printed automatically by the driver code.
    */

        Node curr = root;Node curr1 = root;
        while(curr != null){
            if(curr.data > key){
                if(suc == null || curr.data < suc.data) suc = curr;
                curr = curr.left;
            }
            else{

                curr = curr.right;
            }
        }

        while(curr1 != null){
            if(curr1.data >= key){

                curr1 = curr1.left;
            }
            else{
                if(pre == null || curr1.data > pre.data) pre = curr1;
                curr1 = curr1.right;
            }
        }


    }
}
