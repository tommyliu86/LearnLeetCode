package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/9/15 8:33
 */
public class GiveGem {
    /**
     * 两次遍历
     */
    class Solution {
        public int giveGem(int[] gem, int[][] operations) {
            int min= 10000,max=0;
            for (int i = 0; i < operations.length; i++) {
                int[] op = operations[i];
                int given = gem[op[0]] / 2;
                gem[op[0]]-=given;
                gem[op[1]]+=given;
            }
            for (int i = 0; i < gem.length; i++) {
                min= Math.min(min,gem[i]);
                max= Math.max(max,gem[i]);
            }
            return max-min;
        }
    }
}
