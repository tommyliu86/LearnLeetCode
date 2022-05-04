package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 09:48
 */
public class ReorderLogFiles {
    class Solution {
        public String[] reorderLogFiles(String[] logs) {
            int slow = logs.length - 1;
            int fast = logs.length - 1;
            while (fast > -1) {
                if (isNum(logs[fast])) {
                    String temp = logs[fast];
                    logs[fast] = logs[slow];
                    logs[slow] = temp;
                    fast--;
                    slow--;
                } else {
                    fast--;
                }
            }
            if (slow != 0) {
                Arrays.sort(logs, 0, slow + 1, (a, b) -> {
                    return compare(a, b);
                });
            }
            return logs;
        }

        public boolean isNum(String s) {
            int i = 0;
            char[] chars = s.toCharArray();
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            return '0' <= chars[i + 1] && chars[i + 1] <= '9';
        }

        public int compare(String a, String b) {
            String[] splita = split(a);
            String[] splitb = split(b);
            int co = compareSub(splita[1], splitb[1]);
            if (co == 0) {
                return compareSub(splita[0], splitb[0]);
            } else {
                return co;
            }
        }

        public int compareSub(String a, String b) {
            int ia = 0;
            int ib = 0;
            while (ia < a.length() && ib < b.length()) {
                if (a.charAt(ia) == b.charAt(ib)) {
                    ia++;
                    ib++;
                    continue;
                }
                return Character.compare(a.charAt(ia), b.charAt(ib));
            }
            return Integer.compare(a.length(), b.length());
        }

        public String[] split(String s) {
            int i = 0;
            char[] chars = s.toCharArray();
            while (i < chars.length && chars[i] != ' ') {
                i++;
            }
            String[] rtn = new String[2];
            rtn[0] = s.substring(0, i);
            rtn[1] = s.substring(i + 1, s.length());
            return rtn;
        }
    }
}
