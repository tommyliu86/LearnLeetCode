package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2023/9/5 8:37
 */
public class MinNumber {
    /**
     * 位运算，
     */
    class Solution {
        public int minNumber(int[] nums1, int[] nums2) {
            int i1=0,i2=0,m1=10,m2=10;
            for (int i = 0; i < nums1.length; i++) {
                i1|=1<<nums1[i];
                m1=Math.min(m1,nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                i2|=1<<nums2[i];
                m2=Math.min(m2,nums2[i]);
            }
            int ans=0;
            if ((i1&i2)!=0){
                int i=i1&i2;
                for (int i3 = 1; i3 < 10; i3++) {
                    if ((i&(1<<i3))!=0) {
                        ans= i3;
                        break;
                    }
                }
            }else{
                ans= m1>m2?(m2*10+m1):(m1*10+m2);
            }
            return ans;
        }
    }
    /**
     * 排序+哈希
     */
    class Solution1 {
        public int minNumber(int[] nums1, int[] nums2) {
            int i1=10,i2=10;
            Set<Integer> set1=new HashSet<>();
            for (int i = 0; i < nums1.length; i++) {
                i1=Math.min(nums1[i],i1);
                set1.add(nums1[i]);
            }
            Arrays.sort(nums2);
            for (int i = 0; i < nums2.length; i++) {
                if (set1.contains( nums2[i])){
                    return nums2[i];
                }
                i2=Math.min(i2,nums2[i]);
            }
            return i1>i2?(i2*10+i1):(i1*10+i2);
        }
    }
}
