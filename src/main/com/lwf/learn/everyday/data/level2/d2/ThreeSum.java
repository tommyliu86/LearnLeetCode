package com.lwf.learn.everyday.data.level2.d2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-20 16:54
 */
public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rtn=new ArrayList<>();
            if (nums.length==0|| nums[0]>0||nums.length<3){
                return rtn;
            }
            for (int i = 0; i < nums.length; i++) {
                if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int target =-1* nums[i];
                List<List<Integer>> lists = findTwo(nums, i + 1, nums.length - 1, target);
                if (!lists.isEmpty()){
                    rtn.addAll(lists);
                }
            }
            return rtn;
        }
        public List<List<Integer>> findTwo(int[] nums,int l,int r,int target){
            List<List<Integer>> list=new ArrayList<>();
            while (l<r){
                if (nums[l]+nums[r]>target){
                    r--;
                }else if (nums[l]+nums[r]==target){
                    List<Integer> sub=new ArrayList<>();
                    sub.add(nums[l]);
                    sub.add(nums[r]);
                    sub.add(-1*target);
                    list.add(sub);

                    while (++l<r&&nums[l]==nums[l-1]){ //0，1，1，2 取相同元素的第一个，会使用第一个1

                    }
                    while (l<--r&&nums[r]==nums[r+1]){ // 0，1，1，2取相同元素的最后一个,会使用最后一个1，

                    }
                }else{
                    l++;
                }
            }
            return list;
        }
    }
}
