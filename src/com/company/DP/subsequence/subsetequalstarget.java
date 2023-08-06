package com.company.DP.subsequence;

public class subsetequalstarget {
    //t.c -> o(n*m)
    //s.c -> o(n*m)+o(n)
    public static boolean memoize(int[][] dp,int n, int target, int arr[]){
        if(target == 0) return true;
        if(n == 0) return (arr[0] == target);

        if(dp[n][target] != -1) return dp[n][target]==1?true:false;
        boolean ntake = memoize(dp,n-1,target,arr);
        boolean take = false;
        if(arr[n] <= target){
            take = memoize(dp,n-1,target - arr[n],arr);
        }
        dp[n][target] = (take || ntake) == true?1:0;
        return take || ntake;


    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        //because we need to know if we already calculated using -1,it needs to be int
        for(int i = 0;i < n;i++){
            for(int j = 0;j < k+1;j++){//be careful
                dp[i][j] = -1;
            }
        }

        return memoize(dp,n-1,k,arr);
    }

    public static boolean subsetSumToKtab(int n, int k, int arr[]){
        //t.c -> o(n*m)
        // s.c -> o(n*m)
        boolean[][] dp = new boolean[n][k+1];

        //base cases
        for(int row = 0; row <n;row++ ){
            dp[row][0] = true;//when target is 0
        }

        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }

        for(int ind = 1;ind <n;ind++){
            for(int target = 1;target < k+1;target++){
                boolean ntake = dp[ind- 1][target];
                boolean take = false;
                if(arr[ind] <= target){
                    take = dp[ind- 1][target- arr[ind]];
                }
                dp[ind][target] = take || ntake;
            }
        }
        return dp[n-1][k];
    }

    public static boolean subsetSumToKspace(int n, int k, int arr[]){
//t.c -> o(n*m)
        // s.c -> o(m)

        //base cases
        boolean[] prev = new boolean[k+1];
        boolean[] temp = new boolean[k+1];
        temp[0] = true;
        prev[0] = true;
        if(arr[0] <= k){
            prev[arr[0]] = true;
        }

        for(int i = 1;i< n;i++){
            for(int target = 1;target < k+1;target++){

                boolean ntake = prev[target];
                boolean take = false;
                if(arr[i] <= target){
                    take = prev[target- arr[i]];
                }
                temp[target] = take || ntake;
            }
            prev = temp;
            temp = new boolean[k+1];
            temp[0] = true;
        }
        return prev[k];
    }
}
