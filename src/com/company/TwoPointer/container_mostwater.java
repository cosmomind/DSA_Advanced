package com.company.TwoPointer;

public class container_mostwater {
    public int maxAreanaive(int[] height) {
        //o(n^2),o(1)
        int n = height.length;
        int max = 0;int maxl = height[0];
        int r = n-1;int area = 0;

        for(int i = 0; i< n-1;i++){
            if(height[i] >= maxl){
                max = height[r];
                while(r > i){

                    if(height[r] >= max){
                        int b = r - i ;
                        int l = Math.min(height[i],height[r]);
                        area = Math.max(area,l*b);
                    }
                    r--;
                }
                r = n-1;
                max = 0;
                maxl = height[i];
            }
        }

        return area;
    }

    public int maxArea(int[] height) {
        //o(n),o(1)
        int n = height.length;
        int max = 0;int maxl = height[0];
        int l = 0;
        int r = n-1;int area = 0;

        while(l < r){
            area = Math.max(area , (r - l) * Math.min(height[r],height[l]));
            if(height[r] < height[l]) r -= 1;
            else l += 1;
        }

        return area;
    }
}
