package com.lwf.oneLearnOneday.normal;

/**
 * 2575. 找出字符串的可整除数组
 * @author: liuwenfei
 * @date: 2024/3/7-9:26
 */
public class DivisibilityArray {
    /**
     * 使用除余进行后续迭代计算每一位
     */
    class Solution {
        public int[] divisibilityArray(String word, int m) {
            char[] chars = word.toCharArray();
            int[] ans=new int[chars.length];

            long count=0;
            for (int i = 0; i < chars.length; i++) {
                count=count*10+(chars[i]-'0');
                if (count%m==0) {
                    ans[i]=1;
                }
                count%=m;
            }
            return ans;
        }
    }
}
