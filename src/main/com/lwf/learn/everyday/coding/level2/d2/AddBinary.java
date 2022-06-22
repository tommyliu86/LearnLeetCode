package com.lwf.learn.everyday.coding.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-17 17:24
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            char[] charsA = a.toCharArray();
            char[] charsB = b.toCharArray();

            int step=0;
            int ia=a.length();
            int ib=b.length();
            StringBuilder builder = new StringBuilder();

            while (ia>=0||ib>=0||step!=0){
                int i = (ia>=0?( charsA[ia]-'0'):0) +  (ib>=0?( charsB[ib]-'0'):0) + step;
                step=i/2;
                i=i%2;
                builder.append(i);
                ia--;
                ib--;
            }
            return builder.reverse().toString();
        }
    }
}
