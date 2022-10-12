package com.lwf.oneLearnOneday.normal;


/**
 * @author liuwenfei
 * @date 2022/10/3 19:31
 */
public class CanTransform {
    /**
     * 找到核心规律，双指针匹配
     */
    static class Solution {
        public boolean canTransform(String start, String end) {
            int si=0,ei=0;
            int n = start.length();
            while (si<n||ei<n){
                while (si<n&& start.charAt(si)=='X'){
                    si++;
                }
                while (ei<n&& end.charAt(ei)=='X'){
                    ei++;
                }
                if (si==n&&ei==n){
                    return true;
                }
                if (si<n&&ei<n&& start.charAt(si)==end.charAt(ei)){
                    if ((start.charAt(si)=='L'&&si<=ei)||(start.charAt(si)=='R'&&si>=ei)){

                        si++;
                        ei++;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }

        return si==n&&ei==n;
        }
    }

    /**
     * 模拟运算
     */
    static class Solution1 {
        public boolean canTransform(String start, String end) {
            char[] starts = start.toCharArray();
            char[] ends = end.toCharArray();
            int si = 0, ei = 0;
            while (ei < end.length()) {
                if (starts[si] == ends[ei]) {
                    si++;
                    ei++;
                } else if (ei == ends.length - 1) {
                    return false;
                } else if ((starts[si] == 'X') && (ends[ei] == 'L')) {
                    int a = 0, b = 1;
                    int i = si + 1;

                    while (i < start.length() && a != b) {
                        if (starts[i] == 'R' || ends[i] == 'R') {
                            return false;
                        }

                        if (starts[i] == 'L') {
                            a++;
                        }
                        if (ends[i] == 'L') {
                            b++;
                        }
                        i++;
                    }
                    if (a != b) {
                        return false;
                    }
                    si = i;
                    ei = i;
                } else if ((starts[si] == 'R') && (ends[ei] == 'X')) {
                    int a = 1, b = 0;
                    int i = si + 1;

                    while (i < start.length() && a != b) {
                        if (starts[i] == 'L' || ends[i] == 'L') {
                            return false;
                        }

                        if (starts[i] == 'R') {
                            a++;
                        }
                        if (ends[i] == 'R') {
                            b++;
                        }
                        i++;
                    }
                    if (a != b) {
                        return false;
                    }
                    si = i;
                    ei = i;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
