package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * @author liuwenfei
 * @date 2023/4/25 8:56
 */
public class SortPeople {
    class Solution {
        public String[] sortPeople(String[] names, int[] heights) {
            Integer[] indez=new Integer[heights.length];
            for (int i = 0; i < indez.length; i++) {
                indez[i]=i;
            }
            Arrays.sort(indez,(a,b)->Integer.compare(heights[b],heights[a]));
            String[] ans=new String[names.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i]=names[ indez[i]];
            }
            return ans;
        }
    }
}
