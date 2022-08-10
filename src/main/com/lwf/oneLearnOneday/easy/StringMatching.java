package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringMatching {
    class Solution {
        public List<String> stringMatching(String[] words) {
            Arrays.sort(words, Comparator.comparing(String::length));
            int n = words.length;
            List<String> rtn=new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length()==words[n-1].length()){
                    break;
                }
                for (int j = n-1; j > i; j--) {
                    if (words[j].contains(words[i])){
                        rtn.add(words[i]);
                        break;
                    }
                }
            }
            return rtn;
        }
    }
}
