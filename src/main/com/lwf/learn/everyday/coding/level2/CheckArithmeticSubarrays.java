package com.lwf.learn.everyday.coding.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 14:06
 */
public class CheckArithmeticSubarrays {
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> rtn=new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                int le=l[i];
                int ri=r[i];
                rtn.add(isOk(nums,le,ri));
            }
            return rtn;
        }
        public boolean isOk(int[] nums,int l,int r){
            int[] mid=new int[r-l+1];
            for (int i = l; i <= r; i++) {
                mid[i-l]=nums[i];
            }
            Arrays.sort(mid);
            int sub=mid[1]-mid[0];
            for (int i = 1; i < mid.length; i++) {
                if (mid[i]-mid[i-1]!=sub) {
                    return false;
                }
            }
            return true;
        }
    }
}
