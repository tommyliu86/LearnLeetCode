package com.lwf.learn.everyday.dp.level1.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-24 14:06
 */
public class ClimbStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n<2){
                return 1;
            }
            int i1=1;
            int i2=1;
            int i=2;
            while (i<=n){
                int temp=i2;
                i2+=i1;
                i1=temp;
                i++;
            }
            return  i2;
        }
    }
}
