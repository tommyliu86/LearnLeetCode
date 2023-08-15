package com.lwf.oneLearnOneday.normal;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2023/8/15 8:35
 */
public class FindReplaceString {
    /**
     * 使用subString
     */
    class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            Map<Integer,Integer> map= new HashMap<>();
            for (int i = 0; i < indices.length; i++) {
                map.put(indices[i],i);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(i)){
                    Integer integer = map.get(i);

                    String source = sources[integer];
                    String target = targets[integer];

                    boolean ok = true;
                    for (int j = 0; ok && j < source.length(); j++) {
                        if (i + j >= s.length() || s.charAt(i + j) != source.charAt(j)) {
                            ok = false;
                        }
                    }
                    if (ok) {
                        stringBuilder.append(target);
                        i+=source.length()-1;
                    }else{
                        stringBuilder.append(s.charAt(i));
                    }

                }else{
                    stringBuilder.append(s.charAt(i));
                }
            }
            return stringBuilder.toString();
        }
    }

    /**
     * 使用subString
     */
    class Solution1 {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            Integer[] ind = new Integer[indices.length];
            for (int i = 0; i < ind.length; i++) {
                ind[i] = i;
            }
            Arrays.sort(ind, (a, b) -> Integer.compare(indices[b], indices[a]));

            for (int i = 0; i < ind.length; i++) {
                Integer index = indices[ind[i]];
                String source = sources[ind[i]];
                boolean ok = true;
                for (int j = 0; ok && j < source.length(); j++) {
                    if (index + j >= s.length() || s.charAt(index + j) != source.charAt(j)) {
                        ok = false;
                    }
                }
                if (ok) {
                    s = s.substring(0, index) + targets[ind[i]] + s.substring(index + source.length());
                }

            }
            return s;
        }

    }
}
