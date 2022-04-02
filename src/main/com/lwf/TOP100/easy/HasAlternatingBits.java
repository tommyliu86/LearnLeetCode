package com.lwf.TOP100.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-03-28 09:22
 */
public class HasAlternatingBits {
    public static void main(String[] args) {
        new Solution().hasAlternatingBits(1431655765);
    }

    /**
     * 位运算。找规律。当所有相邻位不相等时，错位异或会获得到所有位都是1的数。也就是Math.pow(2,n)-1
     */
     static class Solution {
        public boolean hasAlternatingBits(int n) {

            int s=n;
            int count=0;
            while(s>0){
                s=s>>1;
                count++;
            }
            //转为long，防止溢出 或者使用右边-1，
            return (n^(n>>1))==Math.pow(2,count)-1;
        }
    }
}
