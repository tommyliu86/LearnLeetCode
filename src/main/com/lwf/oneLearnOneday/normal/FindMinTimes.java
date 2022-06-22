package com.lwf.oneLearnOneday.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-06-14 16:52
 */
public class FindMinTimes {
    public static void main(String[] args) {
        int[][] t = new int[][]{
                {1, 0, 1, 2},
                {1, 0, 1, 1},
                {1, 1, 1, 1},
                {1, 0, 1, 2},
        };
        int minTime = findMinTime(t);
        System.out.println(minTime);
        int[][] t1=new int[][]{
                {1,0,1,2},
                {1,0,1,1},
                {1,0,1,1},
                {1,0,1,2},
        };
        count=0;
        int minTime1 = findMinTime(t1);
        System.out.println(minTime1);
    }

    public static int findMinTime(int[][] matrix) {
        List<int[]> p2 = new ArrayList<int[]>();


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 2) {
                    p2.add(new int[]{i, j});
                } else if (matrix[i][j]==0){
                    count++;
                }
            }
        }
        if (p2.size() == 0) {
            return -1;
        }
        int times = bfs(matrix, p2);
        if (count == matrix.length * matrix[0].length) {
            return times-1;
        } else {
            return -1;
        }
    }

    static int count = 0;

    public static int bfs(int[][] matrix, List<int[]> points) {
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < points.size(); i++) {
            queue.add(points.get(i));
        }
        int times = 0;
        while (!queue.isEmpty()) {
            times++;
            int size = queue.size();
            count += size;
            for (int i = 0; i < size; i++) {
                int[] pop = ((LinkedList<int[]>) queue).pop();
                for (int j = 0; j < 4; j++) {
                    int newx = pop[0] + xstep[j];
                    int newy = pop[1] + ystep[j];
                    if (newx >= 0 && newx < m && newy >= 0 && newy < n && matrix[newx][newy] == 1) {
                        matrix[newx][newy] = 2;
                        queue.add(new int[]{newx, newy});
                    }
                }
            }
        }
        return times;
    }

   static int[] xstep = new int[]{-1, 1, 0, 0};
   static int[] ystep = new int[]{0, 0, -1, 1};
}
