package com.lwf.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-09 16:44
 */
public class Intersect {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            List<Integer> rtn=new LinkedList<>();
            if (nums1[0]>nums2[nums2.length-1]||nums2[0]>nums1[nums1.length-1]){
                return new int[0];
            }
            int cursor1=0;
            int cursor2=0;
            while (cursor1<nums1.length&&cursor2<nums2.length){
                if (nums1[cursor1]>nums2[cursor2]){
                    cursor2++;
                }else if (nums1[cursor1]==nums2[cursor2]){
                    rtn.add(nums1[cursor1]);
                    cursor1++;
                    cursor2++;
                }else{
                    cursor1++;
                }
            }
            int[] array=new int[rtn.size()];
            for (int i = 0; i < rtn.size(); i++) {
                array[i]=rtn.get(i);
            }
            return array;
        }
    }
}
