package com.lwf.learn.everyday.data.level2.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-28 14:49
 */
public class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            char[] char1 = num1.toCharArray();
            char[] char2 = num2.toCharArray();
            StringBuilder builder = new StringBuilder();
            int step=0;

            int i1=char1.length-1;
            int i2=char2.length-1;
            while (i1>=0||i2>=0||step!=0){
                int sum = (i1 >= 0 ? (char1[i1--] - '0') : 0) + (i2 >= 0 ? (char2[i2--] - '0') : 0) + step;

                step=sum/10;
                sum%=10;
                builder.append(sum);


            }
            return builder.reverse().toString();
        }
    }
}
