package com.lwf.arithmetic.level2.number;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-13 17:57
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            int half = half(x, 1, x);
            if (half<=x/half){
                return half;
            }else{
                return half-1;
            }
        }
        public int half(int x,int l,int r){
            if (l>=r){
                return l;
            }
            int m=(r-l)/2+ l;
            if (m==x/m){
                return m;
            }else if (m<x/m){
                return half(x,m+1,r);
            }else{
                return half(x,l,m-1);
            }
        }
    }
}
