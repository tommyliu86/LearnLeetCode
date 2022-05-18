package com.lwf.oneLearnOneday.easy;

/**
 * author Administrator
 * time 2019-09-12-0:00
 * {@link 136.md}
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int rtn=0;
        for (int i = 0; i < nums.length; i++) {
            rtn^=nums[i];
        }
        return rtn;
    }
}
