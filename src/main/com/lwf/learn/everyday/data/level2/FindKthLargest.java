package com.lwf.learn.everyday.data.level2;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 16:45
 */
public class FindKthLargest {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return fastSort(nums,0,nums.length-1,k-1);
        }
        Random random=new Random();
        public int fastSort(int[] nums,int l,int r,int k){
            //首先获取随机中间值。
            int m = random.nextInt(r - l + 1) + l;

            int mid = nums[m];
            nums[m]=nums[l];//第一个交换位置，需要先把最左边的设置到m ，这样后续的交换就先从left位置做
            int li=l;
            int ri=r;
            while (li<ri){
                while (nums[ri]<=mid&&ri>li){
                    ri--;
                }
                nums[li]=nums[ri];
                while (nums[li]>=mid&&li<ri){
                    li++;
                }
                nums[ri]=nums[li];
            }
            nums[li]=mid;
            if (li==k){
                return nums[li];
            }
            if (li>k){
                return fastSort(nums,l,li-1,k);
            }else{
                return fastSort(nums,li+1,r,k);
            }
        }

        /**
         * 标准快拍，基于选择排序，一次遍历，
         * 也可以是左右指针，两个while找左右位置。
         * @param nums
         * @param l
         * @param r
         * @return
         */
        public int qSort(int[] nums,int l,int r){
            if (l>=r){
                return l;
            }
            int mid = random.nextInt(r - l + 1) + l;
            int m = nums[mid];
            //如果是正向排序，就m放在right，如果是逆向排序，就m放在left
            swap(nums,m,r);
            int left=l;
            for (int i = l; i < r; i++) {
                if (nums[i]<=m){
                    swap(nums,left++,i);
                }
            }
            swap(nums,left,r); //因为m值放在r处了
            qSort(nums,l,left-1);
            qSort(nums,left+1,r);
            return left;
        }
        public void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}
