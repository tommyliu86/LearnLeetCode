package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/9/26 8:34
 */
public class PassThePillow {
    /**
     * 找到除数、被除数，直接计算即可
     */
    class Solution {
        public int passThePillow(int n, int time) {
            int x = time / (n-1);
            int y = time % (n-1);
            return (x &1)==1?(n-y ):(1+ y);
        }
    }
}
