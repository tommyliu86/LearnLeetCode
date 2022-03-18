package com.lwf;

/**
 * author Administrator
 * time 2019-08-22-22:26
 * {@link 541.md}
 */
public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2*k) {
            reverse(chars, i, Math.min(i + 2*k - 1, chars.length - 1), k);
        }
        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int start, int end, int k) {

        end = Math.min(start + k - 1, end);
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
