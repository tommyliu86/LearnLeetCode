package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/4/13 9:01
 */
public class MostFrequentEven {
    /**
     * 利用map存储偶数元素的个数，在遍历时把个数和当前元素的最小值存储下来即可
     */
    class Solution {
        public int mostFrequentEven(int[] nums) {
            Map<Integer,Integer> counts=new HashMap<>();
            int max=-1;
            int ans=Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i]&1)==1) {
                    continue;
                }
                int i1 = counts.getOrDefault(nums[i], 0) + 1;
                counts.put(nums[i], i1);
                if (max==i1){
                    ans=Math.min(ans,nums[i]);
                }else if (max<i1){
                    max=i1;
                    ans=nums[i];
                }
            }
            return ans==Integer.MAX_VALUE?-1:ans;
        }
    }
}
