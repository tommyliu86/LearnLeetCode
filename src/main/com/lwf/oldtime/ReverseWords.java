package com.lwf.oldtime;

/**
 * author Administrator
 * time 2019-08-22-23:15
 * {@link 557.md}
 */
public class ReverseWords {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int i=0;
        for (; i < chars.length; i++) {
            if (chars[i] == ' ') {
                recurse(chars, start, i - 1);
                start = i + 1;
            }
        }
        if (start!=i){
            recurse(chars, start, i - 1);
        }
        return String.valueOf(chars);
    }
    void recurse(char[] chars,int start,int end){
        while (start<end){
            char temp=chars[start];
            chars[start]=chars[end];
            chars[end]=temp;
            start++;
            end--;
        }
    }
}
