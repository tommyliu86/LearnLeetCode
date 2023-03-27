package com.lwf.offer.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/3/1 19:12
 */
public class ThreeSum {
    /**
     * 双指针，注意值相同的边界条件处理即可
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans=new ArrayList<>();
            if (nums.length<3) return ans;
            Arrays.sort(nums);
            int pre=nums[0]-1,i=0;
           while (i<nums.length-2&&nums[i]<=0){
               while (i<nums.length-2&&nums[i]==pre){
                   i++;
               }
               pre=nums[i];
               int j=i+1,k=nums.length-1;
               while (j<k){
                   if (nums[j]+nums[k]==-1*pre){
                       ans.add(new ArrayList<Integer>(Arrays.asList(pre , nums[j],nums[k])));
                       j++;
                       while (j<k&&nums[j]==nums[j-1]){
                           j++;
                       }
                   }else if (nums[j]+nums[k]>-1*pre){
                       k--;
                   }else{
                       j++;
                   }
               }
           }
           return ans;
        }
    }
}
