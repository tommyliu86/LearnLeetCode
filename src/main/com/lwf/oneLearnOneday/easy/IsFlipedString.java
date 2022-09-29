package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2022/9/29 10:16
 */
public class IsFlipedString {
    /**
     * 类似的这种题目的通用解法，直接使用字符串拼接处2n长度的字符串，来进行比较查找
     */
    class Solution {
        public boolean isFlipedString(String s1, String s2) {
            if (s1.length()!=s2.length()){
                return  false;
            }
            s2+=s2;
            return s2.contains(s1);
        }
    }
    /**
     * 使用模拟法，遍历比较
     */
    class Solution1 {
        public boolean isFlipedString(String s1, String s2) {
           if (s1.length()!=s2.length()){
               return false;
           }
           if (s1.equals(s2)){
               return true;
           }
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int i=1;
            int n = s1.length();
            while (i<chars1.length){
                if (Arrays.equals(chars1,0,i,chars2,n-i,n)&&Arrays.equals(chars1,i,n,chars2,0,n-i)){
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
