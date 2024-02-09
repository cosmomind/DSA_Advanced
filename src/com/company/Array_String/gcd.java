package com.company.Array_String;

public class gcd {
    public String gcdOfStrings(String str1, String str2) {
        //it's correct but u need to find the smaller string and do it
        int num = 0;
        for(int i =0;i < str1.length();i++){
            num += str1.charAt(i);

        }
        int div = 0;
        for(int i =0;i < str2.length();i++){
            div += str2.charAt(i);

        }

        int ind = str2.length();
        while(ind > 0){
            if(num% div == 0){
                return str2.substring(0,ind);
            }
            else{
                num = num - str2.charAt(ind-1);
            }
            ind--;
        }

        return "";
    }

    public String gcdOfStringsopt(String str1, String str2) {
        //https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3125858/the-idea-of-using-string-equality-and-gcd-time-space-complexity-elaboration/
        //logn - next step the input reduces considerably
        if(!(str1+ str2).equals(str2+str1)) return "";
        int num = gcd(str1.length(),str2.length());

        return str1.substring(0,num);
    }

    public static int gcd(int a,int b){
        if(b == 0){
            return a;
        }

        return gcd(b,a%b);
    }
}
