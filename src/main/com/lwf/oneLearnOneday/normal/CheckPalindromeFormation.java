package com.lwf.oneLearnOneday.normal;

public class CheckPalindromeFormation {
    /**
     * 回文检查，只要检查a，b各一遍即可，检查自身，如果不是回文，则再检查a+b和b+a的拼接，
     */
    class Solution {
        public boolean checkPalindromeFormation(String a, String b) {

            char[] chara = a.toCharArray();
            char[] charb = b.toCharArray();
           return checks(chara,charb)||checks(charb,chara);

        }
        public boolean checks(char[] a, char[] b){
            int i = a.length / 2 - ((a.length % 2) == 1 ? 0 : 1);
            int j = a.length / 2;

            while (i >= 0 && j < a.length) {
                if (a[i] == a[j]) {
                    i--;
                    j++;
                } else {
                    return  checkAB(a, b, i, j) || checkAB(b, a, i, j);
                }
            }
            if (i < 0) {
                return true;
            }else{
                return false;
            }
        }
        public boolean checkAB(char[] a, char[] b, int i, int j) {

            while (i >= 0 && j < a.length && a[i] == b[j]) {
                i--;
                j++;
            }
            if (i < 0) {
                return true;
            }
            return false;
        }

    }
}
