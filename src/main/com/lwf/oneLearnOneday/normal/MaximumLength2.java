package com.lwf.oneLearnOneday.normal;

/**
 * 2982. 找出出现至少三次的最长特殊子字符串 II
 *
 * @author: liuwenfei
 * @date: 2024/5/31-9:16
 */
public class MaximumLength2 {
    class Solution {
        public int maximumLength(String s) {
            int[][] counts=new int[26][s.length()];
            int max=-1;
            int i=0;
            while (i<s.length()){
                int j=i;
                while (j<s.length()&&s.charAt(i)==s.charAt(j)){
                    j++;
                }
                for (int k = j - i; k > 0; k--) {
                    counts[s.charAt(i)-'a'][k]+=j-i-k+1;
                    if (counts[s.charAt(i)-'a'][k]>=3){
                        max=Math.max(max,k);
                    }
                }
                i=j;

            }
            return max;
        }
    }
}
