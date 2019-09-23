package com.lwf.TOP100.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author Administrator
 * time 2019-09-23-22:53
 */
public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{1,2,-2,-1}));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        if (nums==null||nums.length<3) return list;
        Arrays.sort(nums);
        int max=nums[nums.length-1]+nums[nums.length-2];
        int min= Integer.MAX_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]>0) break;
             min=nums[i+1]+nums[i+2];
                 if (nums[i]+min>0||nums[i]+max<0||(i>0&&nums[i]==nums[i-1]))continue;
             sum2(nums,i+1,nums[i],list);
        }
        return list;
    }
    void sum2(int[] nums,int minIndex ,int sum,List<List<Integer>> list){
        int left=minIndex;
        int right=nums.length-1;
        while (left<right){
            if ((nums[left]+nums[right])+sum==0){
                list.add(Arrays.asList(sum,nums[left],nums[right]));
            }
            if((nums[left]+nums[right])+sum>0){
                while (nums[right]==nums[--right]&&left<right){

                }
            }else{
                while(nums[left]==nums[++left]&&left<right){

                }
            }
        }
    }
}
