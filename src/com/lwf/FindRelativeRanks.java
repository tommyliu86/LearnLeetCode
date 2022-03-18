package com.lwf;

import java.util.Arrays;

/**
 * author Administrator
 * time 2019-08-21-0:00
 * {@link 506.md}
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] newnums=nums.clone();
        Arrays.sort(newnums );
        int[] ints=new int[newnums[newnums.length-1]];
        for (int i = newnums.length-1; i >=0; i--) {
            ints[newnums[i]]=newnums.length-i;
        }

      String[] rtns=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            switch (ints[nums[i]]) {
                case 1:
                    rtns[i] = "Gold Medal";
                    break;
                case 2:
                    rtns[i] = "Silver Medal";
                    break;
                case 3:
                    rtns[i] = "Bronze Medal";
                    break;
                default:
                    rtns[i] = String.valueOf(ints[nums[i]]);
                    break;
            }

        }
        return rtns;
    }
}
