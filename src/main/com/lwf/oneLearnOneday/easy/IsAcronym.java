package com.lwf.oneLearnOneday.easy;

import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/12/20 8:42
 */
public class IsAcronym {
    class Solution {
        public boolean isAcronym(List<String> words, String s) {
            if (s.length()!=words.size()) {
                return false;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)!=words.get(i).charAt(0)) {
                    return false;
                }
            }
            return true;
        }
    }
}
