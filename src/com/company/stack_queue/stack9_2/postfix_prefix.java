package com.company.stack_queue.stack9_2;

import java.util.Stack;

//  tc,sc -> o(n)
public class postfix_prefix {

    static boolean isopt(char x){

        switch (x){
            case '+':
            case '-':
            case '/':
            case '*':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
    static String postToPre(String post_exp) {


        Stack<String> s = new Stack<>();
        String res = new String("");
        for (int i = 0; i < post_exp.length() ; i++) {
            char ch = post_exp.charAt(i);
            if(isopt(ch)){
                String  op1 = s.pop();
                String  op2 = s.pop();
                res = ch+op2+op1;
                s.push(res);
            }
            else{
                s.push(""+ch);
            }
        }
        return s.pop();

    }
        public static void main(String args[])
        {
            String post_exp = "ABC/-AK/L-*";

            // Function call
            System.out.println("Prefix : "
                    + postToPre(post_exp));
        }



}
