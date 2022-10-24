package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/10/24 9:25
 */
public class PartitionDisjoint {
    class Solution {
        public int partitionDisjoint(int[] nums) {
            int[] indexes=new int[nums.length];

            int min=nums[ nums.length-1];
            for (int i = nums.length - 1; i >= 0; i--) {
               min=Math.min(min,nums[i]);
                indexes[i]=min;
            }
            int max=nums[0];
            for (int i = 0; i < nums.length-1; i++) {
                max=Math.max(max,nums[i]);
                if (max<=indexes[i+1]){
                    return i+1;
                }
            }

            return 0;
        }
    }
}
