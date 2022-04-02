package com.lwf.oldtime;

import java.util.*;

/**
 * author Administrator
 * time 2019-08-02
 */
public class Intersection2 {
    /**
     * 1.数组作为rtn 8ms
     * 2.set作为rtn，然后转为int 6ms
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        Map<Integer,Integer> map = new LinkedHashMap<>();
        for (int i : nums1) {
            if (map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else   {
                map.put(i,1);
            }
        }
       int[] list=new int[nums1.length];
      int len=0;
        for (int i : nums2) {
            if(map.isEmpty()) break;
            if (map.containsKey(i)) {

              list[len++]=i;
              if (map.get(i)==1){
                  map.remove(i);
              }else {
                  map.put(i,map.get(i)-1);
              }
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
