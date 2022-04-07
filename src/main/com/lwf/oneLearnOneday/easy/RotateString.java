package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *https://leetcode-cn.com/problems/rotate-string/submissions/
 * @author: liuwenfei14
 * @date: 2022-04-07 08:54
 */
public class RotateString {
    class Solution {
        /**
         * 使用双指针直接模拟，遍历s中的字符，与goal的0位相等则向同时向后遍历比较
         * @param s
         * @param goal
         * @return
         */
        public boolean rotateString(String s, String goal) {
                if (s.length()!=goal.length()){
                    return false;
                }
                int left=0;
                while (left<s.length()){
                    int sIndex=left;
                    int gIndex=0;
                    while (gIndex<goal.length()&& s.charAt(sIndex)==goal.charAt(gIndex)){
                        gIndex++;
                        sIndex = (++sIndex) % s.length();
                    }
                    if (gIndex==goal.length()){
                        return true;
                    }
                    left++;
                }
                return false;
        }
    }
}
