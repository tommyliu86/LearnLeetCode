package com.lwf;

/**
 * author Administrator
 * time 2019-08-11
 * {@link 414.md}
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] ints = new int[3];

        ints[1] = ints[2] = -1;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[ints[0]]) {
                continue;
            } else if (nums[i] > nums[ints[0]]) {

                int temp = ints[0];
                ints[0] = i;
                ints[2] = ints[1];
                ints[1] = temp;
            } else {
                if (ints[1] == -1) {
                    ints[1] = i;
                } else if(nums[i] ==nums[ints[1]]){
                    continue;
                }
                else if (nums[i] > nums[ints[1]]) {
                    int temp = ints[1];
                    ints[1] = i;
                    ints[2] = temp;
                } else {
                    if (ints[2] == -1) {
                        ints[2] = i;
                    }else if(nums[i] ==nums[ints[2]]){
                        continue;
                    }
                    else if (nums[i] > nums[ints[2]]) {
                        ints[2] = i;
                    }
                }
            }
        }
        return ints[2] == -1 ? nums[ints[0]] : nums[ints[2]];
    }

}
