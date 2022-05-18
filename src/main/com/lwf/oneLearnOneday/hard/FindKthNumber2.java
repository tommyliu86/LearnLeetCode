package com.lwf.oneLearnOneday.hard;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-05-18 09:07
 */
public class FindKthNumber2 {
    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int left=1;
            int right=m*n;
            while (left<right){
                int mid=(left+right)/2;
                int count = count(m, n, mid);
                 if (count>=k){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            return left;
        }

        /**
         * 计算小于等于k的有多少个
         * @param m
         * @param n
         * @param k
         * @return
         */
        public int count(int m,int n,int k){
            int c=n* (k/n);
            for (int i =1+ (k / n); i <=m ; i++) {
               c+= k/i;
            }
            return c;
        }
    }
}
