package com.lwf.TOP100.easy;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-09-13-0:25
 * {@link 169.md}
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public int m2(int[] nums){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i])>(nums.length/2))return nums[i];
        }
        return 0;
    }
    public int m3(int[] nums){
        int count=0;
        int num=0;
        for (int i = 0; i < nums.length; i++) {
           if (count==0){
               num=nums[i];
               count++;
           }else{
               if (num == nums[i]) {
                   count++;
               } else {
                   count--;
               }
           }
        }
        return num;
    }
}
