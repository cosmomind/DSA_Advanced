package com.company.stack_queue.stack9_1;


import java.util.Stack;

public class Balancedparenthesis {

    static boolean isValid(String s){

        Stack<Character> st = new Stack<>();
        for (char ch:s.toCharArray()) {
            if(ch == '['|| ch =='{'|| ch =='('){
                st.push(ch);
            }
            else{
                if(st.empty()){
                    return false;
                }
                char it = st.pop();
                if(it == '[' && ch == ']' || it == '{' && ch == '}'||it == '(' && ch == ')'){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return (st.isEmpty());

    }



    public static void main(String[] args) {
        String s="()[{}()]";
        if(isValid(s)==true)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
