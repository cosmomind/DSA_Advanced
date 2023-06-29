package com.company.stack_queue.stack9_2;

import java.util.Stack;
//  tc,sc -> o(n)
public class infix_prefix {
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

    static String infixToPrefix(String exp){

        String result = new String("");
        Stack<Character> s = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char ch = exp.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                result = ch + result;
            }
            else if(ch == ')'){
                s.push(ch);
            }
            else if(ch == '('){
                while (!s.isEmpty() && s.peek() != ')'){
                    result = s.pop()+ result;
                }
                s.pop();
            }
            else{
                while (!s.isEmpty() && Prec(ch) <= Prec(s.peek()) && s.peek()!= ')'){
                    result = s.pop()+ result;
                }
                s.push(ch);

            }



        }

        while(!s.isEmpty()){
            if(s.peek() == ')'){
                System.out.println("Invalid");
            }
            result = s.pop() +result ;
        }
        return result;

    }

    public static void main(String[] args) {
        String exp = "K+L-M*N+(O^P)*W/U/V*T+Q";

        // Function call
        System.out.println(infixToPrefix(exp));
    }
}
