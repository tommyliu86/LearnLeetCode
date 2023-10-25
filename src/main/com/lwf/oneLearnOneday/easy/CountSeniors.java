package com.lwf.oneLearnOneday.easy;

/**
 * @author liuwenfei
 * @date 2023/10/24 9:06
 */
public class CountSeniors {
    class Solution {
        public int countSeniors(String[] details) {
            int ans=0;
            for (String detail : details) {
                ans+=  ((detail.charAt(11)-'0')*10+(detail.charAt(12)-'0'))>60?1:0;
            }
            return ans;
        }
    }
}
