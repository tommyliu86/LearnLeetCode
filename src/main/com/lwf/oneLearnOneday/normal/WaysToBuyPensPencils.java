package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/9/1 8:51
 */
public class WaysToBuyPensPencils {
    /**
     * 遍历
     */
    class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            long ans = 0;
            if (cost1 < cost2) {
                int temp = cost2;
                cost2 = cost1;
                cost1 = temp;
            }
            if (cost2 > total) return 1;
            int i = 0;
            while (i * cost1 <= total) {
                int remain = total - cost1 * i;
                int j = remain / cost2;
                ans += j + 1;
                i++;
            }
            return ans;
        }
    }
}
