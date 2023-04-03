package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/3/29 8:53
 */
public class CountVowelStrings {
    /**
     * 直接数学计算,假设末尾为 i，则剩余的n-1位，只能用a，e，i，也就是有3种可能，如何取值就是（n-1）！/（n-1- 3）！
     *
     * 等价于求把n个球放到 5个篮子 有多少种方法（允许空篮）
     *
     * 因为允许空篮，所以我们额外添加5个球（相当于每个篮子虚拟的给一个球），转化成不允许空篮的情况
     *
     * 然后再用隔板法，一共n+5-1个位置，需要5-1个隔板，因此答案是C(n+4,4)
     */
    class Solution {
        public int countVowelStrings(int n) {

            return (n+1)*(n+2)*(n+3)*(n+4)/24;
        }
    }


    /**
     * dp动态规划，用i表示长度，j表示当前长度时，末尾的字母组合出的组合
     */
    class Solution1 {
        public int countVowelStrings(int n) {
            int[][] dp = new int[n][5];
            Arrays.fill(dp[0], 1);
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
            return Arrays.stream(dp[n - 1]).sum();
        }
    }
}
