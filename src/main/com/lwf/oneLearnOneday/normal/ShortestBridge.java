package com.lwf.oneLearnOneday.normal;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author liuwenfei
 * @date 2022/10/25 8:45
 */
public class ShortestBridge {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
    static
    class Solution {
        public int shortestBridge(int[][] grid) {
            Set<int[]> boundarys = new HashSet<>();
            for (int i = 0; boundarys.size()==0&& i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        findBoundary(grid, new int[]{i, j}, boundarys);
                        break;
                    }
                }
            }
            Queue<int[]> queue = new LinkedList<>();
            int ans = 0;
            queue.addAll(boundarys);
            while (!queue.isEmpty()) {
                ans++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] poll = queue.poll();
                    for (int j = 0; j < steps.length; j++) {
                        int newX = steps[j][0] + poll[0];
                        int newY = steps[j][1] + poll[1];
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                            if (grid[newX][newY] == 1) {
                                return ans;
                            } else if (grid[newX][newY] == 0) {
                                queue.offer(new int[]{newX, newY});
                                grid[newX][newY] = 2;
                            }
                        }
                    }
                }

            }
            return ans;
        }


        int[][] steps = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        private void findBoundary(int[][] grid, int[] point, Set<int[]> boundary) {
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(point);
            grid[point[0]][point[1]]=2;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                boolean isBound = false;
                for (int i = 0; i < steps.length; i++) {
                    int newX = steps[i][0] + poll[0];
                    int newY = steps[i][1] + poll[1];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                        if (grid[newX][newY] == 1) {
                            queue.offer(new int[]{newX, newY});
                            grid[newX][newY] = 2;
                        }else if (grid[newX][newY] == 0) {
                            isBound = true;
                        }
                    }
                }
                if (isBound) {
                    boundary.add(poll);
                }
            }
        }
    }
}

