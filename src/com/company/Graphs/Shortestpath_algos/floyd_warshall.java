package com.company.Graphs.Shortestpath_algos;

public class floyd_warshall {
    //t.c- >o(n^3); s.c -> o(n^2),can apply dijkstra also
    public void shortest_distance(int[][] matrix)
    {
        // Code here
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0;i< n;i++){
            for(int j=0; j< m;j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = (int)1e9;
                }
            }
        }

        for(int via = 0;via < n;via++){
            for(int i = 0;i< n;i++){
                for(int j=0; j< m;j++){
                    if(i != j) {
                        matrix[i][j] =
                                Math.min(matrix[i][j], matrix[i][via]+matrix[via][j]);

                    }

                }
            }
        }

        for(int i = 0;i<n;i++){
            if(matrix[i][i] < 0){
                //negative cycle
            }
        }



        for(int i = 0;i< n;i++){
            for(int j=0; j< m;j++){
                if(matrix[i][j] ==(int)1e9 ){
                    matrix[i][j] = -1;
                }
            }
        }

    }
}
