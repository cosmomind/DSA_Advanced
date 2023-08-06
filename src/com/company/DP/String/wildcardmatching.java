package com.company.DP.String;

import java.util.Arrays;

public class wildcardmatching {
    //t.c -> o(n*m)
    //s.c -> o(n+m) + o(n*m)
    public static boolean getans(int[][] dp,String s,String p,int i,int j) {
        if(i < 0 && j < 0){
            return true;
        }
        if(j < 0 && i >= 0) return false;
        if(j >= 0 && i < 0){//here I forgot to put = , got runtime error
            for(int n = 0; n <= j;n++){//j is the index
                if(p.charAt(n) != '*') return false;

            }
            return true;
        }
        if(dp[i][j] != -1) return (dp[i][j] == 1)?true:false;

        boolean ans = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            ans = getans(dp,s,p,i-1,j-1);
            dp[i][j] = (ans == true)?1:0;
            return ans;
        }
        else if (p.charAt(j) == '*'){

            ans = getans(dp,s,p,i-1,j) || getans(dp,s,p,i,j-1);
            dp[i][j] = ans?1:0;
            return ans;
        }
        else{
            dp[i][j] = 0;
            return false;
        }



    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }

        return getans(dp,s,p,n-1,m-1);


    }


    public static  int  isallstars(String p,int i){
        for(int n = 1; n <= i;n++){//j is the index
            if(p.charAt(n-1) != '*') return 0;

        }
        return 1;
    }
    public boolean isMatchtab(String s, String p) {
        //t.c -> o(n*m)
        //s.c -> o(n*m)
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        dp[0][0] = 1;
        for(int i = 1;i <= n;i++){
            dp[i][0] = 0;//if pattern over
        }
        for(int i = 1;i <= m;i++){
            dp[0][i] = isallstars(p,i);
        }

        for(int i = 1; i<= n;i++){
            for(int j = 1;j <= m;j++){

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){

                    dp[i][j] = dp[i-1][j-1];

                }
                else if (p.charAt(j-1) == '*'){

                    dp[i][j] = dp[i-1][j] | dp[i][j-1];

                }
                else{
                    dp[i][j] = 0;

                }
            }
        }




        if(dp[n][m] == 0) return false;
        return true;

    }


    public static  int  isallstarssp(String p,int i){
        for(int n = 1; n <= i;n++){//j is the index
            if(p.charAt(n-1) != '*') return 0;

        }
        return 1;
    }
    public boolean isMatchspace(String s, String p) {
        //t.c -> o(n*m)
        //s.c -> o(m)
        int n = s.length();
        int m = p.length();

        int[] prev = new int[m+1];
        int[] temp = new int[m+1];

        prev[0] = 1;

        for(int i = 1;i <= m;i++){
            prev[i] = isallstars(p,i);
        }

        for(int i = 1; i<= n;i++){
            temp = new int[m+1];
            temp[0] = 0;
            for(int j = 1;j <= m;j++){

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){

                    temp[j] = prev[j-1];

                }
                else if (p.charAt(j-1) == '*'){

                    temp[j] = prev[j] | temp[j-1];

                }
                else{
                    temp[j] = 0;

                }
            }
            prev = temp;
        }




        if(prev[m] == 0) return false;
        return true;

    }


}
