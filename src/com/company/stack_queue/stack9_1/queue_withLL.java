package com.company.stack_queue.stack9_1;

//s.c - o(1) t.c - o(n)
class queuenode{
    int val;
    queuenode next;
    queuenode(int data){
        val = data;
        next = null;
    }
}








public class queue_withLL {
    queuenode front=null,rear = null;
    int size = 0;

    boolean isempty(){
        if(front == null){
            return true;
        }
        return false;
    }

    int Peek(){
        if(isempty()){
            return -1;
        }
        else{
            return front.val;
        }
    }

    void Enqueue(int x){
        queuenode temp = new queuenode(x);
        if(temp == null){
            System.out.println("queue full");
        }
        else{
            if(front == null){
                //queue empty,front and rear will be temp
                front = temp;
                rear = temp;
            }
            else{
                rear.next = temp;
                rear = temp;

            }
            System.out.println(x+" Inserted into Queue ");
            size++;
        }

    }

    void Dequeue(){
        if(front == null){
            System.out.println("queue is empty");
        }
        System.out.println("Element which is removed"+front.val);
        queuenode temp = front;
        front = front.next;
        size--;


    }

    public static void main(String[] args) {
        queue_withLL Q=new queue_withLL();
        Q.Enqueue(10);
        Q.Enqueue(20);
        Q.Enqueue(30);
        Q.Enqueue(40);
        Q.Enqueue(50);
        Q.Dequeue();
        System.out.println("The size of the Queue is "+Q.size);
        System.out.println("The Peek element of the Queue is "+Q.Peek());
    }
}
