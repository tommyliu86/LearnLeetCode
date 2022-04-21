package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-04-21 08:35
 */
public class ToGoatLatin {
    class Solution {
        public String toGoatLatin(String sentence) {
            Set<Character> set=new HashSet<>();
            set.addAll(Arrays.asList( 'a','e','i','o','u','A','E','I','O','U'));
            char[] chars = sentence.toCharArray();
            String step="ma";
            StringBuilder builder=new StringBuilder();
            for (int i = 0; i < chars.length;) {
                if (chars[i]==' '){
                    builder.append(chars[i]);
                    i++;
                    continue;
                }
                step+="a";
                int cursor=i;
                String post="";
                if (set.contains( chars[cursor])){
                    builder.append(chars[cursor++]);
                }else{
                    post= String.valueOf(chars[cursor++]);
                }
                while (cursor<chars.length&& chars[cursor]!=' '){
                    builder.append(chars[cursor++]);
                }

                builder.append(post).append(step);
                i=cursor;
            }
            return builder.toString();
        }

    }
}
