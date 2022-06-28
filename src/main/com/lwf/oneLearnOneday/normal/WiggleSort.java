package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 10:28
 */
public class WiggleSort {
    /**
     * 错误解法
     */
    class Solution {
        public void wiggleSort(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int l=1;
            int r=n-1- ((n&1)==1?0:1);
            while (l<r){
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                l+=2;
                r-=2;
            }

        }

    }
    class Solution1 {
        public void wiggleSort(int[] nums) {
            int[] arr = nums.clone();
            Arrays.sort(arr);
            int n = nums.length;
            int x = (n + 1) / 2;
            //从中间和最后，开始取值，依次放入位置。这样避免相邻的元素之间的距离过近，导致相等的情况。
            for (int i = 0, j = x - 1, k = n - 1; i < n; i += 2, j--, k--) {
                nums[i] = arr[j];
                if (i + 1 < n) {
                    nums[i + 1] = arr[k];
                }
            }
        }
    }

}
