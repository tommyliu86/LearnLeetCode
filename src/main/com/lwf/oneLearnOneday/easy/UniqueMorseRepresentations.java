package com.lwf.oneLearnOneday.easy;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-10 08:53
 */
public class UniqueMorseRepresentations {

   static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            Set<String> set=new LinkedHashSet<>();
            for (int i = words.length - 1; i >= 0; i--) {
                String word = words[i];
                StringBuffer stringBuffer = new StringBuffer();
                for (int j = 0; j < word.length(); j++) {
                    stringBuffer.append(chars[ word.charAt(j)-'a']);
                }
                set.add(stringBuffer.toString());
            }
            return set.size();
        }

        String[] chars=new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    }
}
