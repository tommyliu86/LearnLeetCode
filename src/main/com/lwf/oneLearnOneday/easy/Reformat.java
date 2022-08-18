package com.lwf.oneLearnOneday.easy;

import java.util.ArrayList;
import java.util.List;

public class Reformat {
    class Solution {
        public String reformat(String s) {
            char[] chars = s.toCharArray();
            List<Integer> numI = new ArrayList<>();
            List<Integer> charI = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    numI.add(i);
                } else {
                    charI.add(i);
                }
            }
            if (Math.abs(numI.size() - charI.size()) > 1) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder();
            List<Integer> first, second;
            if (numI.size() >= charI.size()) {
                first = numI;
                second = charI;
            } else {
                first = charI;
                second = numI;
            }
            int i = 0;
            while (i < chars.length) {
                if ((i & 1) == 0) {

                    stringBuilder.append(chars[first.get(i++ / 2)]);
                } else {
                    stringBuilder.append(chars[second.get(i++ / 2)]);
                }
            }
            return stringBuilder.toString();
        }
    }
}
