package com.lwf.oneLearnOneday.hard;

import java.lang.annotation.Target;

/**
 * @author liuwenfei
 * @date 2022/9/21 8:57
 */
public class KSimilarity {
    public static void main(String[] args) {
        new Solution().kSimilarity(
                "abccaacceecdeea",
                "bcaacceeccdeaae");
    }
  static   class Solution {
      /**
       * 递归+回溯
       * @param s1
       * @param s2
       * @return
       */
        public int kSimilarity(String s1, String s2) {
            return dfs(s1.toCharArray(), s2.toCharArray(), 0);
        }

        private int dfs(char[] s1, char[] s2, int i) {
            if (i == s1.length - 1) {
                return 0;
            }
            if (s1[i] == s2[i]) {
                return dfs(s1, s2, i + 1);
            } else {
                int min=Integer.MAX_VALUE;
                for (int j = i+1; j < s1.length; j++) {
                    if (s1[j]==s2[i]){
                        swap(s1,i,j);
                        min=Math.min(dfs(s1,s2,i+1),min);
                        swap(s1,j,i);
                        if (s2[j]==s1[i]){
                            break;
                        }
                    }
                }

                return 1 +min;
            }
        }
        private void swap(char[] s1, int i, int j) {
            char temp = s1[i];
            s1[i] = s1[j];
            s1[j] = temp;
        }
        private void swap(char[] s1, char[] s2, int i) {
            int first = -1;
            boolean swap=false;
            for (int j = i + 1; j < s1.length; j++) {
                if (s1[j] == s2[i]) {

                    if (first == -1) {
                        first = j;
                    } else if ( s2[j] == s1[i]) {
                        char temp = s1[i];
                        s1[i] = s1[j];
                        s1[j] = temp;
                        swap=true;
                        break;
                    }
                }
            }
            if (!swap){
                char temp = s1[first];
                s1[i] = s1[first];
                s1[first] = temp;
            }
        }
    }
}
