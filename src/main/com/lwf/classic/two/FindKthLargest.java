package com.lwf.classic.two;

import java.util.Arrays;

/**
 * LCR 076. 数组中的第 K 个最大元素
 *
 * @author liuwenfei
 * @date 2023/12/13 8:42
 */
public class FindKthLargest {
    /**
     * 快速排序，任意选中一个元素i，给定范围a~b，然后进行，然后进行左边<k,右边>=k的操作，递归执行，最后就实现了排序操作
     *
     */
    class Solution {
        /**
         * 基于快速排序，可以只排序包含了k这个位置的那部分，排序完成后直接返回nums[n-k]即可

         */
        public int findKthLargest(int[] nums, int k) {
            fastS(nums,0,nums.length-1,nums.length-k);
            return nums[nums.length-k];
        }
        public void fastS(int[] nums,int l,int r,int t){
            if (l>=r){
                return;
            }
            int x=nums[l],i=l;
            for (int j = l+1; j <= r; j++) {
                if (nums[j]<=x){
                    int temp=nums[++i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
            //最后做基准位置定位，i处的值肯定是不会再变的，后续的递归也要保证。不然会导致无限递归
            nums[l]=nums[i];
            nums[i]=x;
            if (t<i){
                fastS(nums,l,i-1,t);
            }else{
                fastS(nums,i+1,r,t);
            }
        }
        //快速排序
        public void fastSort(int[] nums,int l,int r){
            if (l>=r){
                return;
            }
            //i指向的是所有小于等于x的数，因此交换的位置应该是i+1，如果交换i，则把小于等于x的数给放到后面去了！这里一定要想清楚
            int x=nums[l],i=l;
            for (int j = l+1; j <= r; j++) {
                if (nums[j]<=x){
                    int temp=nums[j];
                    nums[j]=nums[++i];
                    nums[i]=temp;
                }
            }
            //一次遍历之后，i左侧都是小于x的。
            fastSort(nums,l,i-1);
            fastSort(nums,i,r);
        }
    }

    /**
     * 排序后直接取
     */
    class Solution1 {
        public int findKthLargest(int[] nums, int k) {
            Arrays.sort(nums);
            return nums[nums.length - k];
        }
    }
}
