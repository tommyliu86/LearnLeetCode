package com.lwf.oneLearnOneday.normal;

import com.lwf.oneLearnOneday.hard.IntersectionSizeTwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/7/17 9:52
 */
public class FourSum {
    /**
     * 需要考虑去重和边界条件
     */
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Arrays.sort(nums);
            List<List<Integer>> ans=new ArrayList<>();
            for (int i = 0; i < nums.length-3; i++) {
                if (i-1>=0&& nums[i]==nums[i-1]){
                    continue;
                }
                if ((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                    break;
                }
                if ((long)nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target){
                    continue;
                }
                for (int j = i+1; j < nums.length; j++) {
                    if (j>i+1&& nums[j]==nums[j-1]){
                        continue;
                    }
                    List<List<Integer>> dou = dou(nums, j + 1, nums.length - 1, (long)(target - nums[i] - nums[j]));
                    for (List<Integer> integers : dou) {
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        ans.add(integers);
                    }
                }
            }
            return ans;
        }
        public List<List<Integer>> dou(int[] nums, int i, int j, long target){
            List<List<Integer>> ans=new ArrayList<>();
            while (i<j){
                if (nums[i]+nums[j]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ans.add(list);
                    //不取重复
                    j--;
                    while (j>i&& nums[j]==nums[j+1]){
                        j--;
                    }
                    i++;
                    while (j>i&& nums[i]==nums[i-1]){
                        i++;
                    }
                }else if (nums[i]+nums[j]>target){
                    j--;
                }else{
                    i++;
                }
            }
            return ans;
        }
    }
}
