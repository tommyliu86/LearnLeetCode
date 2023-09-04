package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    /**
     * 双指针一次遍历
     */
    class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < nums.length; ) {
                int j = i + 1;
                boolean down = false;
                while (j < nums.length && nums[j] - nums[j - 1] == 1) {
                    j++;
                    down = true;
                }
                if (down){
                    ans.add(""+nums[i]+"->"+nums[j-1]);
                }else{
                    ans.add(""+nums[i]);
                }
                i=j;
            }
            return ans;
        }
    }
}
