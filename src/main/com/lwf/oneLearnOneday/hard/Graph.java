package com.lwf.oneLearnOneday.hard;

import java.util.Arrays;

/**
 * 2642. 设计可以求最短路径的图类
 *
 * @author: liuwenfei
 * @date: 2024/3/26-20:05
 */
public class Graph {


    private static final int INF = Integer.MAX_VALUE / 2;

    private final int[][] g;

    public Graph(int n, int[][] edges) {
        g = new int[n][n]; // 邻接矩阵
        for (int[] row : g) {
            Arrays.fill(row, INF);
        }
        for (int[] e : edges) {
            addEdge(e);
        }
    }

    /**
     * 有向权边
     * @param e
     */
    public void addEdge(int[] e) {
        g[e[0]][e[1]] = e[2];
    }

    /**
     * dijska 算法
     * @param start
     * @param end
     * @return
     */
    public int shortestPath(int start, int end) {
        int n = g.length;
        // 从 start 出发，到各个点的最短路，如果不存在则为无穷大
        //典型的dijstka写法
        //dis保存的是所有的点到start点的距离，每次使用找到没有访问过的点集中的最近点cur，更新剩余点all的距离
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[start] = 0;
        boolean[] vis = new boolean[n];

        //进行遍历
        while (true) {
            int x = -1;
            //找到距离
            for (int i = 0; i < n; i++) {
                if (!vis[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x < 0 || dis[x] == INF) {// 所有从 start 能到达的点都被更新了
                return -1;
            }
            if (x == end) {// 找到终点，提前退出
                return dis[x];
            }
            vis[x] = true; // 标记，在后续的循环中无需反复更新 x 到其余点的最短路长度
            for (int y = 0; y < n; y++) {
                dis[y] = Math.min(dis[y], dis[x] + g[x][y]); // 更新最短路长度
            }
        }
    }


}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */

