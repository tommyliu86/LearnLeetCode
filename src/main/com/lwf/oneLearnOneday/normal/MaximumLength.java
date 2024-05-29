package com.lwf.oneLearnOneday.normal;

/**
 * 2981. 找出出现至少三次的最长特殊子字符串 I
 *
 * @author: liuwenfei
 * @date: 2024/5/29-8:52
 */
public class MaximumLength {
    /**
     * 使用一个二维数组记录26个字母分别的长度的出现次数，进行遍历统计
     */
    class Solution {
        public int maximumLength(String s) {
            int max=-1;
            int[][] counts=new int[26][s.length()+1];
            int i=0;
            while (i<s.length()){
                int j=i;
                while (j<s.length()&&s.charAt(i)==s.charAt(j)){
                    j++;
                }
                int l = j - i;
                for (int k = 0; k < l; k++) {
                    counts[s.charAt(i)-'a'][l-k]+=k+1;
                    if (counts[s.charAt(i)-'a'][l-k]>=3){
                        max=Math.max(max,l-k);
                    }
                }
                i=j;
            }
            return max;
        }
    }
}
