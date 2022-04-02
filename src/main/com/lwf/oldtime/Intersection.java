package com.lwf.oldtime;

import java.util.*;

/**
 * author Administrator
 * time 2019-08-02
 */
public class Intersection {
    /**
     * 1.数组作为rtn 8ms
     * 2.set作为rtn，然后转为int 6ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
       int[] list = new int[set.size()];
        int len=0;
        for (int i : nums2) {
            if (set.contains(i)) {
                set.remove(i);
              list[len++]=i;
            }
        }
        return Arrays.copyOf(list,len);
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        HashSet<Integer> rset = new HashSet<>();

        for (int i : nums2) {
            if (set.contains(i)) {

                set.add(i);
            }
        }
        int[] rtn = new int[rset.size()];
        int len = 0;
        for (Integer integer : rset) {
            rtn[len++] = integer;
        }
        return rtn;
    }
}
