package com.company.stack_queue.stack9_1;

import java.util.ArrayList;

public class stack_array {
//maintain top variable = -1
//push(x): insert element is the array by increasing top by one.
//pop(): check whether top is not equal to -1 if it is so, return top and decrease its value by one.
//size(): return top+1
    //T.C = O(1) for each stack operations
    //S.C = O(n)


    public static void main(String[] args) {

//        stack st = new stack();
//        st.push(3);
//        st.push(9);
//        st.push(8);
//        System.out.println(st.pop());
//        System.out.println(st.top());
//        System.out.println(st.size());

        stack st = new stack();
        st.push(3);
        st.push(9);
        st.push(8);
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.size());

    }
}

class stack{
    ArrayList<Integer> stt = new ArrayList<>();
//    int size = 100;
//    int[] arr = new int[size];
   int top = -1;

    void push(int x){
        top++;
        // arr[top] = x;
        stt.add(x);
    }

    int pop(){
//        int x = arr[top];
//
//        top--;
//        return x;
//


        if(!stt.isEmpty()){
            int y = stt.get(stt.size()-1);
            stt.remove(stt.size()-1);
            return y;
        }
        else{
            System.out.println("Already empty");
            return -1;
        }
    }


    int top(){
//        return arr[top];
        return stt.get(stt.size()-1);
    }
 int size(){
//        return top+1;
     return stt.size();
 }

}
