package com.company.stack_queue.stack9_2;

import java.util.Stack;

public class prefix_postfix {
    //  tc,sc -> o(n)




        static    boolean isOperator(char x)
        {
            switch (x){
                case '*':
                case '-':
                case '+':
                case '/':
                case '%':
                case '^':
                    return true;
            }
            return false;
        }

        public static String convert(String str){

            Stack<String> s = new Stack<>();
            int lenn = str.length();

            for (int i = lenn - 1; i >= 0 ; i--) {
                char ch = str.charAt(i);
                if(isOperator(ch)){
                    String opd1 = s.pop();
                    String opd2 = s.pop();

                    String res = opd1+opd2+ch;
                    s.push(res);
                }
                else{
                    s.push(ch+"");}
            }
            return s.pop();
        }

        public static void main(String[] args)
        {
            String exp = "*-A/BC-/AKL";
            System.out.println("Infix : " + convert(exp));
        }
    }


