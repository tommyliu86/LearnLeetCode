package com.lwf.oneLearnOneday.normal;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-11 13:26
 */
public class MinFlipsMonoIncr {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            char[] chars = s.toCharArray();
            int end0=0;
            int end1=0;
            for (int i = 0; i < chars.length; i++) {
                char aChar = chars[i];
                if (aChar=='0'){
                    end1=Math.min(end0+1,end1+1);
                    end0=end0;
                }else{
                    end1=Math.min(end0,end1);
                    end0=end0+1;
                }
            }
            return Math.min(end0,end1);
        }
    }
}
