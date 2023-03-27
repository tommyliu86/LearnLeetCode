package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/3/21 17:19
 */
public class FindLexSmallestString {
    //暴力，循环遍历所有可能性。。。
    class Solution {
        public String findLexSmallestString(String s, int a, int b) {

            int n = s.length();
            b = b % n;
            int i = 0;
            String min = s;
            do {
                char[] chars = s.toCharArray();
                for (int i1 = 0; i1 < 10; i1++) {

                    for (int k = 1; k < chars.length; k += 2) {
                        chars[k] = (char) ((chars[k] - '0' + a) + '0');
                    }
                    // (A+B)%C ，b和c奇偶不一致，影响奇偶，否则不影响奇偶性
                    if ( n% 2 == b % 2) {
                        String newS = String.valueOf(chars);
                        if (newS.compareTo(min) < 0) {
                            min = newS;
                        }
                    } else {
                        for (int i2 = 0; i2 < 10; i2++) {
                            for (int k = 0; k < chars.length; k += 2) {
                                chars[k] = (char) ((chars[k] - '0' + a) + '0');
                            }
                            String newS = String.valueOf(chars);
                            if (newS.compareTo(min) < 0) {
                                min = newS;
                            }
                        }
                    }
                }
                String left = s.substring(0, n - b);
                String right=s.substring(n-b,n);
                s=right+left;

                i++;
            } while ((i * b) % n != 0);
            return min;
        }
    }
}
