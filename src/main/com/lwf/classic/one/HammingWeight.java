package com.lwf.classic.one;

public class HammingWeight {
    /**
     * 使用位运算，1；位与1，然后使用>>>移位，并使用0进行补充，若使用>>符号，则不会补位，
     * 2.使用 n&(n-1），这样会把低位的最后一个1消除，因为 100 &011==000，这样可以进行低位消除
     */
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int i=0;
            while (n!=0){
                i+=n&1;
                n>>>=1;
            }
            return i;
        }
    }
}
