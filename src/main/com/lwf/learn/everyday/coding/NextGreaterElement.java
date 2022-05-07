package com.lwf.learn.everyday.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-06 15:35
 */
public class NextGreaterElement {
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            Map<Integer, Integer> index = new HashMap<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = nums2.length - 1; i >= 0; i--) {

                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()){
                    index.put(nums2[i],-1);
                }else{
                    index.put(nums2[i],stack.peek());
                }
                stack.push(nums2[i]);

            }
            for (int i = 0; i < nums1.length; i++) {
                Integer indexj = index.get(nums1[i]);
                nums1[i]=indexj;
            }
            return nums1;
        }
    }
}
