package com.company.Graphs.BFS_DFS;


//s.c,t.c ->o(n*m)
public class flood_fill {
    private void dfs(int sr,int sc,
                     int[][] ans,int[] nrow,int[] ncol,int newcolor,int ini){
        int n = ans.length;
        int m = ans[0].length;

        for(int i = 0;i < 4;i++){
            int currow = nrow[i] + sr;
            int curcol = ncol[i] + sc;

            if(currow >= 0 && currow < n &&
                    curcol >= 0 && curcol < m &&
                    ans[currow][curcol] == ini && ans[currow][curcol] != newcolor){
                ans[currow][curcol] = newcolor;
                dfs(currow,curcol,ans,nrow,ncol,newcolor,ini);
            }


        }



    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here
        int[][] ans = image;
        int ini = image[sr][sc];
        int[] nrow = {-1,0,1,0};
        int[] ncol = {0,1,0,-1};
        ans[sr][sc] = newColor;
        dfs(sr,sc,ans,nrow,ncol,newColor,ini);

        return ans;

    }
}
