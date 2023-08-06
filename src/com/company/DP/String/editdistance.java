package com.company.DP.String;

public class editdistance {
    //t.c -> o(n*m);
    //s.c -> o(n*m)+o(n+m)
    public int getans(int[][] dp,int i,int j,String word1, String word2) {

        if(j < 0){
            return i+1;
        }
        if(i < 0){
            return j+1;
        }


        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j] = 0 + getans(dp,i-1,j-1,word1,word2);
        }
        else{
            int ins = 1 + getans(dp,i,j-1,word1,word2);
            int del = 1+ getans(dp,i-1,j,word1,word2);
            int repl = 1 + getans(dp,i-1,j-1,word1,word2);
            return dp[i][j] = Math.min(ins,Math.min(del,repl));
        }



    }


    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                dp[i][j] = -1;
            }
        }

        return getans(dp,n-1,m-1,word1,word2);
    }

    public int minDistancetab(String word1, String word2) {
        //t.c -> o(n*m);
        //s.c -> o(n*m);
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i <= n;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j <= m;j++){
            dp[0][j] = j;
        }

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= m;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = 0 + dp[i-1][j-1];
                }
                else{
                    int ins = 1 + dp[i][j-1];
                    int del = 1+ dp[i-1][j];
                    int repl = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(ins,Math.min(del,repl));
                }
            }
        }

        return dp[n][m];
    }
    public int minDistancesp(String word1, String word2) {
        //t.c -> o(n*m);
        //s.c -> o(m)
        int n = word1.length();
        int m = word2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for(int j = 0;j <= m;j++){
            prev[j] = j;
        }

        for(int i = 1;i <= n;i++){
            curr = new int[m+1];
            curr[0] = i;
            for(int j = 1;j <= m;j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    curr[j] = 0 + prev[j-1];
                }
                else{
                    int ins = 1 +curr[j-1];
                    int del = 1+ prev[j];
                    int repl = 1 + prev[j-1];
                    curr[j] = Math.min(ins,Math.min(del,repl));
                }

            }
            prev = curr;
        }

        return prev[m];
    }
}
