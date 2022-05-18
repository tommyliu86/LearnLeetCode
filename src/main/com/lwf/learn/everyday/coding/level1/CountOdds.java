package com.lwf.learn.everyday.coding.level1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 15:10
 */
public class CountOdds {
    class Solution {
        public int countOdds(int low, int high) {
            if (low>0){
                low--;
                return high/2+((high&1)==1?1:0)-(low/2+((low&1)==1?1:0));
            }else{
                return high/2+((high&1)==1?1:0);
            }
        }
    }
}
