package com.company.Array_String;

public class alt_concat {
    public String mergeAlternately(String word1, String word2) {

        String curr = "";
        int i = 0;
        while(i <  word1.length() || i < word2.length()){

            if(i < word1.length())curr += word1.charAt(i) ;
            if(i < word2.length()) curr += word2.charAt(i);
            i++;
        }


        return curr;

    }
}
