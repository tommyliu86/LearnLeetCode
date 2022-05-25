package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-25 10:00
 */
public class FindSubstringInWraproundString {
    class Solution {
        public int findSubstringInWraproundString(String p) {
            char[] chars = p.toCharArray();
            int[] lens=new int[26];
            int left=0;
            int right=0;
            while (right+1<chars.length){
                lens[chars[right]-'a']=Math.max( lens[chars[right]-'a'],right-left+1);

                int sub = chars[right+1] - chars[right];
                if (sub ==1||(sub==-25&&chars[right]=='z')){
                    right++;
                }else{
                    right++;
                    left=right;
                }
            }
            lens[chars[right]-'a']=Math.max( lens[chars[right]-'a'],right-left+1);

            int count=0;
            for (int i = 0; i < lens.length; i++) {
                count+=lens[i];
            }
            return count;
        }
    }
}
