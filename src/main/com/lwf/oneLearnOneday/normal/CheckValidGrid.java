package com.lwf.oneLearnOneday.normal;

/**
 * @author liuwenfei
 * @date 2023/9/13 8:40
 */
public class CheckValidGrid {
    /**
     * 深度优先遍历，注意边界条件。 cur==n*n-1
     */
    class Solution {
        public boolean checkValidGrid(int[][] grid) {
            int[] steps = new int[]{2, 1, -2, -1, 2, -1, -2, 1, 2};
            int n = grid.length;
            int x = 0, y = 0, cur = 0;
            boolean match = grid[x][y]==cur;
            while (match&&cur<n*n-1) {

                boolean find=false;
                for (int i = 0; i < steps.length - 1; i++) {
                    int nx = x + steps[i];
                    int ny = y + steps[i + 1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == cur+1) {
                        x = nx;
                        y = ny;
                        find=true;
                        cur++;
                        break;
                    }
                }
                match=find;
            }
            return  cur==n*n-1;
        }
    }
}
