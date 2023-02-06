package com.lwf.offer.one;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/1/31 18:41
 */
public class MinNumber {
    /**
     * 思路：字符串比较来进行
     */
    class Solution {
        public String minNumber(int[] nums) {
            String[] strs=new String[nums.length];
            for (int i = 0; i < strs.length; i++) {
                strs[i]=String.valueOf( nums[i]);
            }
            Arrays.sort(strs,(a,b)-> (a+b).compareTo(b+a));
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                stringBuilder.append(strs[i]);
            }
            return stringBuilder.toString();
        }
    }
}
