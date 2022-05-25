package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-23 18:02
 */
public class Tribonacci {
    class Solution {
        public int tribonacci(int n) {
            if (n<2){
                return n;
            }
            int pre1=0;
            int pre=1;
            int cur=1;

            int i=2;
            while (i<n){
                i++;
                int tempC=cur;
                int tempP=pre;
                cur+=pre+pre1;
                pre=tempC;
                pre1=tempP;
            }
            return cur;
        }
    }
}
