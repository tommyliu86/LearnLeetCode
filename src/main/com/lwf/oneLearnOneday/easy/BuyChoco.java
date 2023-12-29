package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * 2706. 购买两块巧克力
 * @author liuwenfei
 * @date 2023/12/29 9:11
 */
public class BuyChoco {
    class Solution {
        public int buyChoco(int[] prices, int money) {
            Arrays.sort(prices);
            return prices[0] + prices[1] > money ? money : (money-prices[0] - prices[1]);
        }
    }
}
