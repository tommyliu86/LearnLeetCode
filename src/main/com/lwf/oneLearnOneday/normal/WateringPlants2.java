package com.lwf.oneLearnOneday.normal;

/**
 * 2105. 给植物浇水 II
 * @author: liuwenfei
 * @date: 2024/5/8-9:23
 */
public class WateringPlants2 {
    /**
     * 使用动态前缀和，从前向后进行前缀和累加，当sum>capacity时，进行次数加1，然后sum从0开始重新计数
     */
    class Solution {
        public int minimumRefill(int[] plants, int capacityA, int capacityB) {
            int sumA=0,sumB=0,ans=0;
            int n = plants.length / 2 + plants.length % 2;
            int a=0,b=plants.length-1;
            for (int i = 0; i < n; i++) {
                if (a!=b){
                    if (capacityA<sumA+plants[a]){
                        ans++;
                        sumA=plants[a++];
                    }else{
                        sumA+=plants[a++];
                    }
                    if (capacityB<sumB+plants[b]){
                        ans++;
                        sumB=plants[b--];
                    }else{
                        sumB+=plants[b--];
                    }
                }else{
                    if (capacityA-sumA<plants[i]&&capacityB-sumB<plants[i]){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
