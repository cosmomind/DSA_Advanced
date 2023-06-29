package com.company.stack_queue.stack9_1;
class stacknode{

    //s.c - o(1) t.c - o(n)
    int val;
    stacknode next;
    stacknode(int data){
        val = data;
        next = null;
    }


}
public class stack_withLL {
    stacknode start = null;
    int size = 0;

    public void stackPush(int x){
        stacknode temp = new stacknode(x);
        temp.next = start;
        start = temp;
        System.out.println("Element pushed");
        size++;

    }

    int stackPop(){
        if(start == null){
            return  -1;
        }
        int x = start.val;
        stacknode temp = start;
        start = start.next;
        size-- ;
        return x;
    }
    boolean stackIsEmpty(){
        return (start == null);
    }
    public void printStack() {
        stacknode current = start;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    int stackSize(){
        return size;
    }

    public static void main(String[] args) {
        stack_withLL s = new stack_withLL();
        s.stackPush(10);
        s.stackPush(20);
        s.printStack();
        System.out.println("Element popped " + s.stackPop());
        System.out.println("Stack size: " + s.stackSize());
        System.out.println("Stack is empty or not: " + s.stackIsEmpty());
    }


}
