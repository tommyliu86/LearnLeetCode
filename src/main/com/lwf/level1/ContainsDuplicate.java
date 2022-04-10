package com.lwf.level1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 12:45
 */
public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set=new HashSet<>();
            for(int i=0;i<nums.length;i++){
                if (set.contains(nums[i])){
                    return true;
                }else{
                    set.add(nums[i]);
                }
            }
            return false;
        }

        public boolean method2(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i]==nums[i+1]){
                    return true;
                }
            }
            return false;
        }


    }
}
