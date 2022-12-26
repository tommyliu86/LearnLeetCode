package com.lwf.oneLearnOneday.hard;

/**
 * @author liuwenfei
 * @date 2022/12/25 12:05
 */
public class MinimumBoxes {
    /**
     * 类似杨辉三角，找到每层的变大规律，然后分步求 i 和j，思路清晰，解法简单，
     */
    class Solution {
        public int minimumBoxes(int n) {
            int cur=0,i=0,subSum=0;
            while (cur<n){
                i++;
                subSum+=i;
                cur+=subSum;
            }
            if (cur==n) {
                return subSum;
            }
            cur-=subSum;
            subSum-=i;
            int j=0;
            while (cur<n){
                j++;
                cur+=j;
            }
            return subSum+j;
        }
    }
}
