package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/11/17 9:09
 */
public class NumMatchingSubseq {
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int[][] marks=new int[s.length()+1][26];
            for (int i = marks.length - 2; i >= 0; i--) {
                int c = s.charAt(i) - 'a';
                for (int j = 0; j < marks[i].length; j++) {
                    marks[i][j]=j==c?i+1:marks[i+1][j];
                }
            }
            int ans=0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int k=0;
                boolean isOk=true;
                for (int j = 0; j < word.length(); j++) {
                    int curChar = word.charAt(j) - 'a';
                    if (k<marks.length&& marks[k][curChar]!=0) {
                        k=marks[k][curChar];
                    }else{
                        isOk=false;
                        break;
                    }
                }
                ans+=isOk?1:0;
            }
            return ans;
        }
    }
}
