package com.company.DP.partition;

import java.util.Arrays;

public class booleanevaal {
    static int mod=1000000007;
    public static int getans( long[][][] dp,String exp,
                              int i,int j,int istrue) {
        //t.c -> o(n^3)
        //s.c -> o(n^2*2)+o(n)

        if(i > j) return 0;
        if(i == j){
            if(istrue == 1){

                return (exp.charAt(i) == 'T') ? 1 : 0;

            }
            else{
                return (exp.charAt(i) == 'F')?1:0;
            }
        }
        if(dp[i][j][istrue] != -1) return (int)dp[i][j][istrue];

        long ways = 0;
        for(int ind = i+1; ind<= j-1;ind+= 2){//error here
            long lf = getans(dp,exp,i,ind-1,0)% mod;
            long lt = getans(dp,exp,i,ind-1,1)% mod;
            long rf = getans(dp,exp,ind+1,j,0)% mod;
            long rt = getans(dp,exp,ind+1,j,1)% mod;

            if(exp.charAt(ind) == '&'){
                if(istrue == 1) ways = (ways + (lt * rt) % mod)%mod ;
                else{
                    ways = (ways + (lt*rf)% mod + (lf * rt)% mod+ (rf*lf)% mod)% mod;
                }

            }
            else if(exp.charAt(ind) == '|'){
                if(istrue == 1) ways = (ways + (lt * rt)% mod +(lt*rf)% mod
                        + (lf * rt)% mod)% mod;
                else{
                    ways += (rf*lf)% mod;
                }
            }
            else{
                if(istrue == 1) ways =  ways + ((lt*rf)% mod + (lf * rt)% mod)% mod;
                else{
                    ways = ways + ((rf*lf)% mod + (lt * rt)% mod)% mod;
                }

            }


        }
        dp[i][j][istrue] = (ways% mod);
        return (int)dp[i][j][istrue];

    }


    public static int evaluateExp(String exp) {

        int n = exp.length();

        long[][][] dp = new  long[n][n][2];
        for(long[][] arr:dp){
            for( long[] a:arr){
                Arrays.fill(a,-1);
            }
        }
        return getans(dp,exp,0,n-1,1) % mod;

    }
}
