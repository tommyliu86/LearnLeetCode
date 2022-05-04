package com.lwf.learn.everyday.dp.day1;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-03 14:31
 */
public class Tribonacci {
    class Solution {
        public int tribonacci(int n) {
            if (n<2){
                return n;
            }
            int pp=0;
            int pre=1;
            int cur=1;
            int i=3;
            while (i<=n){
                int ccur=cur;
                int cpre=pre;
                cur+=pre+pp;
                pre=ccur;
                pp=cpre;
                i++;
            }
            return cur;
        }
    }
}
