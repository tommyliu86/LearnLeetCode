package com.lwf.learn.everyday.dp.level1.d2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-10 17:33
 */
public class IsSubsequence {
    class Solution1 {
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            char[] chars = t.toCharArray();
            int[][] indexs = new int[chars.length + 1][26];
            for (int i = indexs.length - 2; i >= 0; i--) {
                int j = chars[i] - 'a';
                int[] post = indexs[i + 1];
                for (int k = 0; k < indexs[i].length; k++) {
                    if (k == j) {
                        indexs[i][k] = i + 1;
                    } else {
                        indexs[i][k] = post[k];
                    }
                }
            }
            char[] chars1 = s.toCharArray();
            int next = 0;
            for (int i = 0; i < chars1.length; i++) {
                int[] index = indexs[next];
                int j = chars1[i] - 'a';
                if (index[j] == 0) {
                    return false;
                }
                next = index[j];
            }
            return true;

        }
    }

    class Solution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() > t.length()) {
                return false;
            }
            char[] chars = t.toCharArray();
            List<Integer>[] list = new List[26];
            for (int i = 0; i < list.length; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < chars.length; i++) {
                int j = chars[i] - 'a';
                list[j].add(i);
            }
            char[] charss = s.toCharArray();
            int index = -1;
            for (int i = 0; index < t.length() && i < charss.length; i++) {
                int j = charss[i] - 'a';
                List<Integer> list1 = list[j];
                if (list1.size() == 0) {
                    return false;
                }
                int newi = half(list1, 0, list1.size() - 1, index);
                if (list1.get(newi) <= index) {
                    return false;
                }
                index = list1.get(newi);
            }
            return true;

        }

        public int half(List<Integer> list, int l, int r, int t) {
            if (l >= r) {
                return l;
            }
            int m = (l + r) / 2;
            if (list.get(m) > t) {
                return half(list, l, m, t);
            } else {
                return half(list, m + 1, r, t);
            }
        }
    }
}
