package com.lwf.oneLearnOneday.normal;

/**
 * 2079. 给植物浇水
 * @author: liuwenfei
 * @date: 2024/5/8-9:23
 */
public class WateringPlants {
    /**
     * 前缀和计算
     *
     */
    class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int[] sum=new int[plants.length+1];
            for (int i = 1; i < sum.length; i++) {
                sum[i]=sum[i-1]+plants[i-1];
            }
            int ans=0;
            int i=0;
            //水每次需要补充时，总量+上已经浇水过的花，这样就可以继续做前缀和比较
            int water=capacity;
            while (i<plants.length){
                if (water<sum[i+1]){
                    ans+=(i)*2;
                    water=capacity+sum[i] ;
                }
                ans++;
                i++;

            }
            return ans;
        }
    }
}
