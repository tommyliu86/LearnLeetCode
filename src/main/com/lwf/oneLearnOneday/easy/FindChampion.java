package com.lwf.oneLearnOneday.easy;

import java.util.Arrays;

/**
 * 2923. 找到冠军 I
 *
 * @author: liuwenfei
 * @date: 2024/4/12-9:19
 */
public class FindChampion {
    //行求和
    class Solution {
        public int findChampion(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                if (Arrays.stream(grid[i]).sum()==grid.length-1){
                    return i;
                }
            }
            return -1;
        }
    }
}
