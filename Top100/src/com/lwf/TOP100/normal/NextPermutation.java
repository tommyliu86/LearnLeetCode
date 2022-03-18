package com.lwf.TOP100.normal;

/**
 * author Administrator
 * time 2019-09-26-23:37
 * {@link 31.md}
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        boolean isMax = true;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {

                int min = i;
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        min = nums[j] > nums[min] ? min : j;
                    }
                }
                int temp = nums[i - 1];
                nums[i - 1] = nums[min];
                nums[min] = temp;

                int post = i;
                while (post < nums.length) {
                    int p = post - 1;
                    int cur = nums[post++];
                    while (cur < nums[p] && p > i - 1) {
                        nums[p + 1] = nums[p--];
                    }
                    nums[p + 1] = cur;
                }
                isMax = false;
                break;
            }
        }
        if (isMax) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

    }
}
