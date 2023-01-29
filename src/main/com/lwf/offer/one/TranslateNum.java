package com.lwf.offer.one;

/**
 * @author liuwenfei
 * @date 2023/1/29 10:41
 */
public class TranslateNum {
    class Solution {
        public int translateNum(int num) {
            int i1=0,i2=0;
            String s = String.valueOf(num);
            int i=0;
            while (i<s.length()){
                char c = s.charAt(i);
                int tem=i2;
                if (i!=0){
                    int sub=(s.charAt(i-1)-'1'+1)*10+(s.charAt(i)-'1'+1);
                    if (sub>=10&&sub<=25){
                        tem+=i1;
                    }
                }
                i1=i2;
                i2=tem;
            }
            return i2;
        }
    }
}
