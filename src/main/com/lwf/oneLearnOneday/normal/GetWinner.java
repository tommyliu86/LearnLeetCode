package com.lwf.oneLearnOneday.normal;

/**
 * 1535. 找出数组游戏的赢家
 *
 * @author: liuwenfei
 * @date: 2024/5/21-8:30
 */
public class GetWinner {
    /**
     * 暴力，模拟，每次对比留下的肯定是更大的数，数组遍历完之后，该位置上保留的是数组中的最大值，因此若
     * k>n,则结果是数组最大值。
     * k<n，从前向后找到消耗步数时的最大值即可。
     *
     */
    class Solution {
        public int getWinner(int[] arr, int k) {
            int max=arr[0],j=0;
            for (int i = 1; j < k&&i<arr.length; i++) {
                if (max>arr[i]){
                    j++;
                }else{
                    max=arr[i];
                    j=1;
                }
            }
            return max;
        }
    }
}
