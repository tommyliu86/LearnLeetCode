package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/2/8 18:13
 */
public class StrToInt {
    class Solution {
        public int strToInt(String str) {
            long ans=0;
           int i=0;
           int mark=0;
           while (i<str.length()&&str.charAt(i)==' ') i++;
           if (i==str.length()) return 0;
           if (str.charAt(i)=='+'||str.charAt(i)=='-'){
               mark=str.charAt(i)=='+'?1:-1;
               i++;
           }
           while (i<str.length()&&( str.charAt(i)-'0'>=0&& str.charAt(i)-'0'<=9)){
               ans=ans*10+str.charAt(i)-'0';
               i++;
               if (mark*ans>Integer.MAX_VALUE||mark*ans<Integer.MIN_VALUE){
                   return mark*ans>Integer.MAX_VALUE?Integer.MAX_VALUE:Integer.MIN_VALUE;
               }
            }
           return (int) (mark*ans);
        }
    }
}
