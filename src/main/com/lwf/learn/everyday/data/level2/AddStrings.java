package com.lwf.learn.everyday.data.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-03 09:52
 */
public class AddStrings {
    class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder builder=new StringBuilder();
            int i1=num1.length()-1;
            int i2=num2.length()-1;
            int step=0;
            while (i1>=0||i2>=0||step>0){
                int sum=step+(i1>=0? num1.charAt(i1)-'0':0)+(i2>=0? num2.charAt(i2)-'0':0);
                step=sum/10;
                builder.append(sum%10);
                i1--;
                i2--;
            }
            return builder.reverse().toString();
        }
    }
}
