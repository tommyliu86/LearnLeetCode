package com.lwf.offer.two;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * @author liuwenfei
 * @date 2023/6/25 9:13
 */
public class ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        String s="1|测试：123";
        String[] split = s.split("\\|");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }
    /**
     * 呃呃,这里不逆向计算，会超时。。。正确做法是用值排序后对比
     * 额，这里不需要逆向，因为不管用哪种，都需要对比计算，因此直接对比计算即可，
     * 滑动窗口
     * 逆向思维，通过对值排序，获取到所有的index排序，然后滑动窗口找index
     */
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            int i=0,j=1;
            while (j<nums.length){
                while (i<j&& i+k>j){
                    i++;
                }
                for (int i1 = i; i1 < j; i1++) {
                    if (Math.abs ((long)nums[i1]-(long)nums[j])<=t){
                        return true;
                    }
                }
                j++;
            }
            return false;
        }
    }
    class Solution1 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
           Integer[] indez=new Integer[nums.length];
            for (int i = 0; i < indez.length; i++) {
                indez[i]=i;
            }
            Arrays.sort(indez, Comparator.comparing(i->nums[i]));
            Arrays.sort(nums);
            int i=0,j=1;
            while (j<nums.length){
                while (i<j&&( (long)nums[j]-(long)nums[i])>t){
                    i++;
                }
                for (int i1 = i; i1 < j; i1++) {
                    if (Math.abs( indez[i1]-indez[j])<=k){
                        return true;
                    }
                }
                j++;
            }
            return false;
        }
    }
}
