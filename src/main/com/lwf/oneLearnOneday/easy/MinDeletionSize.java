package com.lwf.oneLearnOneday.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-12 09:04
 */
public class MinDeletionSize {
    class Solution {
        public int minDeletionSize(String[] strs) {
            int l = strs[0].length();
            int[] mark = new int[l];
            int delete = 0;
            for (int i = 0; delete < l && i < strs.length; i++) {
                String str = strs[i];
                for (int j = 0; j < l; j++) {
                    if (mark[j] >= 0) {
                        if (mark[j] <= str.charAt(j) - 'a') {
                            mark[j] = str.charAt(j) - 'a';
                        } else {
                            delete++;
                            mark[j] = -1;
                        }
                    }
                }
            }
            return delete;
        }
    }
}
