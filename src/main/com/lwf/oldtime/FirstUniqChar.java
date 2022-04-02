package com.lwf.oldtime;

import java.util.HashMap;
import java.util.Map;

/**
 * author Administrator
 * time 2019-08-06
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        if (s.length()==1) return 0;
        char[] chars=s.toCharArray();
       int[] ss=new int[chars.length];
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                ss[map.get(chars[i])]++;
            }else   {
                map.put(chars[i],i);
                ss[i]++;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (ss[i]==1) return i;
        }
        return -1;
    }
    public int firstUniqChar1(String s) {
        if (s.length()==1) return 0;
        char[] chars=s.toCharArray();

        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }else   {
                map.put(chars[i],1);

            }
        }
        for (int i = 0; i < chars.length; i++) {
           if (map.get(chars[i])==1) return i;
        }
        return -1;
    }
}
