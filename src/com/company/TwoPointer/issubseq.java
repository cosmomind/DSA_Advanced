package com.company.TwoPointer;

public class issubseq {
    public boolean isSubsequence(String s, String t) {
        int s_len = s.length();int j = 0;
        int t_len = t.length();
        if(s_len  == 0) return true;
        if(t_len < s_len ) return false;
        if(t_len == 1 && s_len == 1){
            if (t.charAt(0) == s.charAt(0))  return true;
            return false;
        }
        for(int i = 0;i < t_len;i++){
            if(t.charAt(i) == s.charAt(j)){
                j++;

            }
            if(j == s_len) return true;
        }
        return false;
    }

    class Solution {
        //o(n)
        //space - >o(1)
        public boolean isSubsequence(String s, String t) {
            int i=0,j=0;
            while(i<t.length()&&j<s.length()){
                if(s.charAt(j)==t.charAt(i)){
                    j++;
                }
                i++;
            }
            return j==s.length();
        }
    }
}

