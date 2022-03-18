package com.lwf.TOP100.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * author Administrator
 * time 2019-09-17-23:58
 * {@link 581.md}
 */
public class FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                min = Math.min(min, stack.pop());
            }
            stack.add(i);
        }
        stack.clear();
        int max = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()){
                stack.add(i);
            }
            else {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) { //找到未排序的最大数应该在的位置index，因此使用while循环一直出栈找到
                    max = Math.max(max, stack.pop());
                }
            }
            stack.add(i);
        }
        return max-min<=0?0:(max-min+1);
    }

    public int findUnsortedSubarray1(int[] nums) {
       int[] ints= nums.clone();
       Arrays.sort(ints);
       int min=0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i]!=nums[i]){
                min=i;
                break;
            }
        }
        int max=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if (ints[i]!=nums[i]) {
                max=i;
                break;
            }
        }
        return max-min<=0?0:(max-min+1);
    }

}
