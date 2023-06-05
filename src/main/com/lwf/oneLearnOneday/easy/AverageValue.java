package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/5/29 8:52
 */
public class AverageValue {
    /**
     * 直接遍历
     */
    class Solution {
        public int averageValue(int[] nums) {
        int sum=0,count=0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i]%2==0&&nums[i]%3==0){
                    sum+=nums[i];
                    count++;
                }
            }
            return count==0?0: sum/count;
        }
    }

    /**
     * 直接stream
     */
    class Solution1 {
        public int averageValue(int[] nums) {

            int[] ints = Arrays.stream(nums).filter(i -> i % 2 == 0 && i % 3 == 0).toArray();
            if (ints.length == 0) return 0;
            return Arrays.stream(ints).sum() / ints.length;
        }
    }
}
