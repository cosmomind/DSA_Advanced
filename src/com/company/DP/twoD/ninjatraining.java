package com.company.DP.twoD;

public class ninjatraining {
    //t.c -> o(n*4*3),s.c -> o(n*4)+o(n)
    public int mem(int[][] dp,int points[][],int n,int last){
        if(n == 0){
            int maxi = 0;
            for(int i = 0; i< 3;i++){
                if(i != last) maxi = Math.max(maxi,points[0][i]);
            }
            return maxi;
        }
        if(dp[n][last] != -1) return dp[n][last];
        int maxim = 0;
        for(int i = 0; i< 3;i++){

            if(i != last) {

                maxim = Math.max(maxim,points[n][i] + mem(dp,points,n-1,i));
            }
        }
        return dp[n][last] = maxim;




    }
    public int maximumPointsmem(int points[][],int N){
        int[][] dp = new int[N][4];
        for(int i = 0;i < N;i++){
            for(int j = 0;j< 4;j++) dp[i][j] = -1;
        }
        return  mem(dp,points,N-1,3);

    }
    //tabulation
    public int maximumPoints(int points[][],int N){



        //tabulation
        //t.c -> o(n*4*3),s.c -> o(n*4)
        int[][] ans = new int[N][4];
        ans[0][0] = Math.max(points[0][1],points[0][2]);
        ans[0][1] = Math.max(points[0][0],points[0][2]);
        ans[0][2] = Math.max(points[0][1],points[0][0]);
        ans[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day = 1;day < N;day++){

            for(int next = 0;next < 4;next++){//each day's max stored in next = 3
                ans[day][next] = 0;
                for(int task = 0;task < 3;task++){
                    if(task != next){

                        ans[day][next] = Math.max(ans[day][next],points[day][task] + ans[day-1][task]);



                    }


                }


            }


        }
        return ans[N-1][3];

    }

    public int spaceoptimal(int points[][],int N){
        //t.c -> o(n*4*3),s.c -> const,o(4)
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][1],points[0][0]);
        prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for(int day = 1;day < N;day++){
            int[] temp = new int[4];
            for(int next = 0;next < 4;next++){//each day's max stored in next = 3
                temp[next] = 0;
                for(int task = 0;task < 3;task++){
                    if(task != next){

                        temp[next] = Math.max(temp[next],points[day][task] + prev[task]);



                    }


                }


            }
            prev= temp;


        }
        return prev[3];

    }
}
