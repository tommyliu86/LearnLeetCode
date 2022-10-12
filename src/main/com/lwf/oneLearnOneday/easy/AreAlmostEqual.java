package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/10/11 8:45
 */
public class AreAlmostEqual {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int dif = 0;
            int[] ds = new int[2];

            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] != chars1[i]) {
                    if (dif + 1 > 2) {
                        return false;
                    }
                    ds[dif] = i;
                    dif++;

                }
            }
            if (dif == 0) {
                return true;
            } else if (dif == 1) {
                return false;
            } else {
                return chars1[ds[0]] == chars2[ds[1]] && chars1[ds[1]] == chars2[ds[0]];
            }

        }
    }
}
