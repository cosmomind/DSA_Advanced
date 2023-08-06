package com.company.DP.String;

public class shortestcommsuperseq {
    public static String shortestSupersequence(String a, String b) {
        //t.c -> o(n*m)
        //s.c -> o(n*m)
        // using lcs dp table
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = 0+Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }

        //i and j  = 0 means invalid
        String ans = "";
        int i = n;int j = m;
        while(i > 0 && j > 0){
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans += a.charAt(i-1);
                i--;j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                ans += a.charAt(i-1);
                i--;
            }
            else{
                ans += b.charAt(j-1);
                j--;
            }
        }

        while(i > 0){
            ans += a.charAt(i-1);
            i--;
        }
        while(j > 0){
            ans += b.charAt(j-1);
            j--;
        }
        StringBuilder anss = new StringBuilder(ans);
        return anss.reverse().toString();
    }
}
