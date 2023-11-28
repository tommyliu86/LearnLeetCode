package com.lwf.oneLearnOneday.normal;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 907. 子数组的最小值之和
 * 灵神关于单调栈的题解，学习
 *https://leetcode.cn/problems/sum-of-subarray-minimums/solutions/1930857/gong-xian-fa-dan-diao-zhan-san-chong-shi-gxa5/?envType=daily-question&envId=2023-11-27
 * @author liuwenfei
 * @date 2022/10/28 8:45
 */
public class SumSubarrayMins {
    /**
     * 单调栈 通过单调递增栈找到 最小值，这样就知道了每一个位置i的前一个的最小值 pre和 自己作为最小值的范围pre~cur。
     * 从正向思路上是通过单调递增栈找到cur的前面的范围，同时，每一位出栈时可以记录到右边的范围
     * 找到单调增加的最小值的index
     */
    class Solution {
        public int sumSubarrayMins(int[] arr) {
            int mod=1000_000_007;
            Stack<Integer> stack=new Stack<>();
            long[] sums=new long[arr.length];
            long ans =0;
            for (int i = 0; i < arr.length; i++) {
                while (!stack.isEmpty()&&arr[stack.peek()]>=arr[i]){
                    stack.pop();
                }
                if (stack.isEmpty()){
                    sums[i]=(i+1)*arr[i];
                }else{
                    sums[i]=sums[stack.peek()]+(i-stack.peek())*arr[i];
                }
                stack.push(i);
                sums[i]%=mod;
                ans=(ans+sums[i])%mod;
            }
            return (int) ans;
        }
    }

    /**
     * 123 2 4 3 2 1
     * 找到单调增加的最小值的index
     */
    class Solution1 {
        public int sumSubarrayMins(int[] arr) {
            int mod = 1000000007;
            Stack<Integer> indexes = new Stack<>();
            long[] sums = new long[arr.length];
            long ans = 0;
            for (int i = 0; i < arr.length; i++) {
                int cur = arr[i];
                while (!indexes.isEmpty() && arr[indexes.peek()] >= cur) {
                    indexes.pop();
                }
                if (!indexes.isEmpty()) {
                    //当前cur可以作为前一个最小值的尾巴+当前cur的自身作为当前最小的尾巴的可能性
                    sums[i] = sums[indexes.peek()] + (i - indexes.peek()) * cur;
                } else {
                    //当前是最小值，计算左边
                    sums[i] = (i + 1) * cur;
                }
                sums[i] %= mod;
                indexes.push(i);
                ans += sums[i];
                ans %= mod;
            }
            return (int) ans;
        }
    }
}
