package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.*;

public class MinSubsequence {
    class Solution {
        public List<Integer> minSubsequence(int[] nums) {
            Arrays.sort(nums);
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                sum+=nums[i];
            }
            List<Integer> rtn=new ArrayList<>();
            int subSum=0;
            int i=nums.length-1;
            while (i>=0& subSum<=sum-subSum){
                rtn.add(nums[i]);
                subSum+=nums[i--];
            }
            return rtn;
        }
    }
}
