package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/10/7 18:55
 */
public class CanPlaceFlowers {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count=0;
            int end=0;
            while (end<flowerbed.length){
                if (flowerbed[end]==0){
                    int start=end;
                    while (end<flowerbed.length&&flowerbed[end]==0){
                        end++;
                    }
                    int step=end-start-1;
                    if (start==0){
                        step++;
                    }
                    if (end==flowerbed.length){
                        step++;
                    }
                    count+=(step/2);
                }else{
                    end++;
                }
            }
            return count>=n;
        }
    }
}
