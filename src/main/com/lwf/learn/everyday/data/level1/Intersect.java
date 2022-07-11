package com.lwf.learn.everyday.data.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersect {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i1=0;
            int i2=0;
            List<Integer> list = new ArrayList<>();
            while (i1<nums1.length&&i2<nums2.length){
                if (nums1[i1]==nums2[i2]) {
                    list.add(nums1[i1]);
                    i1++;
                    i2++;
                }else if (nums1[i1]<nums2[i2]){
                    i1++;
                }else{
                    i2++;
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
