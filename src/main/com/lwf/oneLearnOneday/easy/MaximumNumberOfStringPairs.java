package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2024/1/18 9:08
 */
public class MaximumNumberOfStringPairs {
    class Solution {
        public int maximumNumberOfStringPairs(String[] words) {
            int ans=0;
            Set<String> set=new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                if (set.contains(words[i])) {
                    ans++;
                }else{
                    char[] chars = words[i].toCharArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i1 = chars.length - 1; i1 >= 0; i1--) {
                        stringBuilder.append(chars[i1]);
                    }
                    set.add( stringBuilder.toString());
                }
            }
            return ans;
        }
    }
}
