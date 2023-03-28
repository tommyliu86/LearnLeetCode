package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/3/27 8:52
 */
public class CountSubstrings {
    /**
     * 2 预处理，获取到每个位置的 相同前缀和后缀，然后进行处理即可，对应官解的dp，感觉这里不应该叫dp叫预处理会恰当很多
     */
    class Solution {
        public int countSubstrings(String s, String t) {
            //前缀长度
            int[][] dp=new int[s.length()+1][t.length()+1];
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
            }
            //后缀长度
            int[][] dpPost=new int[s.length()+1][t.length()+1];
            for (int i = dpPost.length-2; i >= 0; i--) {
                for (int j = dpPost[i].length-2; j >= 0; j--) {
                    if (s.charAt(i)==t.charAt(j)){
                        dpPost[i][j]=dpPost[i+1][j+1]+1;
                    }
                }
            }
            int ans=0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    //当两个char不相同的时候，char+相同前缀  *char+相同后缀可以组合出所有的子串，因此需要+1
                    if (s.charAt(i)!=t.charAt(j)){
                        ans+=(dp[i][j]+1)*(dpPost[i+1][j+1]+1);
                    }
                }
            }
            return ans;
        }
    }
    /**
     * 1. 子串的遍历法：以i为起点或终点，另外一个j向前或向后遍历到末尾，就可以枚举出所有的子字符串
     */
    class Solution1 {
        public int countSubstrings(String s, String t) {
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < t.length(); j++) {
                    int i1 = i, j1 = j;
                    int diff = 0;
                    while (i1 < s.length() && j1 < t.length() && diff < 2) {
                        if (s.charAt(i1) != t.charAt(j1)) {
                            diff++;
                        }
                        //起点固定，每向后走一步，都是一个新子串，只要diff==1，答案就+1
                        if (diff == 1) {
                            ans++;
                        }
                        i1++;
                        j1++;
                    }
                }
            }

            return ans;
        }
    }
}
