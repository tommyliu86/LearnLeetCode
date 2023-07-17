package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author Administrator
 * time 2019-09-23-22:53
 */
public class ThreeSum {
    /**
     * 双重循环
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans=new ArrayList<>();
            if (nums[0]>0)return ans;
            int t=0;
            while (t<nums.length-1){
                find(nums,t+1,nums.length-1,t,ans);
                while (t<nums.length-1&& nums[t]==nums[++t]){

                }
            }
            return ans;
        }

        public void find(int[] nums,int i,int j,int t,List<List<Integer>> ans){
            while (i<j){
                if (nums[i]+nums[j]+nums[t]==0){
                    ans.add(List.of(nums[t],nums[i],nums[j]));
                    while (i<j&&nums[i]==nums[++i]){

                    }
                }else if(nums[i]+nums[j]+nums[t]<0){
                    i++;
                }else{
                    j--;
                }
            }
        }
    }
    class Solution1{

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> list = new ArrayList<>();
            if (nums == null || nums.length < 3) return list;
            Arrays.sort(nums);

            int max = nums[nums.length - 1] + nums[nums.length - 2];
            if (max < 0 || nums[0] > 0) {
                return list;
            }

            for (int i = 0; i < nums.length - 2; i++) {

                int min = nums[i + 1] + nums[i + 2];

                if (nums[i] + min > 0 || nums[i] + max < 0 || (i > 0 && nums[i] == nums[i - 1])) {
                    continue;
                }
                sum(nums, i + 1, -nums[i], list);
            }
            return list;
        }

        void sum(int[] nums, int minIndex, int sum, List<List<Integer>> list) {
            int left = minIndex;
            int right = nums.length - 1;
            while (left < right) {
                if ((nums[left] + nums[right]) == sum ) {
                    list.add(Arrays.asList(-sum, nums[left], nums[right]));
                }
                if ((nums[left] + nums[right])> sum ) {
                    while (nums[right] == nums[--right] && left < right) {

                    }
                } else {
                    while (nums[left] == nums[++left] && left < right) {

                    }
                }
            }
        }
    }
}
