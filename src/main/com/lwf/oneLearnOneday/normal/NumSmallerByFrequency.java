package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;

public class NumSmallerByFrequency {
    /**
     * 分类统计，这里统计的是指定长度的word的个数，而word的长度最大是10，因此可以直接统计。
     */
    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] lens=new int[11];
            for (int i = 0; i < words.length; i++) {
                int l = getL(words[i]);
                lens[l-1]++;
            }
            for (int i = lens.length - 2; i >= 0; i--) {
                lens[i]+=lens[i+1];
            }
            int[] ans=new int[queries.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=lens[getL(queries[i])];
            }
            return ans;
        }
        public int getL(String s){
            char c='z'+1;
            int count=0;
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                if (c1<c){
                    c=c1;
                    count=1;
                }else if (c1==c){
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * 排序+二分查找
     */
    class Solution1 {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] scores = new int[words.length];
            for (int i = 0; i < scores.length; i++) {
                scores[i] = queryMin(words[i]);
            }
            Arrays.sort(scores);
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int i1 = queryMin(queries[i]);
                int j = half(scores, i1);
                ans[i] = j < 0 ? 0 : scores.length - j;
            }
            return ans;
        }

        /**
         * 二分查找，查找大于k的第一个数的位置
         *
         * @param ints
         * @param k
         * @return
         */
        public int half(int[] ints, int k) {
            int i = 0, j = ints.length - 1;
            while (i <= j) {
                int m = (i + j) / 2;
                if (ints[m] <= k) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return i;
        }

        public int queryMin(String s) {
            char c = 'z' + 1;
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char c1 = s.charAt(i);
                if (c1 < c) {
                    c = c1;
                    count = 1;
                } else if (c1 == c) {
                    count++;
                }
            }
            return count;
        }
    }
}
