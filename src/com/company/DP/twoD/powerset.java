package com.company.DP.twoD;

import java.util.ArrayList;
import java.util.Collections;

public class powerset {

    public static ArrayList<String> subsequences(String str) {
        //t.c -> o(2 ^ n *n),s.c -> aux -> o(1)
        int n = str.length();
        String s = "";

        ArrayList<String> ans = new ArrayList<>();
        for(int i = 0;i < (1 << n) ;i++){
            for(int j = 0;j < n;j++){//jth bit
                if((i & (1 << j)) != 0){
                    s += str.charAt(j);
                }
            }

            if(s.length() > 0){
                ans.add(s);
                s = "";
            }


        }
        return ans;
    }

    public static void getans(int i,String s,String p,ArrayList<String> ans) {
        if(i == s.length()){

            if(p.length() != 0)ans.add(p);
            return;
        }
        getans(i+1,s,p+s.charAt(i),ans);
        getans(i+1,s,p,ans);

    }
    public static ArrayList<String> subsequencesrec(String str) {
//t.c -> o(2^n),s.c -> o(n)
        String  p = "";
        ArrayList<String> ans = new ArrayList<>();
        getans(0,str,p,ans);
        return ans;
    }

}
