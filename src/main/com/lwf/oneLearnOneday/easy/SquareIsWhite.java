package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/12/8 9:07
 */
public class SquareIsWhite {
    class Solution {
        public boolean squareIsWhite(String coordinates) {
            int i = coordinates.charAt(0) - 'a' + 1;
            int j = coordinates.charAt(1) - '1' + 1;
            if ((i&1)==(j&1)) {
                return false;
            }else{
                return true;
            }
        }
    }
}
