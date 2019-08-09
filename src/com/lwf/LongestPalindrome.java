package com.lwf;

import java.util.HashMap;

/**
 * author Administrator
 * time 2019-08-09
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println((int) 'a'-'A');
        System.out.println((int) 'Z');
    }
    public int longestPalindrome(String s) {
        char[] chars=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        if (chars.length<2) return chars.length;
        int rtn=0;
        for (char aChar : chars) {
            if (!map.containsKey(aChar)){
                map.put(aChar,1);
            }else{
                if (map.get(aChar)==0){
                    map.put(aChar,1);
                }else   {
                    rtn+=2;
                    map.put(aChar,0);
                }
            }
        }
        return rtn==chars.length?rtn:rtn+1;
    }
    public int longestPalindrome1(String s) {
        char[] chars=s.toCharArray();
        if (chars.length<2) return chars.length;

       int[] flags=new int[90];

        int rtn=0;
        for (char c : chars) {
            if (flags[c-0]==1){
                rtn+=2;
                flags[c-0]=0;
            }else{
                flags[c-0]=1;
            }
        }
       return rtn==chars.length?rtn:rtn+1;
    }
}
