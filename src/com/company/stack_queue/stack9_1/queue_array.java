package com.company.stack_queue.stack9_1;
//T.C = O(1)
//S.C = O(N)
class Queue1 {

     int arr[];
     int start, end, count, capacity;


    public Queue1(int maxSize) {
        this.capacity = maxSize;
        arr = new int[maxSize];
        start = -1;
        end = -1;
        count = 0;
    }


    public void push(int newElement) {
        if (count == capacity) {
            System.out.println("Queue is full");
            System.exit(1);
        }
        if (end == -1) {//queue intially empty
            start = 0;
            end = 0;
        } else{
            end = (end + 1) % capacity;}
        arr[end] = newElement;
        System.out.println("The element pushed is " + newElement);
        count++;
    }
    public int pop() {
        if (start == -1) {//queue is empty
            System.out.println("Queue Empty");
            System.exit(1);
        }
        int popped = arr[start];
        if (count == 1) {
            start = -1;
            end = -1;
        } else{
            start = (start + 1) % capacity;}
        count--;
        return popped;
    }
    public int top() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }
    public int size() {
        return count;
    }

}

public class queue_array {
    public static void main(String args[]) {
        Queue1 q = new Queue1(6);
        q.push(4);
        q.push(14);
        q.push(24);
        q.push(34);
        System.out.println("The peek of the queue before deleting any element " + q.top());
        System.out.println("The size of the queue before deletion " + q.size());
        System.out.println("The first element to be deleted " + q.pop());
        System.out.println("The peek of the queue after deleting an element " + q.top());
        System.out.println("The size of the queue after deleting an element " + q.size());
    }
}
