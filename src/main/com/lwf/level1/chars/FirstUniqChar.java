package com.lwf.level1.chars;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 20:25
 */
public class FirstUniqChar {
    class Solution {
        /**
         * 两次遍历
         * @param s
         * @return
         */
        public int firstUniqChar(String s) {
            int[] index=new int[s.length()];
            HashMap<Character, Integer>  hashMap=new HashMap<>();
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (hashMap.containsKey(chars[i])){
                    index[i]=1;
                    index[hashMap.get(chars[i])]=1;
                }else{
                    hashMap.put(chars[i],i);
                }
            }
            for (int i = 0; i < index.length; i++) {
                if (index[i]==0){
                    return i;
                }
            }
            return  -1;
        }
    }
}
