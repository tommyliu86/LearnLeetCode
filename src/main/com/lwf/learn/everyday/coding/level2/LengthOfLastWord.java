package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 10:55
 */
public class LengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            char[] chars = s.toCharArray();
            boolean start=false;
            int l=0;
            for (int i = chars.length - 1; i >= 0; i--) {
                char c = chars[i];

                if (!start){
                    if (c!=' '){
                        start=true;
                        l=1;
                    }
                }else{
                    if (c!=' '){
                        l++;
                    }else{
                        break;
                    }
                }
            }
            return l;
        }
    }
}
