package com.lwf.learn.everyday.coding.level2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-30 15:20
 */
public class LemonadeChange {
    class Solution {
        public boolean lemonadeChange(int[] bills) {
            int count5=0;
            int count10=0;

            for (int i = 0; i < bills.length; i++) {
                int bill = bills[i];
                if (bill==5) {
                    count5++;
                }else if (bill==10){
                    if (count5>0){
                        count5--;
                        count10++;
                    }else{
                        return false;
                    }
                }else {
                    if (count10>0&&count5>0){

                        count10--;
                        count5--;
                    }else if (count5>2){
                        count5-=3;
                    }else{
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
