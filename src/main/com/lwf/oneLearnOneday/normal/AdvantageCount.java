package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author liuwenfei
 * @date 2022/10/9 9:05
 */
public class AdvantageCount {
    /**
     * 单排序，按照顺序进行匹配，这样优势最大，这里需要考虑如何排序，因为直接排序会失去顺序，因此使用index数组来保存
     * 双排序的优化，直接排序nums1，nums2使用index数组
     */
    class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {

            Integer[] index2=new Integer[nums1.length];
            for (int i = 0; i < index2.length; i++) {
                index2[i]=i;
            }
            Arrays.sort(index2, Comparator.comparing(a->nums2[a]));
            Arrays.sort(nums1);
            int[] ans=new int[nums1.length];
            int l=0,r=index2.length-1;
            for (int i = 0; i < nums1.length; i++) {
                if (nums1[i]>nums2[index2[l]]) {
                    ans[index2[l++]]=nums1[i];
                }else{
                    ans[index2[r--]]=nums1[i];
                }
            }
            return ans;
        }
    }
    /**
     * 双排序，按照顺序进行匹配，这样优势最大，这里需要考虑如何排序，因为直接排序会失去顺序，因此使用index数组来保存
     */
    class Solution2 {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            Integer[] index1=new Integer[nums1.length];
            Integer[] index2=new Integer[nums1.length];
            for (int i = 0; i < index1.length; i++) {
                index1[i]=i;
                index2[i]=i;
            }
            Arrays.sort(index1, Comparator.comparing(a->nums1[a]));
            Arrays.sort(index2, Comparator.comparing(a->nums2[a]));
            int[] ans=new int[nums1.length];
            int l=0,r=index2.length-1;
            for (int i = 0; i < index1.length; i++) {
                if (nums1[ index1[i]]>nums2[index2[l]]) {
                    ans[index2[l++]]=nums1[index1[i]];
                }else{
                    ans[index2[r--]]=nums1[index1[i]];
                }
            }
            return ans;
        }
    }

    /**
     * 直接使用红黑树，时间复杂度 过高
     */
    class Solution1 {
        public int[] advantageCount(int[] nums1, int[] nums2) {

            TreeMap<Integer, Integer> map = new TreeMap<>(Integer::compareTo);
            for (int i = 0; i < nums1.length; i++) {
                map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            }
            int[] ans = new int[nums1.length];
            for (int i = 0; i < nums2.length; i++) {
                int t = nums2[i];
                Map.Entry<Integer, Integer> entry = map.higherEntry(t);
                if (entry == null) {
                    entry = map.firstEntry();

                }
                ans[i] = entry.getKey();
                int value = entry.getValue() - 1;
                if (value == 0) {
                    map.remove(entry.getKey());
                } else {
                    map.put(entry.getKey(), value);
                }
            }
            return ans;
        }

        private int half(int[] nums1, int t, int l, int r, int[] marks) {
            if (l >= r) {
                return l;
            }
            int m = (l + r) / 2;
            if (nums1[m] <= t) {
                return half(nums1, t, m + 1, r, marks);
            } else {
                return half(nums1, t, l, m, marks);
            }
        }
    }
}
