package com.lwf.TOP100;

import java.util.ArrayList;
import java.util.List;

/**
 * author Administrator
 * time 2019-09-17-22:15
 * {@link 448.md}
 */
public class FindDisappearedNumbers {
    public static void main(String[] args) {
        System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{
                4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int k = nums[i] - 1;

                while (nums[k] != 0) {

                    int index = nums[k] - 1;
                    nums[k] = 0;
                    if (nums[index] == 0) {
                        continue;
                    } else {
                        k = nums[index] - 1;
                        nums[index] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) list.add(i + 1);
        }
        return list;
    }
}
