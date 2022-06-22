package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-13 13:37
 */
public class HeightChecker {
    class Solution {
        public int heightChecker(int[] heights) {
            int[] ints = Arrays.copyOf(heights, heights.length);
            Arrays.sort(ints);
            int count=0;
            for (int i = 0; i < heights.length; i++) {
                if (heights[i]!=ints[i]){
                    count++;
                }
            }
            return count;
        }
    }
    class Solution1 {
        /**
         * 先遍历一遍，找到所有高度的个数，按照这个可以对照原高度进行比较
         * @param heights
         * @return
         */
        public int heightChecker(int[] heights) {
            int[] sums=new int[101];
            for (int i = 0; i < heights.length; i++) {
                sums[heights[i]]++;
            }
            int count=0;
            int is=0;
            for (int i = 0; i < heights.length; ) {
                while (sums[is]==0){
                    is++;
                }
                while (sums[is]>0){
                    sums[is]--;
                    if (heights[i++]!=is) {
                        count++;
                    }

                }
            }
            return count;
        }
    }
}
