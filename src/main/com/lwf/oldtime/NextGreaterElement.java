package com.lwf.oldtime;

import java.util.HashMap;
import java.util.Stack;

/**
 * author Administrator
 * time 2019-08-19-22:26
 * {@link 496.md}
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] rtn = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int count = 0;
        for (int i = nums2.length - 1; i >= 0 && count < nums1.length; i--) {
            if (map.containsKey(nums2[i])) {

                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) rtn[map.get(nums2[i])] = -1;
                else {

                    rtn[map.get(nums2[i])] = stack.peek();
                }
                count++;
            }
            stack.add(nums2[i]);
        }
        return rtn;
    }


}
