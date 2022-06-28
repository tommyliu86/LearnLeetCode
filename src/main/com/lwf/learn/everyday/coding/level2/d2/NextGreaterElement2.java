package com.lwf.learn.everyday.coding.level2.d2;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-22 15:16
 */
public class NextGreaterElement2 {
    class Solution {
        public int nextGreaterElement(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int left=chars.length-2;

            //找到第一个减小的下标
            while (left>=0&&chars[left]>=chars[left+1]){
                left--;

            }
            if (left<0){
                return -1;
            }
            //从left的右边开始向后找最小的大于left的index
            int right=left+1;
            while (right<chars.length&&chars[right]>chars[left]){
                right++;
            }
            right--;
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;

            Arrays.sort(chars,left+1,chars.length);
            int rtn=0;
            for (int i = 0; i < chars.length; i++) {
                int cur = chars[i] - '0';
                if (Integer.MAX_VALUE/10<rtn||( Integer.MAX_VALUE/10==rtn&& Integer.MAX_VALUE%10<cur)){
                    return -1;
                }
                rtn=rtn*10+cur;
            }
            return rtn;
        }
    }
}
