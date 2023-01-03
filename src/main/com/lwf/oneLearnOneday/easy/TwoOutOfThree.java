package com.lwf.oneLearnOneday.easy;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/12/29 8:32
 */
public class TwoOutOfThree {
    class Solution {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {

               map.put(nums1[i],1);

            }
            for (int i = 0; i < nums2.length; i++) {

               map.put(nums2[i],map.getOrDefault(nums2[i],0)|1<<1);

            }
            for (int i = 0; i < nums3.length; i++) {

               map.put(nums3[i],map.getOrDefault(nums3[i],0)|1<<2);

            }
            List<Integer> ans=new ArrayList<>();
            map.forEach((k,v)->{
                if (Integer.bitCount(v)>=2){
                    ans.add(k);
                }
            });
            return ans;
        }
    }
    class Solution2 {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[][] counts=new int[101][3];
            for (int i = 0; i < nums1.length; i++) {

                    counts[nums1[i]][0]=1;

            }
            for (int i = 0; i < nums2.length; i++) {

                    counts[nums2[i]][1]=1;

            }
            for (int i = 0; i < nums3.length; i++) {

                    counts[nums3[i]][2]=1;

            }
            List<Integer> ans=new ArrayList<>();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i][0]+counts[i][1]+counts[i][2]>=2){
                    ans.add(i);
                }
            }
            return ans;
        }
    }
    class Solution1 {
        public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
            int[] counts=new int[101];
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            Arrays.sort(nums3);
            for (int i = 0; i < nums1.length; i++) {
                if (i==0||nums1[i]!=nums1[i-1]){
                counts[nums1[i]]++;
                }
            }
            for (int i = 0; i < nums2.length; i++) {
                if (i==0||nums2[i]!=nums2[i-1]) {
                    counts[nums2[i]]++;
                }
            }
            for (int i = 0; i < nums3.length; i++) {
                if (i==0||nums3[i]!=nums3[i-1]) {
                    counts[nums3[i]]++;
                }
            }
            List<Integer> ans=new ArrayList<>();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i]>=2){
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
