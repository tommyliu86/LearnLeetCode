package com.lwf.learn.everyday.arith.first.day6;

/**
 * Created with IntelliJ IDEA.
 * https://leetcode-cn.com/problems/permutation-in-string/submissions/
 * 567. 字符串的排列
 *
 * @author: liuwenfei14
 * @date: 2022-04-05 11:31
 */
public class CheckInclusion {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            int[] chars = new int[128];
            for (int i = 0; i < s1.length(); i++) {
                chars[s1.charAt(i) - 0]++;
            }

            char[] charArray = s2.toCharArray();
            int left = 0;
            int right = 0;
            while (right < s2.length()) {
                chars[charArray[right] - 0]--;
                /**
                 * 这里不能使用双指针普通做法直接left移动到right，由于可能出现重复字母，因此left指针通过遍历右移，来把字母统计值再加上去。
                 * 保证在left~right之间的数据准确性
                 */
                while (chars[charArray[right] - 0] < 0) {
                    chars[charArray[left] - 0]++;
                    left++;
                }
                if (right - left + 1 == s1.length()) {
                    return true;
                }
                right++;
            }
            return false;
        }
    }
}
