package com.lwf.oneLearnOneday.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2103. 环和杆
 * https://leetcode.cn/problems/rings-and-rods/submissions/?envType=daily-question&envId=2023-10-30
 * @author liuwenfei
 * @date 2023/11/2 18:56
 */
public class CountPoints {
    class Solution {
        public int countPoints(String rings) {
            int[] counts=new int[10];

            for (int i = 0; i < rings.length(); i+=2) {
                char c = rings.charAt(i);
                int color=c=='R'?0:c=='G'?1:2;
                int index = rings.charAt(i + 1) - '0';
                counts[index]|=1<<color;
            }
            int ans=0;
            for (int count : counts) {
                ans+=count==7?1:0;
            }
            return ans;
        }
    }
}
