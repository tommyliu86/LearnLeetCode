package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-17 11:13
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            char[] ca;
            char[] cb;

            if (a.length() >= b.length()) {
                ca = a.toCharArray();
                cb = b.toCharArray();
            } else {
                ca = b.toCharArray();
                cb = a.toCharArray();
            }
            StringBuilder builder = new StringBuilder();
            int step = 0;
            for (int i = ca.length - 1; i >= 0; i--) {
                int m = ca.length - 1 - i;
                int sum;
                if (m < cb.length) {

                    sum = (ca[ca.length - 1 - m] == '0' ? 0 : 1 )+ (cb[cb.length - 1 - m] == '0' ? 0 : 1) + step;
                } else {
                    sum = (ca[ca.length - 1 - m] == '0' ? 0 : 1) + step;
                }
                step = sum / 2;
                builder.append(sum % 2);
            }
            if (step>0){
                builder.append(step);
            }
            return builder.reverse().toString();
        }
    }
}
