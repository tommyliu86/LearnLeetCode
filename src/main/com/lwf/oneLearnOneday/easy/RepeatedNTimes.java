package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-21 10:41
 */
public class RepeatedNTimes {
    class Solution {
        public int repeatedNTimes(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])){
                    return nums[i];
                }else{
                    set.add(nums[i]);
                }
            }
            return set.iterator().next();
        }
    }
}
