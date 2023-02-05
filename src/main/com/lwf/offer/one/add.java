package com.lwf.offer.one;

public class add {
    /**
     * 位运算代替加，
     */
    class Solution {
        public int add(int a, int b) {
            int adds=a&b;

            a=a^b;
            while (adds!=0){
                adds<<=1;
                int next=a^adds;
                adds=a&adds;
                a=next;
            }
            return a;
        }
    }
}
