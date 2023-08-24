package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/7/10 9:00
 */
public class ThreeSumClosest {
    /**
     * 把三个数的问题降为2个数的问题，然后利用双指针进行查找最接近的数
     * 如何找最接近的数？通过|gap|比较，双指针遍历两个数的和进行逼近，比较逼近过程中的最接近即可
     */
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int ans=Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                int t=nums[i]+find(nums,i+1,nums.length-1,target-nums[i]);
                ans=Math.abs(ans-target)>Math.abs(t-target)?t:ans;
            }
            return ans;
        }
        //双指针，最接近一个数的数。
        public int find(int[] nums,int i,int j,int t){

            int max=nums[j-1]+nums[j],min=nums[i]+nums[i+1];
            if (t>=max){
                return Math.min(t,max);
            }
            if (t<=min)return Math.max(t,min);

            int gap=nums[i]+nums[j]-t;
            while (i<j){
                int g= nums[i] + nums[j]-t;
                gap= Math.abs(gap)>Math.abs(g)?g:gap;
                if (g<0){
                    i++;
                }else{
                    j--;
                }
            }
            return gap+t;
        }
    }
}
