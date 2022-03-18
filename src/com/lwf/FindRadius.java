package com.lwf;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-18-22:08
 * {@link 475.md}
 */
public class FindRadius {
    public static void main(String[] args) {
        new FindRadius().findRadius( new int[]{1,2,3,4},new int[]{1,4});
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses );
        Arrays.sort(heaters);
        int s=0;
        int h=0;
        int radius= Integer.MIN_VALUE;
        while (s<houses.length&&h<heaters.length){
            if (houses[s]>heaters[h]){
                h++;
            }else   {
                if (h>0){
                radius=Math.max(Math.min(heaters[h]-houses[s],houses[s]-heaters[h-1]),radius);
                }
                else{
                    radius=Math.max(heaters[h]-houses[s],radius);
                }
                s++;
            }
        }
        if (s==houses.length) {
            return radius;
        }
        else    {
            return Math.max((radius),houses[houses.length-1]-heaters[heaters.length-1]);
        }
    }
}
