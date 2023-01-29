package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/1/29 8:59
 */
public class CountAsterisks {
    class Solution {
        public int countAsterisks(String s) {
            int ans=0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i)=='*'){
                    ans++;
                }else if (s.charAt(i)=='|'){
                    while (s.charAt( ++i)!='|'){
                    }
                }
            }
            return ans;
        }
    }
}
