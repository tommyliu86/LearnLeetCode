package com.lwf.oneLearnOneday.easy;

/**
 * 2917. 找出数组中的 K-or 值
 * @author: liuwenfei
 * @date: 2024/3/6-10:44
 */
public class FindKOr {
    /**
     * 位运算，按位与进行遍历即可
     */
    class Solution {
        public int findKOr(int[] nums, int k) {
            int ans=0;
            for (int i = 0; i < 31; i++) {
                int x=1<<i;
                int count=0;
                for (int num : nums) {
                    if ((num&x)!=0) {
                        count++;
                    }
                }
                if (count>=k){
                    ans+=x;
                }
            }
            return ans;
        }
    }
}
