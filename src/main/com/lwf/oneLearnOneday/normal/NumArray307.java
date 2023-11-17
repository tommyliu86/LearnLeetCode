package com.lwf.oneLearnOneday.normal;

/**
 * 307. 区域和检索 - 数组可修改
 * https://leetcode.cn/problems/range-sum-query-mutable/?envType=daily-question&envId=2023-11-01
 *
 * @author liuwenfei
 * @date 2023/11/13 9:18
 */
public class NumArray307 {
    /**
     * 线段树 树状数组
     *
     * TIPS：
     * 这是一道很经典的题目，通常还能拓展出一大类问题。
     *
     * 针对不同的题目，我们有不同的方案可以选择（假设我们有一个数组）：
     *
     * 数组不变，求区间和：「前缀和」、「树状数组」、「线段树」
     * 多次修改某个数（单点），求区间和：「树状数组」、「线段树」
     * 多次修改某个区间，输出最终结果：「差分」
     * 多次修改某个区间，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
     * 多次将某个区间变成同一个数，求区间和：「线段树」、「树状数组」（看修改区间范围大小）
     * 这样看来，「线段树」能解决的问题是最多的，那我们是不是无论什么情况都写「线段树」呢？
     *
     * 答案并不是，而且恰好相反，只有在我们遇到第 4 类问题，不得不写「线段树」的时候，我们才考虑线段树。
     *
     * 因为「线段树」代码很长，而且常数很大，实际表现不算很好。我们只有在不得不用的时候才考虑「线段树」。
     *
     * 总结一下，我们应该按这样的优先级进行考虑：
     *
     * 简单求区间和，用「前缀和」
     * 多次将某个区间变成同一个数，用「线段树」
     * 其他情况，用「树状数组」
     *
     */
    class NumArray {

        public NumArray(int[] nums) {

        }

        public void update(int index, int val) {

        }

        public int sumRange(int left, int right) {
            return 0;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
}
