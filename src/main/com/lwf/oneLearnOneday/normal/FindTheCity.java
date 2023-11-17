package com.lwf.oneLearnOneday.normal;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 1334. 阈值距离内邻居最少的城市
 * https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/?envType=daily-question&envId=2023-11-09
 *
 * @author liuwenfei
 * @date 2023/11/14 9:07
 */
public class FindTheCity {
    /**
     * Dijkstra 算法 构建一个矩阵表示图，然后查找每个点和其他所有点的最小距离，然后再进行计算每个点的符合条件的情况
     */
    class Solution {
        public int findTheCity(int n, int[][] edges, int distanceThreshold) {

            int[][] matrix = new int[n][n];
            for (int[] ints : matrix) {
                Arrays.fill(ints, -1);
            }
            for (int i = 0; i < edges.length; i++) {
                int[] edge = edges[i];
                matrix[edge[0]][edge[1]] = edge[2];
                matrix[edge[1]][edge[0]] = edge[2];
            }
            int min =Integer.MAX_VALUE;
            SortedSet<Integer> sortedSet=new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int[] dis = dijkstra(matrix, i);
                int count=0;
                for (int j = 0; j < dis.length; j++) {
                    if (dis[j]<=distanceThreshold)
                        count++;
                }
                if (min>count){
                    min=count;
                    sortedSet.clear();
                    sortedSet.add(i);
                }else if (min==count){
                    sortedSet.add(i);
                }
            }

            return sortedSet.last();
        }

        private int[] dijkstra(int[][] matrix, int s) {
            int l = matrix.length;
            //初始化结果 也就是已经找到最短距离的集合
            int[] ans = new int[l];
            Arrays.fill(ans, -1);
            ans[s] = 0;

            //初始化没找过的点
            int[] notFound = new int[l];
            for (int i = 0; i < notFound.length; i++) {
                notFound[i] = matrix[s][i];
            }
            notFound[s] = -1;

            //开始遍历没找过的点，每次都会找一个点出来，因此for循环n-1次
            for (int i = 1; i < l; i++) {
                int min = Integer.MAX_VALUE;
                int minIndex = 0;
                for (int j = 0; j < notFound.length; j++) {
                    if (notFound[j] > 0 && notFound[j] < min) {
                        min = notFound[j];
                        minIndex = j;
                    }
                }

                //找到的最小距离点直接更新到结果集合
                ans[minIndex] = min;
                notFound[minIndex] = -1;
                //更新未遍历集合的距离
                for (int j = 0; j < notFound.length; j++) {
                    //使用minIndex到 notFound中的点有连接+点不在结果中，则可以math.min
                    if (ans[j] == -1 && matrix[minIndex][j] > 0) {
                        int newDis = min + matrix[minIndex][j];

                        notFound[j] = Math.min(newDis, notFound[j] == -1 ? Integer.MAX_VALUE : notFound[j]);
                    }
                }

            }
            return ans;
        }


    }
}
