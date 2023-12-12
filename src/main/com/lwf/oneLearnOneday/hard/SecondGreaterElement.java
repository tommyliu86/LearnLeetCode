package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2454. 下一个更大元素 IV
 *
 * https://leetcode.cn/problems/next-greater-element-iv/?envType=daily-question&envId=2023-12-12
 * @author liuwenfei
 * @date 2023/12/12 8:41
 */
public class SecondGreaterElement {
    /**
     * 找下一个更大，可以直接使用单调栈，单调递减栈
     * 找辖两个更大，需要满足，单调递减第一次，然后单调递减第二次。使用两个单调递减，只有第二个也满足才行
     */
    class Solution {
        public int[] secondGreaterElement(int[] nums) {
            Stack<Integer> stack1=new Stack<>();
            Stack<Integer> stack2=new Stack<>();
            int[] ans=new int[nums.length];
            Arrays.fill(ans,-1);
            for (int i = 0; i < nums.length; i++) {
                while (!stack2.isEmpty()&&nums[ stack2.peek()]<nums[i]){
                  ans[  stack2.pop()]=nums[i];
                }
                Stack<Integer> temp=new Stack<>();
                while (!stack1.isEmpty()&&nums[ stack1.peek()]<nums[i]){
                    temp.push(stack1.pop());
                }
                while (!temp.isEmpty()){
                    stack2.push(temp.pop());
                }
                stack1.push(i);
            }
            return ans;
        }
    }
}
