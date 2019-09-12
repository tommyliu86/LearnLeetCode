package com.lwf;

/**
 * author Administrator
 * time 2019-08-21-22:29
 * {@link 520.md}
 */
public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if(word.length()<2) return true;
        char[] chars  =word.toCharArray();

        if (chars[0]<'a'){
            if (chars[1]<'a'){
                for (int i = 2; i < chars.length; i++) {
                    if (chars[i]>='a') return false;
                }
                return true;

            }else{
                for (int i = 2; i < chars.length; i++) {
                    if (chars[i]<'a') return false;
                }
                return true;
            }
        }else{
            for (int i = 1; i < chars.length; i++) {
                if (chars[i]<'a') return false;
            }
            return true;
        }
    }
}
