package com.lwf.oneLearnOneday.normal;

import java.util.HashMap;
import java.util.Map;

public class MinSubarray {
    class Solution {
        public int minSubarray(int[] nums, int p) {
            int remain=0;
            for (int i = 0; i < nums.length; i++) {
                remain=(remain+nums[i])%p;
            }
            if (remain==0) return 0;
            Map<Integer,Integer> indexs=new HashMap<>();
            int sums=0;
            int min=nums.length;
            for (int i = 0; i < nums.length; i++) {
                //这里的map存储的就是前缀和，因此这里先放入map，这样和前缀和的sum保持一致
                indexs.put(sums,i);
                sums=(sums+nums[i])%p;
                //这里通过+p %p来计算差值，sums有可能会小于remain，但是sums是%p过的，因此我们通过+p来消除分支判断
                if (indexs.containsKey((sums-remain+p)%p)){
                    min=Math.min(min,i-indexs.get((sums-remain+p)%p)+1);
                }
            }
           return min;
        }
    }
}
