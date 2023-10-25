package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * 1402. 做菜顺序
 * https://leetcode.cn/problems/reducing-dishes/description/?envType=daily-question&envId=2023-10-25
 * @author liuwenfei
 * @date 2023/10/24 9:20
 */
public class MaxSatisfaction {
    class Solution {
        /**
         * 贪心 递推 前缀和
         * 我们通过 模拟取值  ： 设int[] 从大到小排列
         * 取一个，则使用 最大的 int[0]
         * 取两个，则使用 最大的 +第二大  2*int[0]+int[1] 因为此时最大的下标也变大了，
         * 取三个， 3*int[0]+2*int[1]+int[2] 可以得到状态转移公式  f(n)=f(n-1)+(int[0]+..+int[n])
         * 因此我们可以从大到小排列后，直接进行计算，终止条件 是 int[] 的前缀和<0,
          * @param satisfaction
         * @return
         */
        public int maxSatisfaction(int[] satisfaction) {
            Arrays.sort(satisfaction);
            int sum=0;
            int ans=0;
            for (int i = satisfaction.length - 1; i >= 0; i--) {
                sum+=satisfaction[i];
                if (sum<0){
                    break;
                }
                ans+=sum;
            }
            return ans;
        }
    }

    /**
     * DP
     * 动态规划  0-1背包问题
     */
    class Solution1 {
        /**
         * dp 算法，注意边界条件  j==i时的情况
         *
         * @param satisfaction
         * @return
         */
        public int maxSatisfaction(int[] satisfaction) {
            //正向排序 越大的越往后
            Arrays.sort(satisfaction);
            //i 表示当前第i道菜，j表示从i道菜中取多少，j<=i
            int[][] max = new int[satisfaction.length + 1][satisfaction.length + 1];

            for (int i = 1; i < max.length; i++) {
                for (int j = 1; j <= i; j++) {
                    //j==i时，max[i-1][j] 是无效的，
                    max[i][j] = max[i - 1][j - 1] + j * satisfaction[i - 1];
                    if (j < i) {
                        max[i][j] = Math.max(max[i][j], max[i - 1][j]);
                    }
                }
            }
            return Arrays.stream(max[satisfaction.length]).max().getAsInt();

        }
    }
}
