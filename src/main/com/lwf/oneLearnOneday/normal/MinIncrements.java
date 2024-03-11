package com.lwf.oneLearnOneday.normal;

/**
 * 2673. 使二叉树所有路径值相等的最小代价
 *
 * @author: liuwenfei
 * @date: 2024/3/8-9:09
 */
public class MinIncrements {
    /**
     * 考虑 一个根到叶子节点的路径i，它和兄弟叶子节点j的路径都相同，因此为了相等，我们需要让i和j的值相同，
     * 然后我们考虑i，j的父节点，这个节点的兄弟节点也和i，j一样，需要相等才行，不然无法相同。
     */
    class Solution {
        public int minIncrements(int n, int[] cost) {
            //从底向上，遍历一遍进行兄弟节点的比较。
            int ans = 0;
            for (int i = n; i > 1; i -= 2) {
                int i1 = cost[i - 1];
                int i2 = cost[i - 2];
                ans += Math.abs(i1 - i2);
                //把叶子节点的值放入到父节点中，这样就可以把父节点配平了。
                cost[(i - 2) / 2] += Math.max(i1, i2);
            }
            return ans;
        }
    }


}
