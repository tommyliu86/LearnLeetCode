package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-10 11:39
 */
public class ToLowerCase {
    class Solution {
        public String toLowerCase(String s) {
            char[] chars = s.toCharArray();
            char[] newc=new char[chars.length];
            for (int i = 0; i < newc.length; i++) {
                newc[i]=chars[i]<='Z'&&chars[i]>='A'?(char)(chars[i]+32):chars[i];
            }
            return String.valueOf(newc);
        }
    }
}
