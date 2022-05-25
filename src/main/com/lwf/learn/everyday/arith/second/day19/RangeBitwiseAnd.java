package com.lwf.learn.everyday.arith.second.day19;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-01 10:46
 */
public class RangeBitwiseAnd {
    /**
     * 位运算的  按位与的应用，n&(n-1)可以消除最末尾的1，而所有left 》right的按位与计算就是找所有数字的二进制中的
     * 哪些位置有相同的0和1，已知只要left》right中有个在二进制位置上为0，就会导致结果这里是0，因此只有所有位置都是1，才
     * 能在最终为1
     */
    class Solution {
        public int rangeBitwiseAnd(int left, int right) {
            while (left<right){
                right=right&(right-1);
            }
            return right;
        }
    }
}
