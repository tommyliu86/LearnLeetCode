package com.lwf.TOP100.normal;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-10-22-22:54
 * {@link md/normal/75.md}
 */
public class SortColors {
    public static void main(String[] args) {
        new SortColors().sortColors(new int[]{ 2,0,2,1,1,0});
    }
    public void sortColors(int[] nums) {
       int temp;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i]<nums[i-1]){
                temp=nums[i];

                int j=i-1;
                while (j>=0&&temp<nums[j]){
                    nums[j+1]=nums[j];
                    j--;
                }

                nums[j<0?0:j+1]=temp;
            }
        }

    }
}

