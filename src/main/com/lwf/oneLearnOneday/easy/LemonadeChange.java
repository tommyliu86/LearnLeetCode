package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/7/24 9:02
 */
public class LemonadeChange {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int  c5=0,c10=0;
            for (int i = 0; i < bills.length; i++) {
                if (bills[i]==5) {
                    c5++;
                }else if (bills[i]==10){
                    c5--;
                    c10++;
                    if (c5<0){
                        return false;
                    }
                }else {
                    if (c10>0) {
                        c10--;
                        c5--;
                    }else{
                        c5-=3;
                    }
                    if (c5<0){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
