package com.lwf.arithmetic.level1.sortsearch;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-16 19:04
 */
public class Merge {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i1=m-1;
            int i2=n-1;
            for (int i = nums1.length - 1; i >= 0&&i1>=0&&i2>=0; i--) {
                if (nums1[i1]<nums2[i2]){
                    nums1[i]=nums2[i2];
                    i2--;
                }else{
                    nums1[i]=nums1[i1];
                    i1--;
                }
            }
            if (i2>=0){
                for (int i = i2; i >= 0; i--) {
                    nums1[i]=nums2[i];
                }
            }
        }
    }
}
