package com.company.DP.String;

public class distinctsubseq {
    //t.c -> o(n*m)
    //s.c -> o(n*m) + o(n+m)
    static int prime = (int)(Math.pow(10,9)+7);
    public static int getans(int[][] dp,String t, String s,int n,int m) {

        if(m < 0) return 1;
        if(n < 0) return 0;

        if(dp[n][m] != -1) return dp[n][m];
        if(t.charAt(n) == s.charAt(m)){
            return dp[n][m] = (getans(dp,t,s,n-1,m-1) + getans(dp,t,s,n-1,m));
        }
        else{
            return dp[n][m] = getans(dp, t, s, n-1, m);
        }


    }
    public int numDistinct(String str1, String str2) {
        int lt = str1.length();
        int ls = str2.length();
        int[][] dp = new int[lt][ls];
        for(int i = 0;i < lt;i++){
            for(int j = 0; j< ls;j++){
                dp[i][j] = -1;

            }
        }
        return getans(dp,str1,str2,lt-1,ls-1) ;
    }

    public int numDistincttab(String str1, String str2) {
        //t.c -> o(n*m)
        //s.c -> o(n*m)
        int lt = str1.length();
        int ls = str2.length();
        int[][] dp = new int[lt+1][ls+1];
        for(int j = 0; j< lt+1;j++){
            dp[j][0] = 1;//when str2 is over

        }
        for(int i = 1;i < ls+1;i++){
            dp[0][i] = 0;
        }

        for(int i = 1;i < lt+1;i++){
            for(int j = 1; j< ls+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else{
                    dp[i][j] =  dp[i-1][j];
                }

            }
        }
        return dp[lt][ls] ;
    }


    public int numDistinctsp(String str1, String str2) {
        int lt = str1.length();
        int ls = str2.length();

        int[] prev = new int[ls+1];
        int[] temp = new int[ls+1];
        prev[0] = 1;temp[0] = 1;//imp
        for(int j = 1; j< ls+1;j++){
            prev[j]= 0;//when str2 is over

        }


        for(int i = 1;i < lt+1;i++){
            temp = new int[ls+1];
            temp[0] =1;
            for(int j = 1; j< ls+1;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    temp[j] = prev[j-1] + prev[j];
                }
                else{
                    temp[j] =  prev[j];
                }

            }
            prev= temp;
        }
        return prev[ls];
    }

    public int numDistinctonly1array(String str1, String str2) {
        int lt = str1.length();
        int ls = str2.length();

        int[] prev = new int[ls+1];

        prev[0] = 1;
        for(int j = 1; j< ls+1;j++){
            prev[j]= 0;//when str2 is over

        }


        for(int i = 1;i < lt+1;i++){

            for(int j = ls; j >= 1;j--){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    prev[j] = prev[j-1] + prev[j];
                }
            }
        }
        return prev[ls];
    }
}
