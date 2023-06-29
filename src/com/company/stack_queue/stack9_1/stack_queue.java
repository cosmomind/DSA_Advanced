package com.company.stack_queue.stack9_1;

import java.util.LinkedList;
import java.util.Queue;
//T.C = O(N)
//S.C = O(N)
public class stack_queue {
    public static void main(String[] args) {
        stackq s = new stackq();
        s.push(2);
        s.push(3);
        System.out.println("The deleted element is: " + s.pop());
        s.push(4);
        System.out.println("The deleted element is: " + s.pop());
//        s.push(1);
        //System.out.println("Top of the stack: " + s.top());
       // System.out.println("Size of the stack before removing element: " + s.sizze());

//        System.out.println("Top of the stack after removing element: " + s.top());
//        System.out.println("Size of the stack after removing element: " + s.sizze());

    }

    static class stackq{

        Queue<Integer> qq = new LinkedList<Integer>();
//      void push(int x){
//       qq.add(x);
//          for (int i = 0; i < qq.size()-1; i++) {
//              qq.add(qq.remove());
//          }
//
//      }
//
//      int pop(){
//        return   qq.remove();
//      }
//      int top(){
//          return qq.peek();
//      }
//      int sizze(){
//          return qq.size();
//      }

        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();

        //Function to push an element into stack using two queues.
        void push(int a)
        {
            q2.add(a);
            for(int i = 0;i< q1.size();i++){
                q2.add(q1.remove());
            }
            for(int i = 0;i< q2.size();i++){
                q1.add(q2.remove());
            }
            // Your code here
        }

        //Function to pop an element from stack using two queues.
        int pop()
        {
            // Your code here
            return q1.remove();
        }


    }
}
