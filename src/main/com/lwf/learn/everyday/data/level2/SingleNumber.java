package com.lwf.learn.everyday.data.level2;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 18:15
 */
public class SingleNumber {
    class Solution {
        public int singleNumber(int[] nums) {
            int rtn=0;
            for (int i = 0; i < nums.length; i++) {
                rtn^=nums[i];
            }
            return rtn;
        }
    }
    class Solution1 {
        public int singleNumber(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    set.remove(nums[i]);
                }else{
                    set.add(nums[i]);
                }


            }
            return set.iterator().next();
        }
    }
}
