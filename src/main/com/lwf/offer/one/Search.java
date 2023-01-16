package com.lwf.offer.one;


/**
 * @author liuwenfei
 * @date 2023/1/16 13:53
 */
public class Search {
    class Solution {
        public int search(int[] nums, int target) {
            int left=0;
            int l=0,r=nums.length-1;
            while (l<=r){
                int mid=(l+r)/2;
                if (nums[mid]<target){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
            left=r;
            l=0;
            r=nums.length-1;
            while (l<=r){
                int mid=(l+r)/2;
                if (nums[mid]>target){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            return Math.max(l - left-1, 0);
        }

    }
}
