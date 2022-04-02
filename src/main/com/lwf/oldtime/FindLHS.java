package com.lwf.oldtime;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-30-0:13
 */
public class FindLHS {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int first=0;
        int next=0;
        int max=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==nums[first]||nums[i]==nums[next]){
                continue;
            }else  if (nums[i]==nums[first]+1&&first==next){
                next=i;
            }else{
                if (first==next){
                    first=next=i;
                }else {
                    max=Math.max(max,i-first);
                    if (nums[i]==nums[next]+1){
                        first=next;
                        next=i;
                    }
                    else{
                        first=next=i;
                    }

                }
            }
        }
        if (first==next){
            return max;
        }else   {
            return Math.max(max,nums.length-first);
        }

    }
}
