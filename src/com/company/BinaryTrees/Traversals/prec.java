package com.company.BinaryTrees.Traversals;

public class prec {
   static String lex(String s1,String s2){

        for(int i = 0;i< s1.length();i++){
            if(s1.charAt(i) == s2.charAt(i)){

                continue;
            }
            else if(s1.charAt(i) < s2.charAt(i)){
                return s1;
            }
            else{
                return s2;
            }
        }
        return s1;
    }
    static public String makeSmallestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }
        int op = 0;
        String res = "";
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
                res = s;
                continue;
            } else {
                op++;
                StringBuilder sb = new StringBuilder(s);
                StringBuilder sb1 = new StringBuilder(s);
                sb.setCharAt(l, sb.charAt(r));
                sb1.setCharAt(r, sb1.charAt(l));
                String s1 = sb.toString();
                String s2 = sb1.toString();;
                res = lex(s1, s2);
                s = res;
                l++;
                r--;

            }
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(makeSmallestPalindrome("bhh"));
    }
}
