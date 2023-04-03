package com.lwf.offer.two.tow;

/**
 * @author liuwenfei
 * @date 2023/3/30 9:33
 */
public class AddBinary {
    class Solution {
        public String addBinary(String a, String b) {
            int ai=a.length()-1,bi=b.length()-1;
            int step=0;
            StringBuilder stringBuilder = new StringBuilder();
            while (ai>=0||bi>=0||step>0){
                int ac=ai>=0?( a.charAt(ai--)-'0'):0;
                int bc=bi>=0?( b.charAt(bi--)-'0'):0;
                int cur=ac+bc+step;
                step=cur/2;
                cur%=2;
                stringBuilder.append(cur);
            }
            return stringBuilder.reverse().toString();
        }
    }
}
