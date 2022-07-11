package com.lwf.learn.everyday.half;

public class IsPerfectSquare {
    class Solution {
        public boolean isPerfectSquare(int num) {
            int l=1;
            int r=num;
            while(l<=r){
                int m=l+(r-l)/2;
                if(num%m==0&&num/m==m){
                    return true;
                }else if(num/m>m) {
                    l=m+1;
                }else{
                    r=m-1;
                }
            }
            return false;
        }
    }
}
