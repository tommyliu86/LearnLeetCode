package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/8/11 8:53
 */
public class ReverseString {
    /**
     * 直接对称交换即可
     */
    class Solution {
        public void reverseString(char[] s) {
            for (int i = 0; i < s.length/2; i++) {
                char temp=s[s.length-1-i];
                s[s.length-1-i]=s[i];
                s[i]=temp;
            }
        }
    }
}
