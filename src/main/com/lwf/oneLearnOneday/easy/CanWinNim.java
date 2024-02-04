package com.lwf.oneLearnOneday.easy;

/**
 * 292. Nim 游戏
 * @author liuwenfei
 * @date 2024/2/4 8:39
 */
public class CanWinNim {
    /**
     * 拿石头，每次1~3，则最少的倍数是4，因此，只要计算是4的倍数 x，有余数我赢，没余数他赢
     */
    class Solution {
        public boolean canWinNim(int n) {

            return n%4!=0;
        }
    }
}
