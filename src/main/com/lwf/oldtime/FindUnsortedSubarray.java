package com.lwf.oldtime;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-29-23:51
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorts= nums.clone();
        Arrays.sort(sorts);
        int min=-1;
        for (int i = 0; i < sorts.length; i++) {
            if (sorts[i]!=nums[i]){
                min=i;
                break;
            }
        }
        int max=-1;
        for (int i = sorts.length-1; i >=0 ; i--) {
            if (sorts[i]!=nums[i]){
                max=i;
                break;
            }
        }
        return max-min==0?0:(max-min+1);
    }
}
