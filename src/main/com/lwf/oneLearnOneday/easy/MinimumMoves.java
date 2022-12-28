package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/12/27 9:05
 */
public class MinimumMoves {
    class Solution {
        public int minimumMoves(String s) {
            int ans=0;
            int i=0;
            while (i<s.length()){

                if (s.charAt(i)=='X'){
                    ans++;
                    i+=3;
                }else{
                    i++;
                }
            }
            return ans;
        }
    }
}
