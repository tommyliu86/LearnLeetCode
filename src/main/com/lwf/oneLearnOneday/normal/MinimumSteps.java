package com.lwf.oneLearnOneday.normal;

/**
 * 2938. 区分黑球与白球
 *
 * @author: liuwenfei
 * @date: 2024/6/6-10:05
 */
public class MinimumSteps {
    /**
     * 选择排序，直接移动0到左侧，统计
     */
    class Solution {
        public long minimumSteps(String s) {
            long ans=0;
            int i=0,j=0;
            while (j<s.length()){
                //找到的0，需要放到i
                if (s.charAt(j)=='0') {
                    ans+=j-i;
                    j++;
                    i++;
                }else{
                    j++;
                }
            }
            return ans;
        }
    }
}
