package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/6/5 8:56
 */
public class MaxRepOpt1 {
    class Solution {
        public int maxRepOpt1(String text) {
            int[] chars=new int[26];
            for (int i = 0; i < text.length(); i++) {
                chars[text.charAt(i)-'a']++;
            }
            int max=0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i]==0) {
                    continue;
                }
                max=Math.max(max,max(text,(char)( i+'a'),chars[i]));
            }
            return max;
        }

        /**
         * 双指针，查找两段分别得长度，然后再计算长度，后指针向前走得方法。
         * @param t
         * @param c
         * @param count
         * @return
         */
        public int max(String t,char c,int count){
            int i=0,j=0,max=0;
            while (i<t.length()){
                j=i;
                while (j<t.length()&&t.charAt(j)==c){
                    j++;
                }
                int k=j+1;
                while (k<t.length()&&t.charAt(k)==c){
                    k++;
                }
                max=Math.max(max,Math.min( j-i+k-j,count));
                i=j+1;
            }
            return max;
        }
    }
}
