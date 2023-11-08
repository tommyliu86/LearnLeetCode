package com.lwf.oneLearnOneday.easy;

/**
 * 2609. 最长平衡子字符串
 * https://leetcode.cn/problems/find-the-longest-balanced-substring-of-a-binary-string/?envType=daily-question&envId=2023-11-08
 * @author liuwenfei
 * @date 2023/11/8 8:42
 */
public class FindTheLongestBalancedSubstring {
    /**
     * 遍历，记录每个0--1的分段，然后使用最小0和1的长度*2，然后继续下一个分段即可。每个循环保证从0开始到1结束，
     */
    class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int i=0;
            int ans=0;
            while (i<s.length()){
                int l0=0,l1=0;
                while (i<s.length()&&s.charAt(i)!='0'){
                    i++;
                }
                while (i<s.length()&&s.charAt(i)!='1'){
                    l0++;
                    i++;
                }
                while (i<s.length()&&s.charAt(i)!='0'){
                    l1++;
                    i++;
                }
                ans=Math.max(ans,Math.min(l0,l1)*2);
            }
            return ans;
        }
    }
}
