package com.lwf.oldtime;

import java.util.HashMap;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> map=new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else   {
                map.put(c,1);
            }
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)&&map.get(c)>0){
                map.put(c,map.get(c)-1);
            }else{
                return c;
            }
        }
        return 'a';
    }
    public char findTheDifference1(String s, String t) {
        int[] chars=new int[26];
        for (char c : s.toCharArray()) {
            chars[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            if (chars[c-'a']>0){
                chars[c-'a']--;
            }else{
                return c;
            }
        }
        return 'a';
    }
    public char findTheDifference2(String s, String t) {
       int rtn=0;
        for (char c : s.toCharArray()) {
           rtn= rtn^c;
        }
        for (char c : t.toCharArray()) {
           rtn^=c;
        }
        return (char)rtn;
    }
}
