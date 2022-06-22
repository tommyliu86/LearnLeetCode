package com.lwf.learn.everyday.arith.first.d2;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-15 13:54
 */
public class firstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution {
        public int firstBadVersion(int n) {
            int half = half(n, 1, n);
            if (isBadVersion(half)) {
                return half;
            }else{
                return half+1;
            }
        }
        //找第一个错的 错的必然存在的情况下
        public int half(int n,int l,int r){
            if (l>=r){
                return l;
            }
            int m=(r-l)/2 +l;
            if (isBadVersion(m)){
                return half(n,l,m);
            }else{
                return half(n,m+1,r); //如果不变大，则会有可能进入死循环，比如 0，1 mid=0，导致m r==0，1
            }
        }
        //返回true为bad
        boolean isBadVersion(int i) {
            return false;
        }
    }
}
