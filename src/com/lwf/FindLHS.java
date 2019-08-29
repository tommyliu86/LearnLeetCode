package com.lwf;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-30-0:13
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int min=0;
        int next=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==nums[min]){
                continue;
            }else  if (nums[i]==nums[min]+1){
                next=i;
            }else{
                if (nums[min]==nums[next]-1){
                    max=Math.max(max,i-min+1);
                    min=next;
                    next=i;
                }
                else{
                    min=i;
                }
            }
        }
        return max;
    }
}
