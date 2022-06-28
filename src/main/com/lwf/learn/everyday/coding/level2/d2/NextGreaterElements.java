package com.lwf.learn.everyday.coding.level2.d2;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 15:06
 */
public class NextGreaterElements {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] rtn=new int[nums.length];
            Arrays.fill(rtn,-1);

            Stack<Integer> stack=new Stack<>();
            for (int i = 0; i <2* nums.length; i++) {
                int j=i%nums.length;
                while (!stack.isEmpty()&& nums[ stack.peek()]<nums[j]){
                    Integer pre = stack.pop();
                    rtn[pre]=nums[j];
                }
                stack.push(j);
            }
            return rtn;
        }
    }
}
