package com.lwf.learn.everyday.coding.level2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 16:07
 */
public class NextGreaterElement {
    class Solution {
        public int nextGreaterElement(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int r=chars.length-2;
            while (r>=0&&chars[r]>=chars[r+1]){
                r--;
            }
            if (r<0){
                return -1;
            }
            int e=r+1;
            while (e<chars.length&&chars[e]>chars[r]){
                e++;
            }
            e--;
            char temp=chars[r];
            chars[r]=chars[e];
            chars[e]=temp;
            Arrays.sort(chars,r+1,chars.length);
            try {

                int i = Integer.parseInt(String.valueOf(chars));
                return i;
            }catch (Exception ex){
                return -1;
            }

        }
    }
}
