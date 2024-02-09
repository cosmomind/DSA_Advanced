package com.company.Array_String;

public class placeflowers {
    public boolean canPlaceFlowers(int[] bed, int n) {
        int cnt = 0;
        int len = bed.length;
        if(len == 1 && bed[len-1] == 0)return true;
        if(bed[0] == 0 && bed[1] == 0){
            bed[0] = 1;
            cnt++;
        }
        for(int i = 1;i < bed.length-1;i++){
            if(bed[i] == 0){
                if(bed[i-1] != 1 && bed[i+1] != 1){
                    bed[i] =1;
                    cnt++;
                }
            }
        }
        if(bed[bed.length-1] == 0 && bed[bed.length-2] == 0){
            cnt++;
        }
        return (cnt>=n );
    }
    //written efficiently

    public boolean canPlaceFlowersefficient(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
