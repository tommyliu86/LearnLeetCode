package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/10/24 8:36
 */
public class NumRollsToTarget {
    /**
     * 灵神的 推导过程。
     * https://leetcode.cn/problems/number-of-dice-rolls-with-target-sum/solutions/2495836/ji-bai-100cong-ji-yi-hua-sou-suo-dao-di-421ab/?envType=daily-question&envId=2023-10-24
     */
    class Solution {
        //target拆分成 n个数的和，数从 1 到k 因此每个骰子可以选择的范围是1到k，
        //题目的特征比较明显 是用dp，假设 在i 处 我们有所有的可能性的值，f（i，j) j=(1~target) 则多一个骰子时，f（i+1，j）=sum（f（i，j)）j=（1~k）
        //因为
        public int numRollsToTarget(int n, int k, int target) {
            int mod=1000_000_000+7;
            int[][] nums=new int[n+1][target+1];
            //为了进行dp的初始化，在计算只有一颗骰子时，会从一颗都没有的（0，0）这里取值，因此设置一个1
            nums[0][0]=1;
            for (int i = 1; i < nums.length; i++) {
                int[] num = nums[i];
                for (int j = i; j < num.length; j++) {
                    for (int i1 = 1; i1 <= k; i1++) {
                        if (j>=i1){
                            num[j]= (num[j]+ nums[i-1][j-i1])%mod;
                        }
                    }
                }
            }
            return nums[n][target];
        }
    }
}
