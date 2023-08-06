package com.company.DP.String;

public class longcommonsubseq {

    public static int lcsspaceoptm(String s, String t) {
        //t.c -> o(n*m)
        //s.c -> o(m)
        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];



        for(int i = 1;i<= n;i++){
            curr = new int[m+1];
            for (int j = 1; j <= m; j++) {

                if(s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = 1 +prev[j-1];
                }
                else{
                    curr[j] = 0+ Math.max(curr[j-1],prev[j]);
                }
            }
            prev = curr;
        }


        return prev[m];
    }
    public static int lcstab(String s, String t) {
        //t.c -> o(n*m)
        //s.c -> o(n*m)
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];


        for(int i = 0;i <= n;i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }


        for(int i = 1;i<= n;i++){
            for (int j = 1; j <= m; j++) {

                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0+ Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }


        return dp[n][m];
    }


    public static int memoize(int[][] dp,String s, String t,int i,int j) {
        //t.c -> o(n+m)+o(n*m)
        //s.c -> o(n*m)
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != -1)return dp[i][j];

        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + memoize(dp, s, t, i-1, j-1);
        }
        else{
            return  dp[i][j] = 0+ Math.max(memoize(dp, s, t, i, j-1),memoize(dp, s, t, i-1, j));
        }


    }



    public static int lcs(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n][m];
        for(int i = 0;i< n;i++){
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }


        return memoize(dp,s,t,n-1,m-1);
    }
}
