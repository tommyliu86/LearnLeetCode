package com.lwf.oneLearnOneday.easy;

/**
 * 2806. 取整购买后的账户余额
 *
 * @author: liuwenfei
 * @date: 2024/6/12-8:48
 */
public class accountBalanceAfterPurchase {
    class Solution {
        public int accountBalanceAfterPurchase(int purchaseAmount) {
            int i = purchaseAmount % 10;
            if (i>=5){
                return 100-( purchaseAmount-i+10);
            }else{
                return 100-( purchaseAmount-i);
            }
        }
    }
}
