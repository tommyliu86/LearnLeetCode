package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/2/16 9:02
 */
public class NumberOfPairs {
    /**
     * 由于数量小于100，因此可以直接使用hash表做统计
     */
    class Solution {
        public int[] numberOfPairs(int[] nums) {
            Map<Integer,Integer> map=new HashMap<>();
            int remain=0,count=0;
            for (int i = 0; i < nums.length; i++) {
                Integer cur = map.getOrDefault(nums[i], 0)+1;
                if (cur==2) {
                    remain--;
                    count++;
                    map.put(nums[i],0);
                }else{
                    remain++;
                    map.put(nums[i],cur);
                }
            }
            return new int[]{count,remain};
        }
    }

    /**
     * 排序后遍历
     */
    class Solution1 {
        public int[] numberOfPairs(int[] nums) {
            Arrays.sort(nums);
            int remain = 0, count = 0, i = 0, j = 0;
            while (j < nums.length) {
                while (j < nums.length && nums[j] == nums[i]) {
                    j++;
                }
                count += (j - i) / 2;
                remain += (j - i) % 2;
                i = ++j;
            }
            return new int[]{count, remain};


        }
    }
}
