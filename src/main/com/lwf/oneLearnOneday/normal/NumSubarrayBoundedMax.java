package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/11/24 9:03
 */
public class NumSubarrayBoundedMax {

    /**
     * 双指针+ 最近可用max的常数指针记录
     */
    class Solution {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {

            int l=0;
            int r=0;
            int count=0;
            int nearIndex=-1;
            while (r<nums.length){

                if (nums[r]<=right){
                    if (nums[r]>=left){ //全量
                        count+=r-l+1;
                        nearIndex=r;
                    }else{ //到nearIndex
                        count+=nearIndex>=l? nearIndex-l+1:0;
                    }
                }else{
                    l=r+1;
                }
                r++;
            }
            return count;
        }
    }
    static
    class Solution1 {
        public int numSubarrayBoundedMax(int[] nums, int left, int right) {

            int[] counts=new int[nums.length];
            int l=0;
            int r=0;
            int count=0;
            while (r<nums.length){
                if (nums[r]>right){
                    //计算右侧
                    while (l<r){
                        if (counts[l]>0){
                            counts[l]+=r-l-1;
                            count--;
                        }else{
                            if (count>0){
                                counts[l]+=r-l-1-count;
                            }
                        }
                        l++;
                    }
                    count=0;
                    l++;
                }else{ //计算左侧
                    if (nums[r]>=left){
                        counts[r]+=r-l+1-count;
                        count++;
                    }
                }
                r++;
            }
            while (l<nums.length){
                if (counts[l]>0){
                    counts[l]+=r-l-1;
                    count--;
                }else{
                    if (count>0){
                        counts[l]+=r-l-1-count;
                    }
                }
                l++;
            }
            return Arrays.stream(counts).sum();
        }
    }
}
