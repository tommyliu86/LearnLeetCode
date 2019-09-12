package com.lwf.TOP100;

/**
 * author Administrator
 * time 2019-09-03-23:21
 * {@link 3.md}
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<2)return s.length();
        int[] map=new int[128];
        int min=0;
        int max=0;
        for (int i = 0; i < s.length(); i++) {
            int pos=s.charAt(i)-0;
            if (map[pos]!=0&&map[pos]>min){
                max=Math.max(max,i-min);
                min=map[pos];
                map[pos]=i+1;
            }else{
                map[pos]=i+1;
            }
        }
        return Math.max(max,s.length()-min);
    }
}
