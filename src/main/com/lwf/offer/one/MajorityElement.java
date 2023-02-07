package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/7 14:16
 */
public class MajorityElement {
    class Solution {
        public int majorityElement(int[] nums) {
            int ans=0;
            int count=0;
            for (int i = 0; i < nums.length; i++) {
               if (count==0){
                   ans=nums[i];
                   count++;
               }else{
                    if (nums[i]==ans){
                       count++;
                   }else{
                       count--;
                   }
               }

            }
            return ans;
        }
    }
}
