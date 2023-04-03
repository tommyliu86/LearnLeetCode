package com.lwf.oneLearnOneday.normal;

import java.util.Stack;

/**
 * @author liuwenfei
 * @date 2023/4/3 8:57
 */
public class PrevPermOpt1 {
    class Solution {
        /**
         * 优化空间，由于数组末尾肯定是单调的，因此我们可以不需要使用单调栈，直接从数组末尾比较相邻大小的数就可以找到要交换的位置i
         *
         * @param arr
         * @return
         */
        public int[] prevPermOpt1(int[] arr) {
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i-1]>arr[i]){
                    int j=i-1;
                    for (int k = arr.length - 1; k > i-1; k--) {
                        //找到小于j的最大的元素，且不重复的最前面一个
                        if (arr[k]<arr[j]&&arr[k-1]!=arr[k]){
                            int tem=arr[j];
                            arr[j]=arr[k];
                            arr[k]=tem;
                            return arr;
                        }
                    }
                }
            }
            return arr;
        }
    }
    class Solution1 {
        /**
         * 使用单调栈保存数组末尾的非减小的数列，找到第一个i>i+1的位置，就是要交换的位置。
         * @param arr
         * @return
         */
        public int[] prevPermOpt1(int[] arr) {
            Stack<Integer> stack = new Stack<>();
            for (int i = arr.length - 1; i >= 0; i--) {
                //此时找到了要交换的i
                if (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    int pop=stack.pop();
                    while (!stack.isEmpty()&& arr[stack.peek()]<arr[i]){
                       int pop2=stack.pop();
                       //如果相邻的数是大小相同的，则指针指向最前面的，因为这样交换的是变小的最大值
                       if (arr[pop]!=arr[pop2]){
                           pop=pop2;
                       }
                    }
                    int temp = arr[i];
                    arr[i] = arr[pop];
                    arr[pop] = temp;
                    return arr;
                } else {
                    stack.push(i);
                }
            }

            return arr;
        }
    }
}
