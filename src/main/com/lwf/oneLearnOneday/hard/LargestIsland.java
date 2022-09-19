package com.lwf.oneLearnOneday.hard;

import java.util.*;

/**
 * @author liuwenfei
 * @date 2022/9/18 19:14
 */
public class LargestIsland {
    public static void main(String[] args) {
        new Solution().largestIsland(new int[][]{{1,0},{0,1}});
    }
 static    class Solution {
        int[] xstep=new int[]{-1,1,0,0};
        int[] ystep=new int[]{0,0,-1,1};
        public int largestIsland(int[][] grid) {

            Map<Integer,Integer> map=new HashMap<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j]==1) {
                        grid[i][j]=2;
                        Set<Integer> rounds=new HashSet<>();
                        int sum=dfs(grid,i,j,rounds);
                        if (sum==grid.length*grid.length){
                            return sum;
                        }
                        for (Integer round : rounds) {
                            map.put(round,map.getOrDefault(round,0)+sum);
                        }
                    }
                }
            }
            if (map.size()==0){
                return 1;
            }
            int rtn=0;
            for (Integer value : map.values()) {
                rtn=Math.max(rtn,value+1);
            }
            return rtn;
        }
        private int dfs(int[][] grid,int x,int y, Set<Integer> rounds){
            int sum=1;
            for (int i = 0; i < 4; i++) {
                int newx=x+xstep[i];
                int newy=y+ystep[i];
                if (newx>=0&&newx<grid.length&&newy>=0&&newy<grid.length){
                    if (grid[newx][newy]==0){
                        rounds.add(newx*1000+newy);
                    }else if (grid[newx][newy]==1){
                        grid[newx][newy]=2;
                        sum+=dfs(grid,newx,newy,rounds);
                    }
                }
            }
            return sum;
        }
    }
}
