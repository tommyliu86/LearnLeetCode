package com.lwf.oneLearnOneday.easy;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author liuwenfei
 * @date 2023/7/24 9:09
 */
public class NumJewelsInStones {
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> je=new HashSet<>();
            for (int i = 0; i < jewels.length(); i++) {
               je.add(jewels.charAt(i));
            }
            int ans=0;
            for (int i = 0; i < stones.length(); i++) {
                if (je.contains(stones.charAt(i))) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
