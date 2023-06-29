package com.company.stack_queue.stack9_1;

import java.util.Stack;

//T.C => O(1) amortized
//S.C => o(2n)
class queuestack1{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x){
        System.out.println("The element pushed is " + x);
        input.push(x);
    }
    int pop(){
        if(output.empty()) {
            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        }
       return output.pop();
    }


    int peek(){
        if(output.empty()) {

            while (!input.empty()) {
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }
    int size(){
        return (input.size()+ output.size());
    }



}

public class queue_withstack {
    public static void main(String[] args) {

        queuestack1 q = new queuestack1();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }
}
