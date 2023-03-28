package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2023/3/20 18:12
 */
public class CountDigitOne {
    class Solution {
        /**
         * 数位数的关系，数位dp的简化版本
         * @param n
         * @return
         */
        public int countDigitOne(int n) {
            int i=1;
            int ans=0;
            while (i<=n){
                int pre=n/i;
                int cur=pre%10;
                pre=pre/10;
                int post=n%i;
                if (cur>1){
                    ans+=(pre+1 )*i;
                }else if (cur==1){
                    ans+=(pre)*i+post+1;
                }else{
                    ans+=pre*i;
                }

                i*=10;
            }
            return ans;
        }
    }
}
