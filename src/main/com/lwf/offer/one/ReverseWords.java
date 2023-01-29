package com.lwf.offer.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liuwenfei
 * @date 2023/1/29 14:29
 */
public class ReverseWords {
    class Solution {
        public String reverseWords(String s) {
            s= s.trim();
            String[] s1 = s.split("\\s+");
            List<String> s2=new ArrayList<String>(Arrays.asList( s1));
            Collections.reverse(s2);
            return String.join(" ",s2);
        }
    }
}
