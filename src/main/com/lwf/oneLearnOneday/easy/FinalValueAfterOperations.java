package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2022/12/25 12:47
 */
public class FinalValueAfterOperations {
    class Solution {
        public int finalValueAfterOperations(String[] operations) {
            int ans=0;
            for (int i = 0; i < operations.length; i++) {
                if (operations[i].equals("X++")||operations[i].equals("++X")) {
                    ans++;
                }else{
                    ans--;
                }
            }
            return ans;
        }
    }
}
