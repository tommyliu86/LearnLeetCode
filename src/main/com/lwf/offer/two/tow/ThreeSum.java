package com.lwf.offer.two.tow;

import java.util.*;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans=new ArrayList<>();
            if (nums.length<3|| nums[0]>0||nums[nums.length-1]<0) return ans;
            Set<List<Integer>> set = new HashSet<>();
            /**
             * 这里需要注意如何排除重复取值问题，使用 当前i与i-1比较，如果相同则表示使用过了。可以跳过！
             */
            for (int i = 0;i < nums.length&&nums[i]<1; i++) {
                int num = nums[i];
                if (i!=0&&nums[i]==nums[i-1]) continue;
                int j=i+1,k=nums.length-1;
                while (j<k){
                    if (nums[j]+nums[k]+num==0){
                        set.add(new ArrayList<>(Arrays.asList(num,nums[j],nums[k])));
                        j++;
                       while (j<k&&nums[j]==nums[j-1]){
                           j++;
                       }
                    }else if (nums[j]+nums[k]+num>0){
                        k--;
                    }else{
                        j++;
                    }
                }

            }
            ans.addAll(set);
            return ans;
        }
    }
}
