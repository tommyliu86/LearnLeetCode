package com.lwf.classic.two.tow;

/**
 * @author liuwenfei
 * @date 2023/4/7 11:26
 */
public class ValidPalindrome {
    class Solution {
        public boolean validPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return j - i == 1 || check(s, i + 1, j) || check(s, i, j - 1);
                }
                i++;
                j--;
            }
            return true;
        }

        public boolean check(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

    class Solution1 {
        public boolean validPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    break;
                } else {
                    i++;
                    j--;
                }
            }
            if (i >= j || j - i == 1) return true;
            int i1 = i + 1, j1 = j;
            while (i1 < j1) {
                if (s.charAt(i1) != s.charAt(j1)) {
                    break;
                } else {
                    i1++;
                    j1--;
                }
            }
            if (i1 >= j1) {
                return true;
            }
            i1 = i;
            j1 = j - 1;
            while (i1 < j1) {
                if (s.charAt(i1) != s.charAt(j1)) {
                    return false;
                } else {
                    i1++;
                    j1--;
                }
            }

            return true;


        }

    }
}
