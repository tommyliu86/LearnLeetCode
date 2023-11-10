package com.lwf.oneLearnOneday.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2258. 逃离火灾
 * https://leetcode.cn/problems/escape-the-spreading-fire/?envType=daily-question&envId=2023-11-09
 *
 * @author liuwenfei
 * @date 2023/11/9 8:37
 */
public class MaximumMinutes {
    /**
     * 二分查找+广度优先遍历 bfs
     * 广度优先遍历 bfs，可以知道每个时间点的时候的火的扩散情况， 注意！前面这句话是惯性思维的想法，仔细想想，我们不是要通过时间这个维度来进行计算啊
     * 这里就需要转变思路，通过bfs我们还可以知道什么？我们可以获取到每个节点的着火时间，
     * 知道每个节点的安全时间之后，我们需要做的就是找人走到终点的路径问题。是否可以同行的判断是当前时间<fire(i)
     */
    public static void main(String[] args) {
        new Solution().maximumMinutes(new int[][]{{0,2,0,0,1},{0,2,0,2,2},{0,2,0,0,0},{0,0,2,2,0},{0,0,0,0,0}});
    }
    static class Solution {
        int[] steps = new int[]{0, 1, 0, -1, 0};
        int m, n;

        public int maximumMinutes(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            //0 表示墙或者火不会烧到，其他数字表示火会烧到的时间+1
            int[][] times = new int[m][n];
            //广度优先遍历 找到每个节点的着火时间
            bfs(times, grid);

            //二分查找，找到安全的时间点
            int i=0,j=m*n;
            while (i<=j){
                int m=i+(j-i)/2;
                if (walk(times,grid,m)){
                    i=m+1;
                }else{
                    j=m-1;
                }
            }
            return j>=m*n?1000_000_000:j;
        }
        //这里的边界条件考虑：到达安全点的时间是5分钟，火也是5分钟烧起来，那是安全还是不安全。。。在路径上，是不安全的，在安全屋是安全的
        //这里可以考虑换一种方法判断着火时间
        public boolean walk(int[][] times, int[][] grid, int t) {
            Queue<int[]> queue = new LinkedList<>();
            int[][] marks=new int[m][n];
            marks[0][0]=1;
            queue.offer(new int[]{0, 0});
            boolean ans = false;
            while (!ans&&!queue.isEmpty()) {
                t++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    if (cur[0] == m - 1 && cur[1] == n - 1) {
                        ans = true;
                        break;
                    }
                    for (int j = 0; j < steps.length - 1; j++) {
                        int x = cur[0] + steps[j];
                        int y = cur[1] + steps[j + 1];
                        if (x==m-1&&y==n-1&&grid[x][y]==0&&times[x][y]-1>=t){
                            ans=true;
                            break;
                        }
                        if (x >= 0 && x < m && y >= 0 && y < n&&marks[x][y]==0 && grid[x][y] == 0 && ( times[x][y] == 0||times[x][y]-1 > t )) {
                            queue.offer(new int[]{x, y});
                            marks[x][y]=1;
                        }
                    }
                }
            }
            return ans;
        }

        public void bfs(int[][] times, int[][] grid) {
            Queue<int[]> queue = new LinkedList<>();
            int t = 1;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1){
                        queue.offer(new int[]{i, j});
                        times[i][j] = t;
                    }
                }
            }

            while (!queue.isEmpty()) {
                t++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();
                    for (int j = 0; j < steps.length - 1; j++) {
                        int x = cur[0] + steps[j];
                        int y = cur[1] + steps[j + 1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0 && times[x][y] == 0) {
                            queue.offer(new int[]{x, y});
                            times[x][y] = t;
                        }
                    }
                }
            }
        }
    }
}
