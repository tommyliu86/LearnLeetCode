package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-12 09:50
 */
public class FindAndReplacePattern {
    class Solution {
        /**
         * 记录每个字母第一次出现位置i，后续出现的相同进行index-》index映射，这样后续的也在同样位置去比对即可。
         * 同时记录字母总个数，因为会出现多个字母替代问题。
         * @param words
         * @param pattern
         * @return
         */
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            int[] indexes=new int[pattern.length()];
            Map<Character,Integer> map=new HashMap<>();

            char[] chars1 = pattern.toCharArray();
            for (int i = 0; i < chars1.length; i++) {
                if (map.containsKey(chars1[i])) {
                    Integer integer = map.get(chars1[i]);
                    indexes[i]=integer;
                }else{
                    map.put(chars1[i],i);
                    indexes[i]=i;
                }
            }
            List<String> rtn=new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.length()!=indexes.length) {
                    continue;
                }
                char[] chars = word.toCharArray();
                boolean ok=true;
                Set<Character> set=new HashSet<>();
                for (int j = 0; j < chars.length; j++) {
                    int index = indexes[j];
                    if (chars[j]!=chars[index]){
                       ok=false;
                       break;
                    }
                    set.add(chars[j]);
                }
                if (ok&&set.size()==map.size()){
                    rtn.add(word);
                }

            }
            return rtn;
        }
    }
}
