package com.company.stack_queue.stack9_2;

import java.util.Stack;
//  tc,sc -> o(n)
public class infix_postfix {

    static int Prec(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
    static String infixToPostfix(String exp){

        String result = new String("");
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                result += ch;
            }

            else if(ch == '('){
                s.push(ch);
            }

            else if(ch == ')'){
                while (!s.empty() && s.peek() != '(') {
                    result += s.pop();
                }
                s.pop();
            }

            else{
                while(!s.isEmpty() && Prec(ch) <= Prec(s.peek()) && s.peek() != ')'){
                    result += s.pop();
                }
                s.push(ch);//pushing char
            }
        }

        while(!s.isEmpty()){
            if(s.peek() == '('){
                System.out.println("Invalid");
            }
            result += s.pop();
        }


        return result;
    }

    public static void main(String[] args)
    {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";

        // Function call
        System.out.println(infixToPostfix(exp));
    }
}
