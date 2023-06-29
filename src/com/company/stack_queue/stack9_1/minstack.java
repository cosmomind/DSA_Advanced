package com.company.stack_queue.stack9_1;


import java.util.Stack;
//t.c -> o(1),s.c->o(2n)
//class pair{
//    int x,y;
//    pair(int x,int y){
//        this.x = x;
//        this.y = y;
//
//    }
//}
public class minstack {

    Stack<Long> st = new Stack<>();


        Long mini = Long.MAX_VALUE;

    void push ( int x){
        long val = Long.valueOf(x);
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } else {
                st.push(val);
            }
        }
    }

    public void pop () {
        if (st.isEmpty()) return;
        Long val = st.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }

    }

    public int peek () {
        if (st.isEmpty()) return -1;
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getmin () {
        return mini.intValue();
    }
    public static void main(String[] args) {


//    Stack<pair> s = new Stack<>();
//
//    void push(int x){
//        int min = Integer.MAX_VALUE;
//        if(s.isEmpty()){
//            min = x;
//        }
//        else{
//            min = Math.min(x,s.peek().y);
//
//        }
//        s.push(new pair(x,min));
//    }
//
//    public void pop(){
//        s.pop();
//    }
//    public void top()
//    {
//        s.peek().x;
//    }
//    int getmin(){
//        return s.peek().y;
//    }


    }
}


