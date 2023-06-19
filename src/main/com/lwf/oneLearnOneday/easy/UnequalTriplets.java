package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/6/13 8:27
 */
public class UnequalTriplets {
    /**
     *
     * 本题的核心是找中间数，因为中间的数会分隔左边和右边，而左边和右边分别取一个数的时候肯定是不相同的！
     * 如果是确定第一个数，则后两个数因为有可能有重复而不好计算的
     */
    class Solution {
        public int unequalTriplets(int[] nums) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
            int left=0,n=nums.length,ans=0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer cur = entry.getValue();
                ans+=left*cur*(n-cur-left);
                left+=cur;
            }
            return ans;
        }
    }
    /**
     * 找中间数，因为中间的数会分隔左边和右边，而左边和右边分别取一个数的时候肯定是不相同的！
     * 如果是确定第一个数，则后两个数因为有可能有重复而不好计算的
     */
    class Solution2 {
        public int unequalTriplets(int[] nums) {
            Arrays.sort(nums);
            int ans=0;
            int i=0,j=0;
            while (i<nums.length){
                j=i+1;
                while (j<nums.length&&nums[j]==nums[i]){
                    j++;
                }
                ans+=i*(j-i)*(nums.length-j);
                i=j;
            }
            return ans;
        }
    }
    class Solution1 {
        public int unequalTriplets(int[] nums) {
         int ans=0;
            for (int i = 0; i < nums.length; i++) {
                int i1=nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[j]==i1){
                        continue;
                    }
                    int i2=nums[j];
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[k]==i1||nums[k]==i2){
                            continue;
                        }
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
