package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-26 15:27
 */
public class SortColors {
    class Solution {
        public void sortColors(int[] nums) {
            int left=0;
            int right=nums.length-1;
            int i=0;
            while (i<right){
                if (left!=i&& nums[i]==0){
                    int temp=nums[left];
                    nums[left]=nums[i];
                    nums[i]=temp;
                    left++;
                }else if (nums[i]==2){
                    int temp=nums[right];
                    nums[right]=nums[i];
                    nums[i]=temp;
                    right--;
                }else{
                    i++;
                }
            }
        }
    }
}
