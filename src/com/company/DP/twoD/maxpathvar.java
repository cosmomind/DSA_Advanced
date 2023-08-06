package com.company.DP.twoD;

public class maxpathvar {

    public static int getans(int[][] dp,int[][] m,int i,int j) {
        if(j < 0 || j >= m[0].length) return  (int) - Math.pow(10,9);
        if(i == 0){
            return m[0][j];
        }


        if(dp[i][j] != -1) return dp[i][j];

        int up = m[i][j] + getans(dp,m,i-1,j);
        int ld = m[i][j] + getans(dp,m,i-1,j-1);
        int rd = m[i][j] + getans(dp,m,i-1,j+1);

        return dp[i][j] = Math.max(up,Math.max(ld,rd));




    }
    public static int getMaxPathSummem(int[][] m) {
        //t.c -> O(n*m),s.c ->O(n*m)+ o(n)
        int n = m.length;
        int col = m[0].length;//columns
        int[][] dp = new int[n][col];
        for(int i = 0;i < n;i++){
            for(int j = 0 ;j < col;j++){
                dp[i][j] = -1;
            }

        }

        int max = (int) - Math.pow(10,9);
        for (int i = 0; i < col; i++) {
            int ans = getans(dp,m,n-1,i);
            if(ans > max) max = ans;
        }

        return max;
    }


    public static int getMaxPathSumtab(int[][] m) {
        //t.c -> O(n*m),s.c ->O(n*m)
        int n = m.length;
        int col = m[0].length;//columns
        int[][] dp = new int[n][col];
        for(int i = 0;i < n;i++){
            for(int j = 0 ;j < col;j++){

                if(i == 0){
                    dp[0][j] = m[0][j];

                }
                else{
                    int  up = m[i][j] + dp[i-1][j];
                    int ld = m[i][j];
                    if(j > 0)  ld +=   dp[i-1][j-1];
                    else ld += (int) Math.pow(-10,9);
                    int rd = m[i][j];
                    if(j < col-1)  rd += dp[i-1][j+1];
                    else rd += (int) Math.pow(-10,9);
                    dp[i][j] = Math.max(up,Math.max(ld,rd));
                }
            }

        }



        int max = dp[n-1][0];
        for (int i = 1; i < col; i++) {
            int ans = dp[n-1][i];
            if(ans > max) max = ans;
        }

        return max;
    }

    //t.c ->o(n*m);s.c ->o(n)



}
