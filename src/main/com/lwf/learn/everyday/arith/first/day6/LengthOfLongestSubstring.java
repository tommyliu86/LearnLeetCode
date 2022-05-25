package com.lwf.learn.everyday.arith.first.day6;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-05 10:48
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("abba");
    }

    /**
     * 优化：
     * 双指针+数组，记录遍历走过的元素并记录其index
     * 利用数组的查询效率 来提高速度
     * 数组的index是char的数字值，char=0~127，注意，其中的值要=index+1，因为数组默认值=0，为了避开默认的0值，
     * 因此记录时使用index+1.
     */
    static class test {
        public int lengthOfLongestSubstring(String s) {

            char[] chars = s.toCharArray();
            if (chars.length < 1) return 0;
            int max = 1;
            int left = 0;
            int right = 0;
            int[] charIndex=new int[128];
            while (right < chars.length) {
                int i = chars[right] - 0;
                if (charIndex[i]!=0&&charIndex[i]>left) {
                    max = Math.max(max, right - left);

                    left=charIndex[i];
                }
                charIndex[i]=right+1;

                right++;
            }
            return Math.max(max, right - left);
        }
    }
    /**
     * 双指针+hash，记录遍历走过的元素并记录其index
     * hash的remove和取值判断时间复杂度无区别
     */
    static class Solution {
        public int lengthOfLongestSubstring(String s) {

            char[] chars = s.toCharArray();
            if (chars.length < 1) return 0;
            int max = 1;
            int left = 0;
            int right = 0;
            Map<Character, Integer> map = new HashMap<>();
            while (right < chars.length) {
                if (map.containsKey(chars[right])&&map.get(chars[right])>=left) {
                    max = Math.max(max, right - left);
                    Integer leftIndex = map.get(chars[right]);
                   left=leftIndex+1;
                }
                map.put(chars[right], right);

                right++;
            }
            return Math.max(max, right - left);
        }
    }
}
