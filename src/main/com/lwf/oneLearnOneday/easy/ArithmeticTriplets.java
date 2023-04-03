package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/3/31 8:46
 */
public class ArithmeticTriplets {
    class Solution {
        /**
         * 三指针
         * @param nums
         * @param diff
         * @return
         */
        public int arithmeticTriplets(int[] nums, int diff) {
            int ans=0;
            int i=0,j=1,k=2;
            while (i<nums.length-2&&j<nums.length-1&& k<nums.length){
                //这一步很关键，j有可能一个循环都没走，这样的话，就需要用i+1覆盖
                j=Math.max(j,i+1);
                while (j<nums.length-1&& nums[j]<nums[i]+diff){
                    j++;
                }
                if (j>=nums.length-1)break;


                if (nums[j]==nums[i]+diff){
                    //这一步很关键，j有可能一个循环都没走，这样的话，就需要用i+1覆盖
                    k=Math.max( j+1,k);
                    while (k<nums.length&& nums[k]<nums[j]+diff){
                        k++;
                    }
                    if (k>=nums.length) break;

                    if (nums[k]==nums[j]+diff){
                        ans++;
                    }
                }
                i++;
            }
            return ans;
        }
    }
    class Solution1 {
        public int arithmeticTriplets(int[] nums, int diff) {
            int[] marks=new int[201];
            Arrays.fill(marks,-1);
            int max=0;
            for (int i = 0; i < nums.length; i++) {
                marks[nums[i]]=1;
                if (i==nums.length-1) max=nums[i];
            }
            int ans=0;
            for (int i = 0; i < nums.length-2; i++) {
                int num = nums[i];
                if (num+diff+diff<=max&& marks[ num+diff]==1&&marks[num+diff+diff]==1){
                    ans++;
                }
            }
            return ans;
        }
    }
}
