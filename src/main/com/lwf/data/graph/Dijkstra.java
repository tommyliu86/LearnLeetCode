package com.lwf.data.graph;

/**
 * 图 中找到两个点之间的最短边的算法
 * https://zhuanlan.zhihu.com/p/338414118
 *
 * @author liuwenfei
 * @date 2023/11/14 9:46
 */
public class Dijkstra {
    /**
     *
     * @param graph 图的矩阵表示
     * @param startVertex 出发点，一般使用第一个点即可
     * @return 返回的是 startVertex出发点到其他所有点的最短距离，自身到自身的距离是0
     */
    public static int[] dijkstra(int[][] graph, int startVertex) {
        //初始化 以求出最短路径的点 result[]
        int length = graph.length;
        //初始化没有链接的距离是-1
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = -1;
        }
        //0到0的距离是0
        result[startVertex] = 0;
        // 初始化 未求出最短路径的点 notFound[]
        int[] notFound = new int[length];
        for (int i = 0; i < length; i++) {
            notFound[i] = graph[startVertex][i];
        }
        //使用-1表示这个点已经使用过了
        notFound[startVertex] = -1;
        // 开始 Dijkstra 算法
        for (int i = 1; i < length; i++) {
            //1. 从「未求出最短路径的点」notFound 中取出 最短路径的点
            //1.1 找到最短距离的点
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int j = 0; j < length; j++) {
                if (notFound[j] > 0 && notFound[j] < min) {
                    min = notFound[j];
                    minIndex = j;
                }
            }
            //1.2 将最短距离的点 取出 放入结果中
            result[minIndex] = min;
            notFound[minIndex] = -1;
            //2. 刷新 「未求出最短距离的点」 notFound[] 中的距离
            //2.1 遍历刚刚找到最短距离的点 (B) 的出度 (BA、BB、BC、BD)
            for (int j = 0; j < length; j++) {
                // 出度可通行(例如 BD:graph[1][3]  > 0)
                // 出度点不能已经在结果集 result中(例如 D: result[3] == -1)
                if (graph[minIndex][j] > 0 && result[j] == -1) {
                    //每次使用本次找到的最小距离点，去更新所有还未使用的点的距离。
                    int newDistance = result[minIndex] + graph[minIndex][j];
                    //通过 B 为桥梁，刷新距离
                    //（比如`AD = 6 > AB + BD = 4` 就刷新距离）（ -1 代表无限大）
                    if (newDistance < notFound[j] || notFound[j] == -1) {
                        notFound[j] = newDistance;
                    }
                }
            }

        }
        return result;
    }

    /**
     * 测试案例
     */
    public static void main(String[] args) {
        char[] vertices = new char[]{'A', 'B', 'C', 'D'};
        int[][] graph = new int[][]{
                {0, 2, -1, 6}
                , {2, 0, 3, 2}
                , {-1, 3, 0, 2}
                , {6, 2, 2, 0}};
        int[] dijkstra = dijkstra(graph, 0);
        for (int i : dijkstra) {
            System.out.println(i);
        }
    }
}
