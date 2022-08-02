package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

public class CherryPickup {
    /**
     * 单独计算来回的两次最大，由于这样计算时没有考虑两个路径的相互影响，因此不是最大max
     */
    class Solution1 {
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] paths=new int[2*n-1][n][n];
            for (int i = 0; i < paths.length; i++) {
                for (int j = 0; j < paths[i].length; j++) {
                    Arrays.fill(paths[i][j],-1);
                }
            }
            paths[0][0][0]=grid[0][0];
            for (int i = 1; i < paths.length; i++) {
                for (int j = Math.max( i-n+1,0); j <=Math.min( i,n-1); j++) {
                    int ax=j;
                    int ay=i-j;
                    if (grid[ax][ay]==-1){
                        continue;
                    }
                    for (int k = Math.max( i-n+1,0); k <= j; k++) {
                        int bx=k;
                        int by=i-k;
                        if (grid[bx][by]==-1){
                            continue;
                        }
                        int pre1=paths[i-1][ax][bx];
                        if (ax>0){
                            pre1=Math.max(pre1,paths[i-1][ax-1][bx]);
                        }
                        if (bx>0){
                            pre1=Math.max(pre1,paths[i-1][ax][bx-1]);
                        }
                        if (ax>0&&bx>0){
                            pre1=Math.max(pre1,paths[i-1][ax-1][bx-1]);
                        }
                        if (pre1!=-1){

                            pre1 += grid[ax][ay];
                            if (ax != bx) {
                                pre1 += grid[bx][by];
                            }
                            paths[i][j][k] = pre1;
                        }
                    }
                }
            }
            return paths[2*n-2][n-1][n-1]==-1?-1:paths[2*n-2][n-1][n-1];
        }
    }

    /**
     * 单独计算来回的两次最大，由于这样计算时没有考虑两个路径的相互影响，因此不是最大max
     */
    class Solution {
        public int cherryPickup(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] paths = new int[m][n];
            for (int i = 0; i < paths.length; i++) {
                Arrays.fill(paths[i], -1);
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != -1) {
                        int left = i > 0 ? paths[i - 1][j] : 0;
                        int up = j > 0 ? paths[i][j - 1] : 0;
                        if (left == -1 && up == -1) {
                            continue;
                        }
                        paths[i][j] = Math.max(left, up) + grid[i][j];
                    }
                }
            }
            int max1 = paths[m - 1][n - 1];
            if (max1 == -1) {
                return 0;
            }
            int i = m - 1;
            int j = n - 1;
            int mid = max1;
            while (i > 0 || j > 0) {
                mid -= grid[i][j];
                grid[i][j] = 0;
                int left = i - 1 < 0 ? -1 : paths[i - 1][j];
                if (left == mid) {
                    i--;
                } else {
                    j--;
                }
            }
            grid[i][j] = 0;

            for (i = 0; i < grid.length; i++) {
                for (j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != -1) {
                        int left = i > 0 ? grid[i - 1][j] : 0;
                        int up = j > 0 ? grid[i][j - 1] : 0;
                        if (left == -1 && up == -1) {
                            continue;
                        }
                        grid[i][j] = Math.max(left, up) + grid[i][j];
                    }
                }
            }
            return max1 + grid[m - 1][n - 1];
        }
    }
}
