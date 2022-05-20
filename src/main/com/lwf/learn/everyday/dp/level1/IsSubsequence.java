package com.lwf.learn.everyday.dp.level1;

/**
 * Created with IntelliJ IDEA.
 * 双指针法
 *
 * @author: liuwenfei14
 * @date: 2022-05-20 18:01
 */
public class IsSubsequence {
    /**
     * 二维数组,对t的预处理，基于双指针的方式
     */
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int[][] mark=new int[t.length()][26];
            for (int i = mark.length - 1; i >= 0; i--) {
                for (int j = 0; j < mark[i].length; j++) {
                    if (t.charAt(i)-'a'==j){
                        mark[i][j]=i;
                    }else{
                        if (i==t.length()-1){
                            mark[i][j]=-1;
                        }else{
                            mark[i][j]=mark[i+1][j];
                        }
                    }
                }
            }
            int si=0;
            int ti=0;
            while (ti!=-1&& si<s.length()&&ti<t.length()){
                int i = s.charAt(si) - 'a';
               ti= mark[ti][i];
               if (ti!=-1){
                   ti++;
               }else{
                   break;
               }
               si++;
            }
            return si==s.length();
        }
    }
    /**
     * 二维数组
     */
    class Solution2 {
        public boolean isSubsequence(String s, String t) {
            if (t.length() < s.length()) {
                return false;
            }
            int[][] len=new int[s.length()+1][t.length()+1];
            for (int i = 1; i < len.length; i++) {
                for (int j = 1; j < len[i].length; j++) {
                    if (s.charAt(i-1)==t.charAt(j-1)) {
                        len[i][j]=len[i-1][j-1]+1;
                    }else{
                        len[i][j]=Math.max(len[i-1][j],len[i][j-1]);
                    }
                }
            }
            return len[s.length()+1][t.length()+1]==s.length();
        }
    }

    /**
     * 双指针法
     */
    class Solution1 {
        public boolean isSubsequence(String s, String t) {
            if (t.length() < s.length()) {
                return false;
            }
            int sl = 0;
            int tl = 0;
            while (sl < s.length() && tl < t.length()) {
                if (s.charAt(sl) == t.charAt(tl)) {
                    sl++;
                    tl++;
                } else {
                    tl++;
                }
            }
            return sl == s.length();
        }
    }
}
