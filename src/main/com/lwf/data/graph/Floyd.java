package com.lwf.data.graph;

/**
 * @author liuwenfei
 * @date 2023/11/16 14:41
 */
public class Floyd {

    /**
     * floyd 算法通过 递归、递推，来直接计算指定的两个点之间的最短边，其核心思想是dp的状态转移方程，通过枚举两个点之间的剩余所有点，
     * 从大到小把问题拆分成更小的子问题，floyd(k,i,j)=math.min(floyd(k-1,i,j),floyd(k-1,i,k)+floyd(k-1,k,j)
     * 思路：假设 （i，j）之外剩余的点的集合，最大点是k，则我们可以有：
     * 1. 最短路径通过点k，则这条路径的最短 是floyd（k-1，i，k）+floyd（k-1，k，j） 此时拆分成了两个子问题
     * 2. 最短路径不通过k，则剩余点集合 去除了k，最大值变成了k-1，因此最短路径变成了 floyd（k-1，i，j）
     *
     * @param graph 两个点之间的邻接矩阵表示
     * @param i     点i
     * @param j     点j
     * @param k     剩余集合中的最大值
     * @return 返回计算到的i到j的最短路径
     */
    public int floyd(int[][] graph, int i, int j, int k) {
        if (k < 0) {
            return graph[i][j];
        }
        return Math.min(floyd(graph, i, j, k - 1), floyd(graph, i, k, k - 1) + floyd(graph, k, j, k - 1));
    }

    /**
     * 递归+记忆化
     *
     * @param graph
     * @param i
     * @param j
     * @param k
     * @param memory
     * @return
     */
    public int floyd1(int[][] graph, int i, int j, int k, int[][][] memory) {
        if (k < 0) {
            return graph[i][j];
        }
        if (memory[i][j][k] > 0) {
            return memory[i][j][k];
        }
        int min = Math.min(floyd(graph, i, j, k - 1), floyd(graph, i, k, k - 1) + floyd(graph, k, j, k - 1));
        memory[i][j][k] = min;
        return min;
    }

    /**
     * 递推写法
     *
     * @param graph 表示原始的矩阵
     * @return 表示 i，j之间的最小路径
     */
    public int[][] floyd2(int[][] graph) {
        int n = graph.length;
        //其中的第一维表示的是可访问的元素最大值，这里的递推因为每次k变大之后，都会使用原来的k-1的值，因此我们使用三维数组来进行记忆化
        //n+1,为什么是n+1，因为从递归上来做的时候，边界条件是k=-1，而在递推中，没有k=-1，因此我们使用k==0来作为初始化，这样的话，k需要变大一位
        int[][][] minMatrix = new int[n + 1][n][n];
        minMatrix[0] = graph;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //把从顶向下变成了从低向上，变成了一个dp算法。
                    minMatrix[k + 1][i][j] = Math.min(minMatrix[k][i][j], minMatrix[k][i][k] + minMatrix[k][k][j]);
                }
            }
        }
        return minMatrix[n];
    }
}
