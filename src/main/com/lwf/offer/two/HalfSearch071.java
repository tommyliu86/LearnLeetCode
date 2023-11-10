package com.lwf.offer.two;

import java.util.Random;

/**
 * LCR 071. 按权重随机选择
 *
 * @author liuwenfei
 * @date 2023/11/9 19:08
 */
public class HalfSearch071 {
    /**
     * random
     * 题目给定每个下标的权重，则我们在随机选择数字时，需要考虑权重比例问题，此类问题的基本思路都是考虑把权重信息放在整体中
     * 随机数的选择肯定是使用random，这里要考虑的是，random是平均随机，如何把权重考虑进去，这道题目其实是通过把每个index
     * 的取数区间通过前缀和数组来记录下来，那么我们随机到的数字落到哪个区间就选择哪个下标。
     */
    class Solution {
        int[] presum;
        Random random;
        int max;


        public Solution(int[] w) {

            presum = new int[w.length + 1];
            for (int i = 1; i < presum.length; i++) {
                presum[i] = presum[i - 1] + w[i - 1];
            }
            random = new Random();
            max = presum[w.length];
        }
        //找到第一个<=ran的
        public int pickIndex() {
            int ran = random.nextInt(max);
            int i = 0, j = presum.length - 1;
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (presum[m] > ran) {
                    j = m - 1;
                } else {
                    i = m +1 ;
                }
            }
            return j;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
}
