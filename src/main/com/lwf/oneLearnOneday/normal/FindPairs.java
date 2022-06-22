package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-16 10:42
 */
public class FindPairs {
    class Solution {
        public int findPairs(int[] nums, int k) {
            Arrays.sort(nums);
            int l=0;
            int r=1;
            int count=0;
            while (r<nums.length){

                while (l<r&&nums[r]-nums[l]>k){
                    l++;
                }
                //判断条件，l跟前节点比，用过的l就不再用，用出现相同的第一个，r跟后节点比，用相同的最后一个
                while (l<r&&nums[r]-nums[l]==k&&(l==0||nums[l]!=nums[l-1])&& (r==nums.length-1|| nums[r]!=nums[r+1])){
                    count++;
                    l++;
                }
                r++;
            }
            return count;
        }
    }
}
