package com.lwf.oldtime;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * author Administrator
 * time 2019-08-02
 */
public class ReverseVowels {
  static   Set<Character> set=new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        char[] chars=s.toCharArray();
        int left=0;
        int right=chars.length-1;
        while (left<right){
            if (!set.contains(chars[left])){
                left++;
                continue;
            }
            if(!set.contains(chars[right])){
                right--;
                continue;
            }
            Character temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
        return String.valueOf(chars);
    }
}
