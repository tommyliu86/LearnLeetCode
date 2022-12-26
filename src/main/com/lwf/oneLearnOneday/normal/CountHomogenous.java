package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2022/12/26 9:06
 */
public class CountHomogenous {
    class Solution {
        public int countHomogenous(String s) {
            long mod=1000000007;
            long sum=0;
            int l=0;
            int r=0;
            while (r<s.length()){
                while (r<s.length()&&s.charAt(l)==s.charAt(r)){
                    r++;
                }
               sum+= (long) (r-l)*(r-l+1)/2;

                l=r;
            }
            sum%=mod;
            return (int) sum;
        }
    }
}
