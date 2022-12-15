package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2022/12/15 9:18
 */
public class GetLucky {
    class Solution {
        public int getLucky(String s, int k) {
            int count=1;
            int sum=0;
            for (int i = 0; i < s.length(); i++) {
                int cur = s.charAt(i) - 'a' + 1;
                while (cur!=0){
                   sum+=( cur%10);
                   cur/=10;
                }
            }
            int ans=sum;
            while (count<k){
                sum=ans;
                ans=0;
                count++;
                while (sum!=0){
                    ans+=( sum%10);
                    sum/=10;
                }

            }
            return ans;
        }
    }
}
