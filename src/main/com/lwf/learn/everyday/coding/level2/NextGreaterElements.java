package com.lwf.learn.everyday.coding.level2;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 14:34
 */
public class NextGreaterElements {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            Stack<Integer> index = new Stack<>();
            int[] rtn = new int[nums.length];
            for (int i = 0; i < rtn.length; i++) {
                rtn[i]=-1;
            }
            index.add(0);

            for (int i = 0; !index.isEmpty() && i < 2 * nums.length; i++) {
                int k = i % nums.length;

                while (!index.isEmpty() && nums[index.peek()] < nums[k]) {
                    Integer pop = index.pop();
                    rtn[pop] = nums[k];
                }

                index.add(k);


            }
            return rtn;
        }
    }
}
