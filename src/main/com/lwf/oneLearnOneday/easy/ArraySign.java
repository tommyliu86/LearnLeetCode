package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/10/27 8:55
 */
public class ArraySign {
    class Solution {
        public int arraySign(int[] nums) {
            int ans=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]==0){
                    return 0;
                }
                if (nums[i]<0){
                    ans++;
                }
            }
            return (ans&1)==1?-1:1;
        }
    }
}
