package com.lwf.classic.two;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuwenfei
 * @date 2023/3/17 17:26
 */
public class IsAlienSorted {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            Map<Character,Integer> map=new HashMap<>();
            for (int i = 0; i < order.length(); i++) {
                map.put(order.charAt(i),i);
            }
            for (int i = 1; i < words.length; i++) {
                if (!compare(words[i-1],words[i],map)){
                    return false;
                }
            }
            return true;
        }

        private boolean compare(String word, String word1, Map<Character, Integer> map) {
            int i=0;
            while (i<word.length()&&i<word1.length()){
                int a=Integer.compare(map.get( word.charAt(i)),map.get(word1.charAt(i)));
                if (a>0){
                    return false;
                }else if (a<0){
                    return true;
                }
                i++;
            }
            return word.length()<=word1.length();
        }

    }
}
