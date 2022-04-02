package com.lwf.TOP100.normal;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-10-22-22:54
 * {@link md/normal/75.md}
 */
public class SortColors {
    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    /**
     * 选择排序算法
     * @param nums
     */
    public void sortColors(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {
                temp = nums[i];

                int j = i - 1;
                while (j >= 0 && temp < nums[j]) {
                    nums[j + 1] = nums[j];
                    j--;
                }

                nums[j < 0 ? 0 : j + 1] = temp;
            }
        }

    }

    /**
     * 滑动窗口解法
     * @param nums
     */
    public void sortColors1(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;
        while (current <= right) {
            switch (nums[current]) {
                case 0:{
                    if (left==current){
                        left++;
                        current++;
                    }else{

                        int temp=nums[current ];
                        nums[current++]=nums[left];
                        nums[left++]=temp;
                    }
                }
                break;
                case 1:{
                    current++;

                }break;
                case 2:{
                    int temp=nums[current];
                    nums[current]=nums[right];
                    nums[right--]=temp;

                }break;
            }
        }

    }
}

